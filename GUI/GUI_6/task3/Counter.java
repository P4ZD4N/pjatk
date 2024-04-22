package task3;

public class Counter {

    private int x = 0;

    synchronized void inc(int value) {

        x += value;
    }

    public String toString() {

        return x + "";
    }
}
