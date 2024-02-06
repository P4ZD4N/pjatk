package tasks.drawings;

public class Rectangle {
    public static void printWithFilling(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void printWithoutFilling(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height || j == 1 || j == width)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
