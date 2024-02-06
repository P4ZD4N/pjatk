package tasks;

public class PrimeNumbers {
    public static void printAllInRange(int start, int end) {
        int divisors = 0;
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= i; j++)
                if (i % j == 0)
                    divisors++;

            if (divisors == 2)
                System.out.println(i);

            divisors = 0;
        }
    }
}
