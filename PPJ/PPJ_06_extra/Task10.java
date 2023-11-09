import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int iterations = 0;
        int same = 0;

        System.out.print("Enter number of dices: ");
        int numberOfDices = in.nextInt();

        int[] dices = new int[numberOfDices];
        int quantityOfSameScores = 0;

        while (same != 1) {
            iterations++;
            for (int i = 0; i < dices.length; i++) {
                dices[i] = (int) (Math.random() * 10);
            }
            for (int i = 0; (dices[0] == 6) && (i < dices.length); i++) {
                if (i == (dices.length - 1)) {
                    if (dices[i] == dices[i - 1])
                        quantityOfSameScores++;
                } else {
                    if (dices[i] == dices[i + 1])
                        quantityOfSameScores++;
                }
            }
            if (quantityOfSameScores == dices.length)
                same = 1;
            else
                quantityOfSameScores = 0;
            System.out.println(iterations + ". " + Arrays.toString(dices));
        }

        System.out.println("Dice rolls: " + iterations);
    }
}