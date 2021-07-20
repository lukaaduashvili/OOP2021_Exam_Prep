package Streams_Exam;

import Sem14.Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCatalog {
    private List<Employee> employeeList;

    public EmployeeCatalog(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

    public Employee employeeWithHighestSalary(){
        return employeeList.stream().reduce((curr, employee) -> {
            if(curr == null)
                return employee;
            if(curr.getSalary() > employee.getSalary())
                return curr;
            return employee;
        }).get();
    }

    public int getSalaryGapInDepartment(Employee.Department department) {
        MinMax resu = employeeList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .map((employee -> new MinMax(employee.getSalary(), employee.getSalary())))
                .reduce((res, minMax) -> {
                    if(res == null)
                        return minMax;
                    int min = Math.min(res.getMin(), minMax.getMin());
                    int max = Math.max(res.getMax(), minMax.getMax());
                    return new MinMax(min, max);
                }).get();
        return resu.getMax()-resu.getMin();
    }

    public Employee.Department getHighestCumulativeSalary() {
        Map<Employee.Department, Integer> result =
                employeeList.stream()
                        .map(employee -> Map.of(employee.getDepartment(), employee.getSalary()))
                        .reduce((resMap, empMap) -> {
                            Map<Employee.Department, Integer> newMap = new HashMap<>();
                            newMap.putAll(resMap);
                            if(resMap == null)
                                return empMap;
                            for(Map.Entry<Employee.Department, Integer> entry: empMap.entrySet()) {
                                int val = entry.getValue();
                                if(resMap.containsKey(entry.getKey())){
                                    val += resMap.get(entry.getKey());
                                }
                                newMap.put(entry.getKey(), val);
                            }
                            return newMap;
                        }).get();
        return result.entrySet().stream()
                .reduce((currentDep, dep) -> {
                    if(currentDep == null)
                        return dep;
                    if(currentDep.getValue() > dep.getValue())
                        return currentDep;
                    return dep;
                }).get().getKey();
    }


}
