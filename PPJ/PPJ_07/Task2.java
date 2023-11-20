import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = in.nextInt();

        for (int i = 1; i <= size; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= size; j++)
                    System.out.print("* ");
            } else {
                for (int j = 1; j < size; j++)
                    System.out.print(" *");
            }
            System.out.println("");
        }
    }
}