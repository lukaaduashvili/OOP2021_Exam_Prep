package Sem10;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStudentStore implements StudentStore{
    private List<Student> students;

    public ArrayListStudentStore() {
        this.students = new ArrayList<>();
    }

    @Override
    public void add(Student st) {
        students.add(st);
    }

    @Override
    public List<Student> filter(Filter f) {
        List<Student> res = new ArrayList<>();
        for(Student st: students) {
            if(f.filter(st))
                res.add(st);
        }
        return res;
    }
}
