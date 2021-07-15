package Sem03;

import java.util.Collection;

public class MyStack<T>{
    private Object[] elems;
    private int logLen;

    public MyStack() {
        logLen = 0;
        elems = new Object[4];
    }

    public void add(T elem) {
        if(elems.length == logLen) {
            Object[] newElems = new Object[logLen*2];
            for(int i = 0; i < elems.length; i++) {
                newElems[i] = elems[i];
            }
            elems = newElems;
            elems[logLen] = elem;
            logLen++;
        }
    }

    public T pop() {
        if(this.size() == 0) throw new IndexOutOfBoundsException();
        logLen--;
        T tmp =(T) elems[logLen];
        elems[logLen] = null;
        return tmp;
    }

    public void addAll(Collection<T> elems) {
        for(T elem: elems) {
            add(elem);
        }
    }

    public int size() {
        return logLen;
    }
}
