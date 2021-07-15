package Sem06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyFilter implements Filter{
    private List<Integer> indexes;

    public MyFilter() {
        indexes = new ArrayList<>();
    }

    @Override
    public int size() {
        return indexes.size();
    }

    @Override
    public boolean isPresent(int index) {
        int found = Collections.binarySearch(indexes, index);
        return found >= 0;
    }

    @Override
    public void add(int index) {
        int foundIndex = Collections.binarySearch(indexes, index);
        if(foundIndex >= 0) return;
        int newIndex = -foundIndex-1;
        indexes.add(newIndex ,index);
    }

    @Override
    public void remove(int index) {
        int foundIndex = Collections.binarySearch(indexes, index);
        if(foundIndex < 0) return;
        indexes.remove(foundIndex);
    }
}
