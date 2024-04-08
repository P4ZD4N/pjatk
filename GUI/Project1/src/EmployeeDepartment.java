import exceptions.NotUniqueNameException;

import java.util.HashSet;

public class EmployeeDepartment {

    private String name;
    private static HashSet<String> existingDepartmentNames = new HashSet<>();

    private EmployeeDepartment(String name) {
        this.name = name;
    }

    public static EmployeeDepartment createDepartment(String departmentName) {

        if (existingDepartmentNames.contains(departmentName)) {
            throw new NotUniqueNameException(departmentName);
        }

        existingDepartmentNames.add(departmentName);

        return new EmployeeDepartment(departmentName);
    }

    public void printEmployees() {

    }
}
