import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String text;
        int encryptOrDecrypt = 0;
        int shift;

        System.out.print("Enter text: ");
            text = in.next();

        System.out.print("Text to encrypt (ENTER 1) / decrypt (ENTER 2)?: ");
        while (encryptOrDecrypt != 1 && encryptOrDecrypt != 2)
            encryptOrDecrypt = in.nextInt();

        System.out.print("Enter shift: ");
            shift = in.nextInt();

        char[] letters = text.toCharArray();

        if (encryptOrDecrypt == 1) {
            for (int i = 0; i < letters.length; i++)
                letters[i] += shift;
            System.out.println("Encrypted text: ");
            for (char letter : letters)
                System.out.print(letter);
        } else if (encryptOrDecrypt == 2) {
            for (int i = 0; i < letters.length; i++)
                letters[i] -= shift;
            System.out.println("Decrypted text: ");
            for (char letter : letters)
                System.out.print(letter);
        }
    }
}