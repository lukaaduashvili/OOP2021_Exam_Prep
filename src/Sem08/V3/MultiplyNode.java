package Sem08.V3;

public class MultiplyNode extends BinaryOperation{

    public MultiplyNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    protected double doEvaluate(double evaluate, double evaluate1) {
        return evaluate*evaluate1;
    }

    @Override
    protected String getOperator() {
        return "*";
    }
}
