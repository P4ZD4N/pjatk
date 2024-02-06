package tasks.drawings;

public class Pyramid {
    public static void printRightHalf(int height) {
        for (int i = 1; i <= height; i++) {
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }

    public static void print(int height) {
        int temp = 0;
        for (int i = 1; i <= height; i++) {
            System.out.print(" ".repeat(height - i));
            System.out.print("*".repeat(i + temp));
            temp = 1 + temp;
            System.out.println();
        }
    }

    public static void printLeftHalf(int height) {
        for (int i = 1; i <= height; i++) {
            System.out.print(" ".repeat(height - i));
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }
}
