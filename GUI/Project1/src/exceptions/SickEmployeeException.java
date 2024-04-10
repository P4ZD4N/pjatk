package exceptions;

import app.Employee;

public class SickEmployeeException extends RuntimeException {

    public SickEmployeeException(Employee sickEmployee) {
        super("Employee " + sickEmployee.getFirstName() + " is sick!");
    }
}
