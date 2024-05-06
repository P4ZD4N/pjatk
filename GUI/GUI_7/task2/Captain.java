package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Captain {

    private static List<Policeman> policemanList = new ArrayList<>();

    public static void addToPolicemanList(Policeman policeman) {

        policemanList.add(policeman);
    }

    public void startAll() throws InterruptedException {

        for (Policeman policeman : policemanList) {

            policeman.start();
        }
    }

    public void stopAll() {

        for (Policeman policeman : policemanList) {

            policeman.interrupt();
        }
    }

    public void changeShifts() throws InterruptedException {

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
}
