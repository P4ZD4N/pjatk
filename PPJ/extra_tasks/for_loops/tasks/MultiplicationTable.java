package tasks;

public class MultiplicationTable {
    public static void print(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++)
                System.out.print(i * j + "\t");
            System.out.println();
        }
    }
}
