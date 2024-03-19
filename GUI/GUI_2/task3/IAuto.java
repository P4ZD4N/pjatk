package task3;

public interface IAuto {
    default void move() {
        System.out.println("Auto is moving...");
    }
}
