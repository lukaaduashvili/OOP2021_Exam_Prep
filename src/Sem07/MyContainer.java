package Sem07;

public interface MyContainer<T> {
    int getLength();

    int get(int index);

    int add(int index);

    default int getMax() {
        int max = 0;
        for(int i = 0; i < getLength(); i++) {
            max = Math.max(get(i), max);
        }
        return max;
    }
}
