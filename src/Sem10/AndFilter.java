package Sem10;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter{
    private List<Filter> filterList;

    public AndFilter() {
        filterList = new ArrayList<>();
    }

    public void addFilter(Filter f) {
        filterList.add(f);
    }

    @Override
    public boolean filter(Student st) {
        for(Filter f: filterList) {
            if(!f.filter(st))
                return false;
        }
        return true;
    }
}
