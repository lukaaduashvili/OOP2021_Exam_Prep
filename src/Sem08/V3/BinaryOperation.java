package Sem08.V3;

public abstract class BinaryOperation implements Node{
    private Node left;
    private Node right;

    public BinaryOperation(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return doEvaluate(left.evaluate(), right.evaluate());
    }

    protected abstract double doEvaluate(double evaluate, double evaluate1);

    @Override
    public String toString() {
        return "(" + left.toString() + getOperator() + right.toString() + ")";
    }

    protected abstract String getOperator();

}
