package app;

import enums.Approval;
import enums.Status;

import java.time.LocalDateTime;
import java.util.Random;

public class Task extends Thread {

    private static int counter = 0;

    private int id;
    private String name;
    private String description;
    private Status status = Status.CREATED;
    private Approval approval;
    private int executionTime = new Random().nextInt(6) + 3;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateFinished;

    public Task(String name, String description, Approval approval) {

        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.approval = approval;
    }

    public Task(String name) {

        this.id = ++counter;
        this.name = name;
        this.description = "No description";
        this.approval = Approval.NOT_APPROVED;
    }

    public int getTaskId() {
        return id;
    }

    public void setTaskId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return name;
    }

    public void setTaskName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public LocalDateTime getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDateTime dateFinished) {
        this.dateFinished = dateFinished;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public void run() {

        status = Status.STARTED;

        while (executionTime > 0) {

            System.out.println(executionTime + " seconds remaining to complete task '" + this.getTaskName() + "'!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            executionTime--;
        }

        System.out.println("Task '" + name + "' completed!");

        status = Status.FINISHED;
        dateFinished = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name +
                ", description='" + description +
                ", status=" + status +
                ", approval=" + approval +
                ", executionTime=" + executionTime +
                ", dateCreated=" + dateCreated +
                ", dateFinished=" + dateFinished +
                '}';
    }
}
