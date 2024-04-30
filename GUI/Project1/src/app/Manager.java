package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Receptionist {

    private static int counter = 0;

    private int id;
    private List<Team> allPastTeams = new ArrayList<>();
    private List<Task> allPastTasks = new ArrayList<>();

    public Manager(
        String firstName,
        String lastName,
        LocalDate birthDate,
        EmployeeDepartment department,
        String login,
        String password
    ) {

        super(firstName, lastName, birthDate, department, login, password);
        this.id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public List<Team> getAllPastTeams() {
        return allPastTeams;
    }

    public List<Task> getAllPastTasks() {
        return allPastTasks;
    }

    public void addPastTeam(Team team) {
        allPastTeams.add(team);
    }

    public void addPastTask(Task task) {
        allPastTasks.add(task);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName=" + super.getFirstName() +
                ", lastName='" + super.getLastName() +
                ", birthDate=" + super.getBirthDate() +
                ", department=" + super.getDepartment() +
                ", isHealthy=" + super.isHealthy() +
                ", login='" + super.getLogin() +
                ", password='" + super.getPassword() +
                ", initial='" + super.getInitial() +
                ", skills='" + super.getSkills() +
                "}";
    }
}
