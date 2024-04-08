import java.time.LocalDate;

public class Coach extends Employee {

    private String specialization;

    public Coach(String firstName, EmployeeDepartment department, LocalDate birthDate, String lastName, String specialization) {
        super(firstName, department, birthDate, lastName);
        this.specialization = specialization;
    }
}
