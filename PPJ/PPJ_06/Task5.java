import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int firstNumber = 0;
        int secondNumber = 0;

        while(!(secondNumber > firstNumber) || (!(100 > firstNumber) || (!(firstNumber >= 0))) || (!(100 > secondNumber) || (!(secondNumber >= 0)))) {
            System.out.print("Enter first number: ");
            firstNumber = in.nextInt();
            System.out.print("Enter second number: ");
            secondNumber = in.nextInt();
        }

        int randomNumber = (int) (Math.random() * 100);
        int counterOfFailedAttempts = 0;

        while(!(randomNumber >= firstNumber) || !(secondNumber >= randomNumber)) {
            System.out.println("Random number is: " + randomNumber);
            System.out.println("Random number is out of range [" + firstNumber + "," + secondNumber + "]");
            randomNumber = (int) (Math.random() * 100);
            counterOfFailedAttempts++;
        }

        System.out.println("Failed attempts: " + counterOfFailedAttempts);
        System.out.println("Random number: " + randomNumber);
    }
}