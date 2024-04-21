package task1;

public class Thread2 extends Thread {

    public void run() {

        for (int i = 0; i < 10; i++)
            System.err.print(i);
    }
}
