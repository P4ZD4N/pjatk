public class Task10 {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        System.out.print("Enter number: ");
        int number = in.nextInt();

        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }
}