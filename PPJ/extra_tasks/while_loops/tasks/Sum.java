package tasks;

import java.util.Scanner;

public class Sum {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int nextNumber;
        do {
            System.out.print("Enter number: ");
            nextNumber = sc.nextInt();
            sum += nextNumber;
        } while (nextNumber != 0);

        System.out.println("Sum: " + sum);
    }
}
