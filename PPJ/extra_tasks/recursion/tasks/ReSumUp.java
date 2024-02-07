package tasks;

public class ReSumUp {
    private static int index = 0;
    private static int sum = 0;
    private static boolean wasMethodPerformed = false;

    public static int reSum(int[] numbers) {
        if (wasMethodPerformed) {
            index = 0;
            sum = 0;
            wasMethodPerformed = false;
        }

        if (index == numbers.length - 1) {
            sum += numbers[index];
            wasMethodPerformed = true;
            return sum;
        }

        sum += numbers[index++];
        return reSum(numbers);
    }
}
