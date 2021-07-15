package Sem06;

public interface Filter {
    public int size();

    public boolean isPresent(int index);

    public void add(int index);

    public void remove(int index);
}
