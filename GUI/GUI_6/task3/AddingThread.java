package task3;

public class AddingThread extends Thread {

    private Counter counter;

    public AddingThread(Counter counter) {

        this.counter = counter;
    }

    public void run() {

        for (int i = 0; i < 1000; i++) {
            counter.inc(i);
        }
    }
}
