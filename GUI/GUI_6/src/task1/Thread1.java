package task1;

public class Thread1 extends Thread {

    public void run() {

        for (int i = 0; i < 10; i++)
            System.out.print(i);
    }
}
