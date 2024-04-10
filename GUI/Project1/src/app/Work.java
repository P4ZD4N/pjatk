package app;

import enums.Approval;
import exceptions.SickEmployeeException;
import exceptions.SickManagerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work implements Runnable {

    private static int counter = 0;
    private static Map<Integer, Work> workMap = new HashMap<>();

    private int id;
    private List<Task> tasks;
    private String description;
    private Team team;

    public Work(List<Task> tasks, String description, Team team) {

        this.id = ++counter;
        this.tasks = tasks;
        this.description = description;
        this.team = team;

        workMap.put(id, this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public static Work getWorkById(int id) {
        return Work.workMap.get(id);
    }

    @Override
    public void run() {

        isSomeoneSick();

        for (Task task : tasks) {
            if (task.getApproval() == Approval.APPROVED) {
                team.getManager().addPastTask(task);

                for (Employee employee :team.getEmployees())
                    employee.addPastTask(task);

                task.start();
            } else {
                System.out.println("Task '" + task.getTaskName() + "' is not approved!");
            }
        }
    }

    private void isSomeoneSick() {

        if (!team.getManager().isHealthy())
            throw new SickManagerException(team.getManager());

        for (Employee employee : team.getEmployees())
            if (!employee.isHealthy())
                throw new SickEmployeeException(employee);
    }
}
