package antlr.PL0;

public class Quadruple {
    String operator;
    String operand1;
    String operand2;
    private String result;

    public Quadruple(String operator, String operand1, String operand2, String result) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    @Override
    public String toString() {
        return operator + ", " + operand1 + ", " + operand2 + ", " + result;
    }
}
