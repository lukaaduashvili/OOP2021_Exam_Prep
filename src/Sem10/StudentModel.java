package Sem10;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentModel extends AbstractTableModel {

    private StudentStore store;
    private List<Student> students;
    private Filter currFilter;

    public StudentModel(StudentStore store) {
        this.store = store;
        this.students = store.getAll();
        currFilter = new AllFilter();
    }

    public void applyFilter(Filter filter) {
        currFilter = filter;
        this.students = store.filter(filter);
        fireTableDataChanged();
    }

    public void add(Student st) {
        store.add(st);
        applyFilter(currFilter);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "First Name";
            case 1: return "Last Name";
            case 2: return "Enrollment Year";
            case 3: return "Delete";
            default: throw new RuntimeException("CANT BE HERE");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student st = students.get(rowIndex);
        switch (columnIndex) {
            case 0: return st.getFirstName();
            case 1: return st.getLastName();
            case 2: return st.getEnrollmentYear();
            case 3: return "---";
            default: throw new RuntimeException("CANT BE HERE");
        }
    }
}
