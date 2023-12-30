package drones;

public class RacingDrone {
    private String racingTeam;
    private int positionInRanking;
    private double weight;
    private double enginePower;

    public RacingDrone(String racingTeam, int positionInRanking, double weight, double enginePower) {
        this.racingTeam = racingTeam;
        this.positionInRanking = positionInRanking;
        this.weight = weight;
        this.enginePower = enginePower;
    }

    public static Drone[] race(Drone[] racers) {
        int droneWithBiggestEnginePower = 0;
        double enginePowerTemp = 0;

        for (int i = 0; i < racers.length; i++)
            if (racers[i].getEnginePower() > enginePowerTemp) {
                droneWithBiggestEnginePower = i;
                enginePowerTemp = racers[i].getEnginePower();
            }

        Drone[] dronesWithBiggestEnginePower = new Drone[0];
        for (Drone racer : racers) {
            if (racer.getEnginePower() == racers[droneWithBiggestEnginePower].getEnginePower()) {
                Drone[] temp = new Drone[dronesWithBiggestEnginePower.length + 1];
                for (int j = 0; j < dronesWithBiggestEnginePower.length; j++)
                    temp[j] = dronesWithBiggestEnginePower[j];
                temp[dronesWithBiggestEnginePower.length] = racer;
                dronesWithBiggestEnginePower = temp;
            }
        }

        return dronesWithBiggestEnginePower;
    }

    public void revEngine() {
        int numberOfRevs = (int) (enginePower / weight);

        for (int i = 0; i < numberOfRevs; i++)
            System.out.println("Vroom");

        System.out.println("ZOOOOM");
    }

    public static RacingDrone[] sortByPosition(RacingDrone[] racingDrones) {
        int sorts;
        RacingDrone temp;

        do {
            sorts = 0;
            for (int i = 1; i < racingDrones.length; i++) {
                if (
                        racingDrones[i - 1].positionInRanking > racingDrones[i].positionInRanking || (
                                racingDrones[i - 1].positionInRanking == racingDrones[i].positionInRanking &&
                                racingDrones[i - 1].enginePower < racingDrones[i].enginePower
                        )
                ) {
                    temp = racingDrones[i - 1];
                    racingDrones[i - 1] = racingDrones[i];
                    racingDrones[i] = temp;
                    sorts++;
                }
            }
        } while (sorts != 0);

        return racingDrones;
    }

    @Override
    public String toString() {
        return "RacingDrone{" +
                "racingTeam='" + racingTeam + '\'' +
                ", positionInRanking=" + positionInRanking +
                ", weight=" + weight +
                ", enginePower=" + enginePower +
                '}';
    }
}
