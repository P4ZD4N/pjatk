package exceptions;

import app.Task;

public class TaskNotApprovedException extends RuntimeException {

    public TaskNotApprovedException(Task task) {
        super("Task '" + task.getTaskName() + "' is not approved!");
    }
}
