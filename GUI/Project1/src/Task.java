import enums.Status;

import java.time.LocalDateTime;

public class Task extends Thread {

    private String name;
    private String description;
    private Status status;
    private LocalDateTime dateCreated;
    private LocalDateTime dateFinished;
    private int executionTime;

    public Task(String name, String description, Status status) {

        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Task(String name) {
        this.name = name;
    }

}
