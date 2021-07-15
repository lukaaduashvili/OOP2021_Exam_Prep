package Sem07;

public class arrayContainer implements MyContainer{
    private int arr[];
    @Override
    public int getLength() {
        return arr.length;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int add(int index) {
        return 0;
    }
}
