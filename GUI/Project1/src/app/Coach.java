package app;

import app.interfaces.GoodEmployee;
import enums.Skill;
import exceptions.AlreadyOwnedSkillException;
import exceptions.MissingSkillException;

import java.time.LocalDate;

public class Coach extends Employee implements GoodEmployee {

    private static int counter = 0;

    private int id;
    private String specialization;

    public Coach(
        String firstName,
        String lastName,
        LocalDate birthDate,
        EmployeeDepartment department,
        String specialization
    ) {

        super(firstName, lastName, birthDate, department);
        this.id = ++counter;
        this.specialization = specialization;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialization() {

        return specialization;
    }

    public void setSpecialization(String specialization) {

        this.specialization = specialization;
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
            throw new MissingSkillException(employee, skill);
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
        return "Coach{" +
                "id=" + id +
                ", firstName=" + super.getFirstName() +
                ", lastName='" + super.getLastName() +
                ", birthDate=" + super.getBirthDate() +
                ", department=" + super.getDepartment() +
                ", isHealthy=" + super.isHealthy() +
                ", specialization='" + specialization +
                ", skills='" + super.getSkills() +
                "}";
    }
}
