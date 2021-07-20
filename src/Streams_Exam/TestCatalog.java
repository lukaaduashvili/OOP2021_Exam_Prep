package Streams_Exam;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCatalog extends TestCase {

    private static EmployeeCatalog catalog;

    public void setUp(){
        List<Employee> employeesList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int salary = new Random().nextInt(900) + 100;
            employeesList.add(new Employee("f","s", Employee.Department.INFRASTRUCTURE, salary));
        }
        employeesList.add(new Employee("Elon","Musk", Employee.Department.INFRASTRUCTURE, 1100));
        employeesList.add(new Employee("Elon","Musk1", Employee.Department.INFRASTRUCTURE, 90));
        employeesList.add(new Employee("Erekle","Meore", Employee.Department.DATA_SCIENCE, 100000));

        catalog = new EmployeeCatalog(employeesList);

    }

    public void testFindEmployeeWithHighestSalary(){
        Employee e = new Employee("Elon","Musk", Employee.Department.INFRASTRUCTURE, 1100);
        assertEquals(catalog.employeeWithHighestSalary().getSalary(),
                e.getSalary());
    }

    public void testGetSalaryGapInDepartment(){
        assertEquals(catalog.getSalaryGapInDepartment(Employee.Department.INFRASTRUCTURE), 1010);
    }

    public void testFindDepartmentWithHighestCumulativeSalary(){
        assertEquals(catalog.getHighestCumulativeSalary(), Employee.Department.DATA_SCIENCE);
    }
}