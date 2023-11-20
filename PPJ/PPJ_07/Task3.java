import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - 1 - i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}