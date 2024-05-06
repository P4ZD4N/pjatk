package task2;

import java.util.Random;

public class Policeman extends Thread {

    private String firstName;
    private String district;
    private int time;

    public Policeman(String firstName, String district) {

        this.firstName = firstName;
        this.district = district;
        time = 0;

        Captain.addToPolicemanList(this);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            Random random = new Random();

            System.out.println(i + ". " + firstName + " is patrolling " + district + "!");

            int number = random.nextInt(11);

            if (number == 1) {
                Bandit.setFree(false);
                System.out.println(firstName + " caught bandit!");
            }

            try {

                int tempTime = random.nextInt(2001);

                Thread.sleep(tempTime);

                time += tempTime;
            } catch (InterruptedException e) {

                System.out.println(firstName + " interrupted work! Work time: " + getTime());
                return;
            }
        }

        System.out.println(firstName + " ends patrolling " + district + "!");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
