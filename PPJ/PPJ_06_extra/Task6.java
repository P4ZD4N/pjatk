import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = in.nextInt();

        int temp = number;
        int temp1 = number;
        int digitsInNumber = 0;
        int narcissisticNumber = 0;

        while (number > 0) {
            digitsInNumber++;
            number = number / 10;
        }

        while (temp > 0) {
            narcissisticNumber += Math.pow((temp % 10), digitsInNumber);
            temp = temp / 10;
        }

        if (temp1 == narcissisticNumber)
            System.out.println(temp1 + " is narcissistic number");
        else
            System.out.println(temp1 + " isn't a narcissistic number");
    }
}