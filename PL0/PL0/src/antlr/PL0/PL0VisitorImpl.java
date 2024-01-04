package antlr.PL0;
import PL0.PL0Parser;

import java.util.ArrayList;
import java.util.List;

public class PL0VisitorImpl<T> extends PL0.PL0BaseVisitor<T> {
    private List<Quadruple> quadruples = new ArrayList<>();//四元式链表
    private List<Integer> jumpTargets = new ArrayList<>();//需要回填四元式地址
    private List<Integer> destination = new ArrayList<>();//目标回填地址

    private int getNextQuad() {
        return quadruples.size() + 1;
    }//获取下一个四元式地址

    private void addQuadruple(String operator, String operand1, String operand2, String result) {
        quadruples.add(new Quadruple(operator, operand1, operand2, result));
    }//添加四元式

    private void backpatch(int jumpTarget, int targetLine) {
        jumpTargets.add(jumpTarget - 1);
        destination.add(targetLine);
    }//回填

    public List<Quadruple> getQuadruples() {
        // Backpatch jump targets
        for (int i = 0; i < jumpTargets.size(); i++) {
            Quadruple quad = quadruples.get(jumpTargets.get(i));//回填
            quadruples.set(jumpTargets.get(i), new Quadruple(quad.operator, quad.operand1, quad.operand2, destination.get(i)+99+""));
        }
        return quadruples;
    }//获取所有四元式并完成回填

    //const_def: id ':=' unsigned_int;
    @Override
    public T visitConst_def(PL0Parser.Const_defContext ctx) {
        addQuadruple(":=",ctx.unsigned_int().getText(),"_",ctx.id().getText());
        return null;
    }


    //item:factor|item mul factor;
    @Override
    public T visitItem(PL0Parser.ItemContext ctx) {
        if(ctx.mul()!=null){
            String tem_item =(String) visit(ctx.item());
            String tem_factor=(String) visit(ctx.factor());
            String tempVariable = generateTemporaryVariable();
            addQuadruple(ctx.mul().getText(),tem_item,tem_factor,tempVariable);
            return (T) tempVariable;
        }
        else{
            String tempVariable = (String) visit(ctx.factor());
            return (T) tempVariable;
        }
    }

    //factor:id|unsigned_int|'('expression')';
    @Override
    public T visitFactor(PL0Parser.FactorContext ctx) {
        if(ctx.id()!=null){
            return (T) ctx.id().getText();
        }
        else if(ctx.unsigned_int()!=null){
            return (T) ctx.unsigned_int().getText();
        }
        else{
            String tem_expression=(String) visit(ctx.expression());
            String tempVariable = generateTemporaryVariable();
            addQuadruple(":=",tem_expression,"_",tempVariable);
            return (T) tempVariable;
        }
    }


    //assignment_state:id':='expression;
    @Override
    public T visitAssignment_state(PL0Parser.Assignment_stateContext ctx) {
        String tem = (String)visit(ctx.expression());
        addQuadruple(":=",tem,"_",ctx.id().getText());
        return null;
    }


    //expression:('+'|'-')?item|expression add item;
    @Override
    public T visitExpression(PL0Parser.ExpressionContext ctx) {
        if(ctx.add()!=null){
            String tem_expression=(String) visit(ctx.expression());
            String tem_item=(String) visit(ctx.item());
            String tempVariable = generateTemporaryVariable();
            addQuadruple(ctx.add().getText(),tem_expression,tem_item,tempVariable);
            return (T) tempVariable;
        }
        else {
            String tem_item=(String) visit(ctx.item());
            if(ctx.getChild(0).getText()=="+"||ctx.getChild(0).getText()=="-"){
                String tempVariable = generateTemporaryVariable();
                addQuadruple(ctx.getChild(0).getText(),"+|-",tem_item,tempVariable);
                return (T) tempVariable;
            }
            return (T) tem_item;
        }
    }

    //condition:expression relation expression;
    @Override
    public T visitCondition(PL0Parser.ConditionContext ctx) {
        String tem_cond1 = (String) visit(ctx.expression(0));
        String tem_cond2=(String) visit(ctx.expression(1));
        String tempVariable = generateTemporaryVariable();
        addQuadruple(ctx.relation().getText(),tem_cond1,tem_cond2,tempVariable);
        return (T) tempVariable;
    }

    //if_state:'IF' condition 'THEN' state;
    @Override
    public T visitIf_state(PL0Parser.If_stateContext ctx) {
        String tem_cond1 = (String) visit(ctx.condition().expression(0));
        String tem_cond2=(String) visit(ctx.condition().expression(1));
        int q = getNextQuad()+2;
        addQuadruple("j"+ctx.condition().relation().getText(),tem_cond1,tem_cond2,q+99+"");
        addQuadruple("j","_","_","_");
        q = getNextQuad()-1;
        visit(ctx.state());
        backpatch(q,getNextQuad());
        return null;
    }

    //loop_state:'WHILE' condition 'DO' state;
    @Override
    public T visitLoop_state(PL0Parser.Loop_stateContext ctx) {
        String tem_cond1 = (String) visit(ctx.condition().expression(0));
        String tem_cond2=(String) visit(ctx.condition().expression(1));
        int q1 = getNextQuad();
        addQuadruple("j"+ctx.condition().relation().getText(),tem_cond1,tem_cond2,q1+2+99+"");
        addQuadruple("j","_","_","_");
        int q = getNextQuad()-1;
        visit(ctx.state());
        addQuadruple("j","_","_",q1+99+"");
        backpatch(q,getNextQuad());
        return null;
    }

    private String generateTemporaryVariable() {
        return "T" + tempVariableCounter++;
    }

    // 在类中添加计数器，确保每个临时变量名都是唯一的
    private int tempVariableCounter = 0;
}

