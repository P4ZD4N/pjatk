import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = in.nextInt();

        int sum1 = 0;
        for (int i = 1; i <= number; i++)
            sum1 += i * (i+1);

        int sum2 = 0;
        for (int i = 1; i <= number; i++)
            sum2 += (((int) Math.pow(-1, i - 1)) * ((int) Math.pow(i, 2)));

        if (sum1 == ((number*(number+1)*(number+2))/3))
            System.out.println("1. " + sum1 + " == " + ((number * (number + 1) * (number + 2)) / 3));

        if (sum2 == ((int) Math.pow(-1, number - 1) * number * (number + 1)) / 2)
            System.out.println("2. " + sum2 + " == " + (((int) Math.pow(-1, number - 1)) * number * (number + 1)) / 2);
    }
}