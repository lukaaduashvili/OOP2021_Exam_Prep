package Sem05.InterFaces;

public abstract class Phone extends Electronic{
    abstract void makeCall(String number);

    void testCall(String number) {
        System.out.println("Test call " + number);
    }
}
