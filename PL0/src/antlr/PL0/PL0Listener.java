// Generated from C:/Users/86188/Desktop/PL0/PL0/src/antlr/PL0.g4 by ANTLR 4.13.1
package antlr.PL0;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PL0Parser}.
 */
public interface PL0Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PL0Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(PL0Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(PL0Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void enterProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void exitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program_start}.
	 * @param ctx the parse tree
	 */
	void enterProgram_start(PL0Parser.Program_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program_start}.
	 * @param ctx the parse tree
	 */
	void exitProgram_start(PL0Parser.Program_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#const}.
	 * @param ctx the parse tree
	 */
	void enterConst(PL0Parser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#const}.
	 * @param ctx the parse tree
	 */
	void exitConst(PL0Parser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 */
	void enterConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 */
	void exitConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_int(PL0Parser.Unsigned_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_int(PL0Parser.Unsigned_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PL0Parser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PL0Parser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(PL0Parser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(PL0Parser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#complex_state}.
	 * @param ctx the parse tree
	 */
	void enterComplex_state(PL0Parser.Complex_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#complex_state}.
	 * @param ctx the parse tree
	 */
	void exitComplex_state(PL0Parser.Complex_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(PL0Parser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(PL0Parser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#assignment_state}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_state(PL0Parser.Assignment_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#assignment_state}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_state(PL0Parser.Assignment_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(PL0Parser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(PL0Parser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PL0Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PL0Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(PL0Parser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(PL0Parser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(PL0Parser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(PL0Parser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#if_state}.
	 * @param ctx the parse tree
	 */
	void enterIf_state(PL0Parser.If_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#if_state}.
	 * @param ctx the parse tree
	 */
	void exitIf_state(PL0Parser.If_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#loop_state}.
	 * @param ctx the parse tree
	 */
	void enterLoop_state(PL0Parser.Loop_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#loop_state}.
	 * @param ctx the parse tree
	 */
	void exitLoop_state(PL0Parser.Loop_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(PL0Parser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(PL0Parser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#empty_state}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_state(PL0Parser.Empty_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#empty_state}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_state(PL0Parser.Empty_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(PL0Parser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(PL0Parser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(PL0Parser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(PL0Parser.NumContext ctx);
}