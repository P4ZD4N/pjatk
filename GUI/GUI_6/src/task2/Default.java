package task2;

public class Default {

    private long time;

    public void start() {

        long milisBefore = System.currentTimeMillis();

        for (int i = 0; i <= 1_000_000; i++) {
            System.out.println(i);
        }

        long milisAfter = System.currentTimeMillis();

        time = milisAfter - milisBefore;
    }

    public long getTime() {
        return time;
    }
}
