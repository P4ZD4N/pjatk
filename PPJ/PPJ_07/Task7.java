import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        long[] longArray = new long[size];
        double randomNumber = Math.random() * 100;
        longArray[0] = (long) randomNumber;

        for (int i = 1; i < size; i++) {
            longArray[i] = longArray[i - 1] + 1;
        }

        for (int i = 0; i < size; i++)
            System.out.print(longArray[i] + " ");

        System.out.println(
                "Iterations to get the same state of array after implementing algorithm: " +
                        countHowManyIterationsToGetTheSameStateOfArray(longArray, size)
        );
    }
    public static int countHowManyIterationsToGetTheSameStateOfArray(long[] longArray, int size) {
        int firstRandomIndex;
        int secondRandomIndex;
        long temp;
        int iterationCounter = 0;
        int corectCounter = 0;

        while (corectCounter != size - 1) {
            iterationCounter++;
            firstRandomIndex = (int) (Math.random() * size);
            secondRandomIndex = (int) (Math.random() * size);

            temp = longArray[firstRandomIndex];
            longArray[firstRandomIndex] = longArray[secondRandomIndex];
            longArray[secondRandomIndex] = temp;

            for (int i = 1; i < size; i++)
                if (longArray[i] == longArray[i - 1] + 1)
                    corectCounter++;
            if (corectCounter != size - 1)
                corectCounter = 0;
        }
        return iterationCounter;
    }
}
