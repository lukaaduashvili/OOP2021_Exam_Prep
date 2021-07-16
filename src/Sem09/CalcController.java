package Sem09;

public class CalcController implements UserInputListener{
    private CalcBrain brain;
    private CalcView view;
    public CalcController(CalcView view) {
        brain = new CalcBrain();
        brain.registerValueChangeListener(view);
        view.registerUserInputListener(this);
        this.view = view;
    }

    public void start() {
        view.show();
    }

    @Override
    public void newUserInput(char inp) {
        if(Character.isDigit(inp)) {
            brain.newDigit(Integer.valueOf("" + inp));
        } else if ("+-*/".indexOf(inp) != -1) {
            brain.setOperator(inp);
        } else if(inp == '=') {
            brain.evaluate();
        } else if(inp == '\n') {
            //IGNORE
        } else
            throw new IllegalArgumentException("Received unexpected character: " + inp);
    }
}
