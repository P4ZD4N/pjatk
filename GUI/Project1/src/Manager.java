import java.time.LocalDate;

public class Manager extends Receptionist {

    public Manager(
        String firstName,
        EmployeeDepartment department,
        LocalDate birthDate,
        String lastName,
        String login,
        String password
    ) {

        super(firstName, department, birthDate, lastName, login, password);
    }
}
