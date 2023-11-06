import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your student's ID: ");
        int studentID = in.nextInt();

        int sum = 0;

        for (int i = 1; i <= studentID; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}