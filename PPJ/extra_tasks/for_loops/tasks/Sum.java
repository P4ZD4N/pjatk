package tasks;

public class Sum {
    public static int of(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];
        return sum;
    }

    public static double of(double[] numbers) {
        double sum = 0;
        for (double number : numbers)
            sum += number;
        return sum;
    }
}
