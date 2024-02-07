package tasks.drawings;

public class Plus {
    public static void print(int size) {
        if (size % 2 != 0) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    if (i == size / 2 + 1 || j == size / 2 + 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        } else
            throw new IllegalArgumentException("Enter odd number as an argument!");
    }
}