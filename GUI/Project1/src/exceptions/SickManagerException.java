package exceptions;

import app.Manager;

public class SickManagerException extends RuntimeException {

    public SickManagerException(Manager sickManager) {
        super("Manager " + sickManager.getFirstName() + " is sick!");
    }
}
