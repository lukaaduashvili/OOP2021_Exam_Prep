package Sem09;

public interface CalcView extends DisplayValueChangeListener{
    public void show();

    public void registerUserInputListener(UserInputListener input);
}
