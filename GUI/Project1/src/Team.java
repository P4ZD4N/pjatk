import java.util.List;

public class Team {

    private String name;
    private String manager;
    private List<Employee> employees;

    public Team(String name, String manager, List<Employee> employees) {
        this.name = name;
        this.manager = manager;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {

        if (employee instanceof Manager) {
            throw new IllegalArgumentException();
        }

        employees.add(employee);
    }

    public void addEmployees(List<Employee> newEmployees) {

        for (Employee employee : newEmployees) {
            if (employee instanceof Manager) {
                throw new IllegalArgumentException();
            }
        }

        employees.addAll(newEmployees);
    }
}
