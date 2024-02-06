package tasks;

public class OddNumbers {
    public static void inRange(int start, int end) {
        for (int i = start; i <= end; i++)
            if (i % 2 != 0)
                System.out.println(i);
    }
}
