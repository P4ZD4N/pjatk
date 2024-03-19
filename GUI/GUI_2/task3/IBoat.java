package task3;

public interface IBoat {
    default void move() {
        System.out.println("Boat is moving...");
    }
}
