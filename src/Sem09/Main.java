package Sem09;

public class Main {
    public static void main(String[] args) {
        CalcView view = new TerminalView();
        CalcController controller = new CalcController(view);
        controller.start();
    }
}
