package exceptions;

import app.Manager;

public class ManagerAsEmployeeException extends RuntimeException {

    public ManagerAsEmployeeException(Manager manager) {
        super("Manager " + manager.getFirstName() + " can't be added as an employee!");
    }
}
