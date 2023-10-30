import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        if (((number % 4 == 0) && (number % 100 != 0)) || number % 400 == 0) {
            System.out.println("This is leap year");
        } else {
            System.out.println("This is not leap year");
        }
    }
}