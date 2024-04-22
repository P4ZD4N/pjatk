package task3;

public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter();

        AddingThread addingThread1 = new AddingThread(counter);
        addingThread1.start();

        AddingThread addingThread2 = new AddingThread(counter);
        addingThread2.start();

        AddingThread addingThread3 = new AddingThread(counter);
        addingThread3.start();

        while (addingThread1.isAlive() || addingThread2.isAlive() || addingThread3.isAlive());

        System.out.println("Counter.x = " + counter);
    }
}
