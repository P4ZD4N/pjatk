package tasks;

public class Number {
    public static void printReversed(int number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; number > 0; i++) {
            sb.append(number % 10);
            number /= 10;
        }

        System.out.println("Reversed number: " + sb);
    }

    public static void printSumOfDigits(int number) {
        int sum = 0;

        for (int i = 0; number > 0; i++) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("Sum: " + sum);
    }
}
