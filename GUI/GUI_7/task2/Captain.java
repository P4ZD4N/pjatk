package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Captain {

    private static List<Policeman> policemanList = new ArrayList<>();
    private static boolean isBanditCaught = false;

    public static void addToPolicemanList(Policeman policeman) {

        policemanList.add(policeman);
    }

    public static void startAll() throws InterruptedException {

        if (isBanditCaught) {
            isBanditCaught = false;
        }

        for (Policeman policeman : policemanList) {

            policeman.start();
            policeman.join();
        }

        if (!isBanditCaught) {
            System.out.println("Bandit still did not caught!");
        }
    }

    public static void stopAll() {

        for (Policeman policeman : policemanList) {

            policeman.interrupt();
        }
    }

    public static void changeShifts() throws InterruptedException {

        for (int i = 0; i < policemanList.size(); i++) {

            Thread.sleep(3000);

            Random random = new Random();

            int randomIndex = random.nextInt(policemanList.size());

            policemanList.get(randomIndex).interrupt();
        }
    }

    public static List<Policeman> getPolicemanList() {
        return policemanList;
    }

    public static void setIsBanditCaught(boolean isBanditCaught) {
        Captain.isBanditCaught = isBanditCaught;
    }
}
