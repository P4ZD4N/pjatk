public class Task11 {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        System.out.print("Enter number: ");
        int number = in.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println("");
        }
    }
}