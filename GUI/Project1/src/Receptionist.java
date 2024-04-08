import java.time.LocalDate;

public class Receptionist extends Employee {

    private String login;
    private String password;

    public Receptionist(
            String firstName,
            EmployeeDepartment department,
            LocalDate birthDate,
            String lastName,
            String login,
            String password) {

        super(firstName, department, birthDate, lastName);
        this.login = login;
        this.password = password;
    }
}
