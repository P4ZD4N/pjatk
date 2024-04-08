import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Comparable<Employee> {

    private static List<Employee> allEmployees = new ArrayList<>();

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private EmployeeDepartment department;
    private boolean isHealthy = true;

    public Employee(String firstName, EmployeeDepartment department, LocalDate birthDate, String lastName) {
        this.firstName = firstName;
        this.department = department;
        this.birthDate = birthDate;
        this.lastName = lastName;

        allEmployees.add(this);
    }

    @Override
    public int compareTo(Employee o) {
        // JESZCZE JEDNO KRYTERIUM!!!!!!!!!!!
        return this.birthDate.getYear() - o.birthDate.getYear();
    }
}
