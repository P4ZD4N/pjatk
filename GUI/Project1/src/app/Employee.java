package app;

import enums.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Comparable<Employee> {

    private static int counter = 0;
    private static List<Employee> allEmployees = new ArrayList<>();

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private EmployeeDepartment department;
    private boolean isHealthy = true;
    private List<Task> allPastTasks = new ArrayList<>();
    private List<Skill> skills;

    public Employee(String firstName, String lastName, LocalDate birthDate, EmployeeDepartment department, List<Skill> skills) {
        this.id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.department = department;
        this.skills = skills;

        allEmployees.add(this);
    }

    public static List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public static void setAllEmployees(List<Employee> allEmployees) {
        Employee.allEmployees = allEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public EmployeeDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EmployeeDepartment department) {
        this.department = department;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public List<Task> getAllPastTasks() {
        return allPastTasks;
    }

    public void setAllPastTasks(List<Task> allPastTasks) {
        this.allPastTasks = allPastTasks;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addPastTask(Task task) {
        allPastTasks.add(task);
    }

    protected void addSkill(Skill skill) {
        this.getSkills().add(skill);
    }

    @Override
    public int compareTo(Employee o) {

        if (this.getLastName().length() != o.getLastName().length())
            return this.getLastName().length() - o.getLastName().length();

        return this.birthDate.getYear() - o.birthDate.getYear();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", department=" + department +
                ", isHealthy=" + isHealthy +
                ", skills=" + skills +
                '}';
    }
}
