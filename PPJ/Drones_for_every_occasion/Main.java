import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // DRONE
        System.out.println("Drone:");

        Drone drone1 = new Drone(1, "Hugo", 4.5,50, 63);
        Drone drone2 = new Drone(2, "Mella", 3.75,68, 10);
        Drone drone3 = new Drone(3, "Bob", 5,45, 100);

        System.out.println(drone1.checkFlyParameters());
        drone1.fly(50);
        drone1.fly(60);
        drone1.revEngine();

        // RACING DRONE
        System.out.println("Racing Drone:");

        RacingDrone racingDrone1 = new RacingDrone("Red", 6, 3.5 , 70);
        RacingDrone racingDrone2 = new RacingDrone("Blue", 1, 3 , 78);
        RacingDrone racingDrone3 = new RacingDrone("Orange", 1, 3.5 , 72);

        System.out.println(Arrays.toString(RacingDrone.race(new Drone[] {drone1, drone2, drone3})));
        racingDrone1.revEngine();
        System.out.println(Arrays.toString(RacingDrone.sortByPosition(new RacingDrone[] {racingDrone1, racingDrone2, racingDrone3})));

        // VAMPIRE DRONE
        System.out.println("Vampire Drone:");

        VampireDrone vampireDrone1 = new VampireDrone(5, 68);

        System.out.println(drone1.toString());
        System.out.println(vampireDrone1.toString());

        vampireDrone1.drainEnergy(drone1);

        System.out.println(drone1.toString());
        System.out.println(vampireDrone1.toString());

        vampireDrone1.turnIntoBatDrone();

        System.out.println(vampireDrone1.toString());
        vampireDrone1.drainEnergy(drone2);

        // GIFT / CHRISTMAS DRONE
        System.out.println("Gift and Christmas Drone:");

        Gift gift1 = new Gift("Chocolate Bar", 5.5);
        gift1.unpack();
        gift1.prepare();
        gift1.unpack();

        ChristmasDrone christmasDrone1 = new ChristmasDrone(gift1, 5, 20);
        christmasDrone1.deliverGift();
        gift1.prepare();
        christmasDrone1.deliverGift();

        // DRONE CONTROL ROOM
        System.out.println("Drone control room:");

        DroneControlRoom droneControlRoom = new DroneControlRoom(new Drone[] {drone1, drone2, drone3}, 6);

        droneControlRoom.sortAllDrones();
        droneControlRoom.chargeAllDrones();
        droneControlRoom.sortAllDrones();

        Drone drone4 = new Drone(4, "Lilly", 2.75, 35, 80);
        droneControlRoom.addNewDrone(drone4);
        droneControlRoom.sortAllDrones();

        droneControlRoom.findMostPowerful(0, droneControlRoom.getAllDrones()[0]);

    }
}