package app.interfaces;

import app.Employee;
import enums.Skill;

public interface GoodEmployee {

    boolean isExperienced();
    boolean isVerySkillful();
    void teachEmployeeNewSkill(Employee employee, Skill skill);
    void learnNewSkill(Skill skill);
    int getManagerPotentialOnScaleOf1To10();

}
