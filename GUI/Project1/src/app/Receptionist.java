package app;

import app.interfaces.GoodEmployee;
import enums.Skill;
import exceptions.AlreadyOwnedSkillException;
import exceptions.MissingSkillException;

import java.time.LocalDate;
import java.util.List;

public class Receptionist extends Employee implements GoodEmployee {

    private static int counter = 0;

    private int id;
    private String login;
    private String password;
    private String initial;

    public Receptionist(
        String firstName,
        String lastName,
        LocalDate birthDate,
        EmployeeDepartment department,
        String login,
        String password,
        List<Skill> skills
    ) {

        super(firstName, lastName, birthDate, department, skills);
        this.id = ++counter;
        this.login = login;
        this.password = password;
        this.initial = String.valueOf(firstName.charAt(0)) + lastName.charAt(0);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
        initial = String.valueOf(firstName.charAt(0)) + initial.charAt(1);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
        initial = String.valueOf(initial.charAt(0)) + lastName.charAt(0);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Override
    public boolean isExperienced() {
        return this.getAllPastTasks().size() > 10;
    }

    @Override
    public boolean isVerySkillful() {
        return this.getSkills().size() > 10;
    }

    @Override
    public void teachEmployeeNewSkill(Employee employee, Skill skill) {

        if (!this.getSkills().contains(skill)) {
            throw new MissingSkillException(this, skill);
        }

        if (employee.getSkills().contains(skill)) {
            throw new AlreadyOwnedSkillException(employee, skill);
        }

        employee.addSkill(skill);

        System.out.println(this.getFirstName() + " taught " + employee.getFirstName() + " " + skill + " skill!");
    }

    @Override
    public void learnNewSkill(Skill skill) {

        if (this.getSkills().contains(skill)) {
            throw new AlreadyOwnedSkillException(this, skill);
        }

        this.addSkill(skill);

        System.out.println(this.getFirstName() + " learned " + skill + " skill!");
    }

    @Override
    public int getManagerPotentialOnScaleOf1To10() {

        int score = 0;

        if (this.isExperienced())
            score += 2;

        if (this.isVerySkillful())
            score += 5;

        if (getSkills().contains(Skill.LEADERSHIP))
            score += 1;

        if (getSkills().contains(Skill.PROJECT_MANAGEMENT))
            score += 1;

        if (getSkills().contains(Skill.FINANCIAL_MANAGEMENT))
            score += 1;

        return score;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "id=" + id +
                ", firstName=" + super.getFirstName() +
                ", lastName='" + super.getLastName() +
                ", birthDate=" + super.getBirthDate() +
                ", department=" + super.getDepartment() +
                ", isHealthy=" + super.isHealthy() +
                ", login='" + login +
                ", password='" + password +
                ", initial='" + initial +
                ", skills='" + super.getSkills() +
                "}";
    }
}
