package task2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Default default1 = new Default();
        default1.start();

        Thread1 thread1 = new Thread1();
        thread1.start();
        thread1.join();

        Thread1 thread2 = new Thread1();
        thread2.start();
        thread2.join();

        System.out.println();
        System.out.println("Default time: " + default1.getTime() + " ms");
        System.out.println("Thread1 time: " + thread1.getTime() + " ms");
        System.out.println("Thread2 time: " + thread2.getTime() + " ms");
    }
}
