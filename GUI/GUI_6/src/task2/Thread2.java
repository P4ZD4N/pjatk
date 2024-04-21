package task2;

public class Thread2 extends Thread {

    private long time;

    public void run() {

        long milisBefore = System.currentTimeMillis();

        for (int i = 0; i <= 1_000_000; i++)
            if (i % 2 != 0)
                System.out.print(i);

        long milisAfter = System.currentTimeMillis();

        time = milisAfter - milisBefore;
    }

    public long getTime() {
        return time;
    }
}
