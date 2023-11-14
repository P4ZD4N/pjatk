import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int oddNumber = 0;

        while (oddNumber % 2 == 0) {
            System.out.print("Enter odd number: ");
            oddNumber = in.nextInt();
        }

        int spaces = 0;
        for (int i = oddNumber; i >= 1; i -= 2) {
            System.out.print(" ".repeat(spaces++));
            System.out.print("*".repeat(i));
            System.out.println("");
        }
        spaces -= 2;
        for (int i = 3; i <= oddNumber; i += 2) {
            System.out.print(" ".repeat(spaces--));
            System.out.print("*".repeat(i));
            System.out.println("");
        }
    }
}