package tasks;

import java.util.Scanner;

public class GuessNumber {
    public static void play() {
        Scanner sc = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1;

        int userNumber = 0;
        int attempts = 0;

        while (userNumber != randomNumber) {
            System.out.print("Enter number: ");
            userNumber = sc.nextInt();

            if (userNumber > randomNumber) {
                System.out.println("Too big!");
                attempts++;
            } else if (randomNumber > userNumber) {
                System.out.println("Too small!");
                attempts++;
            } else
                System.out.println("This is " + userNumber + "! You won after " + ++attempts + " attempts!");
        }
    }
}
