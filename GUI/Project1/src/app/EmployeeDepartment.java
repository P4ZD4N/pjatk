package app;

import exceptions.NotUniqueNameException;

import java.util.HashSet;
import java.util.List;

public class EmployeeDepartment {

    private static HashSet<String> existingDepartmentNames = new HashSet<>();
    private static int counter = 0;

    private int id;
    private String name;

    private EmployeeDepartment(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public static EmployeeDepartment createDepartment(String departmentName) {

        if (existingDepartmentNames.contains(departmentName)) {
            throw new NotUniqueNameException(departmentName);
        }

        existingDepartmentNames.add(departmentName);

        return new EmployeeDepartment(departmentName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HashSet<String> getExistingDepartmentNames() {
        return existingDepartmentNames;
    }

    public static void setExistingDepartmentNames(HashSet<String> existingDepartmentNames) {
        EmployeeDepartment.existingDepartmentNames = existingDepartmentNames;
    }

    public void printEmployees() {

        List<Employee> allEmployees = Employee.getAllEmployees();

        if (allEmployees.isEmpty()) {
            System.out.println("No employees!");
            return;
        }

        System.out.println("Employees of '" + this.getName() + "' department:");

        for (Employee employee : allEmployees) {
            if (employee.getDepartment().getName().equals(this.getName()))
                System.out.println(employee);
        }
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
