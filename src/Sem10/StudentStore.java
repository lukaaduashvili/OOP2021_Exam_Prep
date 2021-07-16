package Sem10;

import java.util.List;

public interface StudentStore {
    public void add(Student st);

    public List<Student> filter(Filter f);

    default public List<Student> getAll() {
        return filter(new AllFilter());
    }
}
