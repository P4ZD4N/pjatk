import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = in.nextInt();

        int temp = 1;
        for (int i = 0; i < (2 * size) + 1; i++) {
            for (int j = 0; j < (2 * size) + 1; j++) {
                if ((j >= size - i && j <= size + i && i <= size) || (j >= temp && j <= (2*size) - temp && i > size))
                    System.out.print("* ");
                else
                    System.out.print(". ");
            }
            if (i > size)
                temp++;
            System.out.println("");
        }
    }
}
