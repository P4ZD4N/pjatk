import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print((int)Math.pow(i, j) + " ");
            System.out.println("");
        }
    }
}