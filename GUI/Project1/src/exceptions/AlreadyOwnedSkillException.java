package exceptions;

import app.Employee;
import enums.Skill;

public class AlreadyOwnedSkillException extends RuntimeException {

    public AlreadyOwnedSkillException(Employee employee, Skill skill) {
        super(employee.getFirstName() + " already own '" + skill + "' skill!");
    }
}
