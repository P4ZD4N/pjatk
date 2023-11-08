import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter how many prime numbers should I print: ");
        int quantityOfPrimeNumbers = in.nextInt();

        int prints = 0;
        int divisors = 0;

        while (prints < quantityOfPrimeNumbers) {
            for (int i = 2; prints < quantityOfPrimeNumbers; i++) {
                for (int j = i; j >= 1; j--)
                    if (i % j == 0) divisors++;
                if (divisors == 2) {
                    System.out.println((prints + 1) + ". " + i);
                    prints++;
                    divisors = 0;
                } else
                    divisors = 0;
            }
        }
    }
}