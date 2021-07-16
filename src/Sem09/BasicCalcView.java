package Sem09;

public abstract class BasicCalcView implements CalcView{
    private UserInputListener listener;
    @Override
    public void registerUserInputListener(UserInputListener input) {
        this.listener = input;
    }

    public void notifyListeners(char inp) {
        listener.newUserInput(inp);
    }
}
