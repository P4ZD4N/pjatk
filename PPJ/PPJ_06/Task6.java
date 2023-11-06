import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        long userNumber = in.nextLong();

        long biggestDivisorWhichIsPrimeNumber = 0;

        int divisors = 0;
        for (long i = userNumber; i >= 1; i--) {
            for (long j = i; j >= 1; j--) {
                if (i % j == 0)
                    divisors++;
            }
            if (divisors == 2 && userNumber % i == 0) {
                biggestDivisorWhichIsPrimeNumber = i;
                i = 1;
            }
            divisors = 0;
        }

        System.out.println("Biggest divisor of " + userNumber + " which is also prime number: " + biggestDivisorWhichIsPrimeNumber);
    }
}