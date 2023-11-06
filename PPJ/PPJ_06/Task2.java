import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int userNumber = 1;
        int sum = 0;
        int iterations = 0;

        while (userNumber != 0) {
            System.out.print("Enter number: ");
            userNumber = in.nextInt();
            sum += userNumber;
            iterations++;
        }

        System.out.println("Number of entered numbers (including last 0): " + iterations);
        System.out.println("Sum of numbers: " + sum);
    }
}