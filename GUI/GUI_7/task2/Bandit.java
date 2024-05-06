package task2;

import java.util.List;

public class Bandit extends Thread{

    private static boolean isFree = true;
    private static Bandit bandit;

    private Bandit() {}

    public static Bandit createBandit() {

        if (bandit == null) {
            bandit = new Bandit();
        } else {
            throw new RuntimeException("Bandit already exists!");
        }

        return bandit;
    }

    @Override
    public void run() {

        while (areAllPolicemenPatrolArea()) {

            System.out.println("Bandit is still free!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean areAllPolicemenPatrolArea() {

        List<Policeman> policemanList = Captain.getPolicemanList();

        return policemanList.stream().anyMatch(Thread::isAlive);

    }

    public static boolean isFree() {
        return isFree;
    }

    public static void setFree(boolean free) {
        isFree = free;
    }
}
