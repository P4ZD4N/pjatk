package exceptions;

public class NotUniqueNameException extends RuntimeException {

    public NotUniqueNameException(String existingDepartmentName) {
        super("Department '" + existingDepartmentName + "' already exists!");
    }
}
