package App;

import Exceptions.SingletonException;

public class Kevin extends Person {
    private static Kevin instance;
    private Home home;
    private boolean hasCoat;
    private boolean isScared;
    private boolean isOutside = false;

    private Kevin(String name, String surname, int age, int lifePoints, Home home) {
        super(name, surname, age, lifePoints);
        this.home = home;
        home.setKidInside(this);
    }

    public static Kevin getInstance(String name, String surname, int age, int lifePoints, Home home) {
        if (instance == null) {
            instance = new Kevin(name, surname, age, lifePoints, home);
        } else
            throw new SingletonException("You can't create more than one object of this class!");
        return instance;
    }

    public void setUpTrap(Trap trap) {
        updateTraps(trap);
        System.out.println(trap.getName() + " created!");
    }

    public void run() {
        if (!isScared)
            System.out.println("Kevin is on the move!");
        else
            System.out.println("Kevin can't run at this moment!");
    }

    public void spook() {
        if (isScared)
            System.out.println("Kevin is already scared!");
        else {
            isScared = true;
            System.out.println("Kevin was spooked! He is scared since this moment!");
        }
    }

    public void relax() {
        if (!isScared)
            System.out.println("Kevin is already relaxed!");
        else {
            isScared = false;
            System.out.println("Kevin relaxed! He is not scared since this moment!");
        }
    }

    public void leaveHome() {
        if (!isOutside && hasCoat) {
            isOutside = true;
            System.out.println("Kevin is going outside!");
        } else if (isOutside)
            System.out.println("Kevin is outside at this moment!");
        else
            System.out.println("Kevin must put on his coat before leave home!");
    }

    public void backToHome() {
        if (isOutside) {
            isOutside = false;
            System.out.println("Kevin is going back home!");
        } else
            System.out.println("Kevin is already in home!");
    }

    public void putCoatOn() {
        if (!hasCoat) {
            hasCoat = true;
            System.out.println("Kevin put on his coat!");
        } else
            System.out.println("Kevin already has coat on him!");
    }

    public void changeHouse(Home home) {
        this.home.setKidInside(null);
        System.out.println("Kevin changed home from " + this.home.getAddress() + " to " + home.getAddress());
        this.home = home;
        this.home.setKidInside(this);
    }

    private void updateTraps(Trap trap) {
        Trap[] trapsWithNewTrap = new Trap[home.getTraps().length + 1];

        for (int i = 0; i < home.getTraps().length; i++)
            trapsWithNewTrap[i] = home.getTraps()[i];

        trapsWithNewTrap[home.getTraps().length] = trap;

        home.setTraps(trapsWithNewTrap);
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "home=" + home.getAddress() +
                ", hasCoat=" + hasCoat +
                ", isScared=" + isScared +
                ", isOutside=" + isOutside +
                '}';
    }
}
