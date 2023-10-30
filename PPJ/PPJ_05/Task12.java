public class Task12 {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        System.out.print("Enter size of pyramid: ");
        int size = in.nextInt();


        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= size-1; j++) {
                if (!(j == i)) System.out.print((char) 42);
                else break;
            }
            System.out.println("");
        }
    }
}