package drones;

import java.util.Arrays;

public class DroneControlRoom {
    private Drone[] allDrones;
    private double windPowerOutside;

    public DroneControlRoom(Drone[] allDrones, double windPowerOutside) {
        this.allDrones = allDrones;
        this.windPowerOutside = windPowerOutside;
    }

    public int countDronesThatCanFly() {
        int dronesThatCanFly = 0;

        for (Drone drone : allDrones)
            if (drone.getEnginePower() > drone.getWeight() && drone.getBatteryLevel() > 0)
                dronesThatCanFly++;

        return dronesThatCanFly;
    }

    public void chargeAllDrones() {
        for (Drone drone : allDrones)
            drone.setBatteryLevel(drone.getBatteryLevel() + 20);
        System.out.println("Charged all drones!");
    }

    public void addNewDrone(Drone drone) {
        Drone[] dronesWithNewDrone = new Drone[allDrones.length + 1];
        for (int i = 0; i < allDrones.length; i++)
            dronesWithNewDrone[i] = allDrones[i];
        dronesWithNewDrone[allDrones.length] = drone;
        allDrones = dronesWithNewDrone;
        System.out.println("Added new drone!");
    }

    public void sortAllDrones() {
        int sorts;
        Drone tempDrone;

        do {
            sorts = 0;
            for (int i = 1; i < allDrones.length; i++) {
                if (allDrones[i - 1].getWeight() > allDrones[i].getWeight()) {
                    tempDrone = allDrones[i - 1];
                    allDrones[i - 1] = allDrones[i];
                    allDrones[i] = tempDrone;
                    sorts++;
                }
            }
        } while (sorts != 0);

        for (int i = 0; i < allDrones.length; i++)
            System.out.println(allDrones[i].toString());
    }

    public Drone findMostPowerful(int index, Drone drone) {
        Drone mostPowerful = allDrones[index];
        if (drone.getEnginePower() > mostPowerful.getEnginePower())
            mostPowerful = drone;
        if (index == allDrones.length - 1) {
            System.out.println("Most powerful " + mostPowerful);
            return mostPowerful;
        }
        return findMostPowerful(index + 1, mostPowerful);
    }

    public Drone[] getAllDrones() {
        return allDrones;
    }

    @Override
    public String toString() {
        return "DroneControlRoom{" +
                "allDrones=" + Arrays.toString(allDrones) +
                ", windPowerOutside=" + windPowerOutside +
                '}';
    }
}
