package Sem09;

public class CalcBrain {
    private char op;
    private String prevValue;
    private String currentValue;
    boolean clearInput;
    private DisplayValueChangeListener listener;

    public CalcBrain() {
        prevValue = "";
        currentValue = "";
        clearInput = true;
    }
    //0 <= digit <= 9
    public void newDigit(int digit) {
        if(clearInput) {
            prevValue = currentValue;
            currentValue = String.valueOf(digit);
            clearInput = false;
            listener.valueChanged(currentValue);
        } else {
            currentValue += String.valueOf(digit);
            listener.valueChanged(currentValue);
        }

    }

    public void setOperator(char op) {
        this.op = op;
        clearInput = true;
    }

    public void evaluate() {
        double left = Double.valueOf(prevValue);
        double right = Double.valueOf(currentValue);
        double res;
        switch (op) {
            case '+':res = left + right; break;
            case '-':res = left - right; break;
            case '*':res = left * right; break;
            case '/':res = left / right; break;
            default:
                throw new RuntimeException("Unexpected operator");
        }
        listener.valueChanged(String.valueOf(res));
        currentValue = String.valueOf(res);
    }

    public void registerValueChangeListener(DisplayValueChangeListener listener) {
        this.listener = listener;
    }

}
