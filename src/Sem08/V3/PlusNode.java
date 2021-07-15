package Sem08.V3;

public class PlusNode extends BinaryOperation{
    public PlusNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    protected double doEvaluate(double evaluate, double evaluate1) {
        return evaluate+evaluate1;
    }

    @Override
    protected String getOperator() {
        return "+";
    }
}
