package exceptions;

import app.Employee;
import enums.Skill;

public class MissingSkillException extends RuntimeException {

    public MissingSkillException(Employee employee, Skill skill) {
        super("Teaching employee (" + employee.getFirstName() + ") don't have " + skill + " skill!");
    }
}
