package tasks;

public class Factorial {
    private static int factorial = 1;
    private static int iteration = 1;
    private static boolean wasMethodPerformed = false;

    public static int calculate(int number) {
        if (wasMethodPerformed) {
            factorial = 1;
            iteration = 1;
            wasMethodPerformed = false;
        }

        if (iteration == number) {
            factorial *= iteration;
            wasMethodPerformed = true;
            return factorial;
        }

        factorial *= iteration;
        iteration++;

        return calculate(number);
    }
}
