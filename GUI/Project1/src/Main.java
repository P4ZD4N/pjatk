import app.*;
import enums.Approval;
import enums.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDepartment abc = EmployeeDepartment.createDepartment("abc");
        EmployeeDepartment def = EmployeeDepartment.createDepartment("def");

        Coach coachJakub = new Coach(
                "Jakub",
                "Krawczyk",
                LocalDate.of(2003, 8, 1),
                abc,
                "Programming",
                List.of(Skill.TECHNICAL_KNOWLEDGE, Skill.CREATIVITY, Skill.COMMUNICATION)
        );
        Coach coachJohn = new Coach(
                "John",
                "Doe",
                LocalDate.of(2006, 12, 20),
                def,
                "Cybersecurity",
                List.of(Skill.TECHNICAL_KNOWLEDGE, Skill.CRITICAL_THINKING, Skill.PROBLEM_SOLVING)
        );

        Receptionist receptionistKuba = new Receptionist(
                "Kuba",
                "Lewandowski",
                LocalDate.of(2000, 10, 2),
                abc,
                "kubal",
                "admin123",
                List.of(Skill.COMMUNICATION, Skill.ADAPTABILITY, Skill.DECISION_MAKING, Skill.ENGLISH)
        );

        Receptionist receptionistMichal = new Receptionist(
                "Michał",
                "Wiśniewski",
                LocalDate.of(1999, 8, 15),
                def,
                "michalw",
                "admin4321",
                List.of(Skill.TEAMWORK, Skill.TEACHING, Skill.SELF_MOTIVATION)
        );

        Manager managerJulia = new Manager(
                "Julia",
                "Wilk",
                LocalDate.of(2003, 1 ,5),
                abc,
                "juliaw",
                "qwerty123",
                List.of(Skill.TECHNICAL_KNOWLEDGE,
                        Skill.CREATIVITY,
                        Skill.COMMUNICATION,
                        Skill.ADAPTABILITY,
                        Skill.LEADERSHIP,
                        Skill.TEACHING,
                        Skill.ENGLISH,
                        Skill.MENTORING,
                        Skill.FINANCIAL_MANAGEMENT,
                        Skill.FAST_LEARNING,
                        Skill.SELF_MOTIVATION
                )

        );

        Manager managerLaura = new Manager(
                "Laura",
                "Ptak",
                LocalDate.of(2005, 10 ,28),
                abc,
                "laurap",
                "AbCdEf312",
                List.of(Skill.COMMUNICATION,
                        Skill.LEADERSHIP,
                        Skill.ENGLISH,
                        Skill.MENTORING,
                        Skill.FINANCIAL_MANAGEMENT,
                        Skill.SELF_MOTIVATION
                )
        );

        Team teamX = new Team("TeamX", managerJulia, new ArrayList<>());

        teamX.addEmployee(coachJohn);
        teamX.addEmployees(List.of(coachJakub, receptionistKuba));
        abc.printEmployees();

        Team teamZ = new Team("TeamZ", managerLaura, new ArrayList<>());

        teamZ.addEmployee(coachJohn);
        teamZ.addEmployees(List.of(coachJakub, receptionistKuba));
        abc.printEmployees();

        Task task1 = new Task("Cleanup", "Clean up all desks in office", Approval.APPROVED);
        Task task2 = new Task("Eat", "Eat pizza", Approval.NOT_APPROVED);
        Task task3 = new Task("Write post", "Write post on LinkedIn", Approval.NOT_APPROVED);
        Task task4 = new Task("Code", "Code new feature", Approval.APPROVED);
        Task task5 = new Task("Check security", "Check system security", Approval.APPROVED);

        Work work = new Work(List.of(task1, task2), "Monday work", teamX);

        work.run();

        List<Employee> employees = new ArrayList<>();

        employees.add(coachJakub);
        employees.add(coachJohn);
        employees.add(receptionistKuba);
        employees.add(receptionistMichal);
        employees.add(managerJulia);
        employees.add(managerLaura);

        System.out.println(task1.getStatus());
        System.out.println(task3.getStatus());

        System.out.println(receptionistKuba.getAllPastTasks());
        System.out.println(managerLaura.getAllPastTasks());
        System.out.println(managerLaura.getManagerPotentialOnScaleOf1To10());
        System.out.println(managerJulia.getManagerPotentialOnScaleOf1To10());

    }
}