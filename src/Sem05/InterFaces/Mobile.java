package Sem05.InterFaces;

public class Mobile extends Phone{

    @Override
    public void on() {
        System.out.println("on");
    }

    @Override
    public void off() {
        System.out.println("off");
    }

    @Override
    public void plugin() {
        System.out.println("plugIn");
    }

    @Override
    void makeCall(String number) {
        System.out.println("Make call " + number);
    }
}
