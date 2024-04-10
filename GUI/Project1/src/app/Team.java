package app;

import exceptions.ManagerAsEmployeeException;

import java.util.List;

public class Team {

    private static int counter = 0;

    private int id;
    private String name;
    private Manager manager;
    private List<Employee> employees;

    public Team(String name, Manager manager, List<Employee> employees) {

        this.id = ++counter;
        this.name = name;
        this.manager = manager;

        manager.addPastTeam(this);

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                throw new ManagerAsEmployeeException(manager);
            }
        }

        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        manager.addPastTeam(this);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {

        if (employee instanceof Manager) {
            throw new ManagerAsEmployeeException(manager);
        }

        employees.add(employee);
    }

    public void addEmployees(List<Employee> newEmployees) {

        for (Employee employee : newEmployees) {
            if (employee instanceof Manager) {
                throw new ManagerAsEmployeeException(manager);
            }
        }

        employees.addAll(newEmployees);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", employees=" + employees +
                '}';
    }
}
