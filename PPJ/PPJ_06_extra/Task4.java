import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = in.nextInt();
        int divisors = 0;

        for (int i = number; i >= 1; i--) {
            if (number % i == 0) {
                divisors++;
            }
        }

        if (divisors == 2) System.out.println(number + " is a prime number");
        else System.out.println(number + " isn't a prime number");
    }
}