package App;

import java.util.Arrays;

public class Robber extends Person {
    private String[] injuries = new String[0];
    private boolean isArrested;
    private static Robber[] robbers = new Robber[0];

    public Robber(String name, String surname, int age, int lifePoints) {
        super(name, surname, age, lifePoints);
        updateRobbers();
    }

    public void rob(Home home) {
        if (home.isKidInside()) {
            int number = (int) (Math.random() * 10);

            if (this.hasEnoughLifePoints() && home.getKidInside().hasEnoughLifePoints()) {
                if (number == 0) {
                    findTrapForKevin(home);
                } else if (number > 0) {
                    findTrapForRobber(home);
                }
            } else if (!this.hasEnoughLifePoints() && home.getKidInside().hasEnoughLifePoints()) {
                System.out.println("Robber has fainted, police is on the way");
                this.isArrested = true;
            } else if (this.hasEnoughLifePoints() && !home.getKidInside().hasEnoughLifePoints()) {
                System.out.println("Kevin has been caught by The Wet Bandits");
            }
        } else
            System.out.println("Non sense! There is no any kid in this home!");
    }

    private void findTrapForKevin(Home home) {
        for (int i = 0; i < home.getTraps().length; i++) {
            Trap trap = home.getTraps()[i];

            if (trap.isActive()) {
                System.out.println("Kevin fell into his own trap! -" + trap.getDamageAmount() + "HP");

                home.getKidInside().setLifePoints(home.getKidInside().getLifePoints() - trap.getDamageAmount());

                trap.setInactive();

                break;
            }
        }
    }

    private void findTrapForRobber(Home home) {
        for (int i = 0; i < home.getTraps().length; i++) {
            Trap trap = home.getTraps()[i];

            if (i == home.getTraps().length - 1 && !trap.isActive()) {
                System.out.println("Kevin has been caught by The Wet Bandits");
            }

            if (trap.isActive()) {
                System.out.println("Robber fell into trap! -" + trap.getDamageAmount() + "HP");
                System.out.println("New injury: " + trap.getDamageDescription());

                setLifePoints(getLifePoints() - trap.getDamageAmount());

                trap.setInactive();

                updateInjuries(trap);

                break;
            }
        }
    }

    private void updateInjuries(Trap trap) {
        String[] injuriesWithNewInjury = new String[injuries.length + 1];

        for (int i = 0; i < injuries.length; i++)
            injuriesWithNewInjury[i] = injuries[i];

        injuriesWithNewInjury[injuries.length] = trap.getDamageDescription();

        injuries = injuriesWithNewInjury;
    }

    private void updateRobbers() {
        Robber[] robbersWithNewRobber = new Robber[robbers.length + 1];

        for (int i = 0; i < robbers.length; i++)
            robbersWithNewRobber[i] = robbers[i];

        robbersWithNewRobber[robbers.length] = this;

        robbers = robbersWithNewRobber;
    }

    public String[] getInjuries() {
        return injuries;
    }

    public static Robber[] getRobbers() {
        return robbers;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "injuries=" + Arrays.toString(injuries) +
                ", isArrested=" + isArrested +
                '}';
    }
}
