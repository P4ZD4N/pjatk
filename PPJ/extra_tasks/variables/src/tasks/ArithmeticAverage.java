package tasks;

public class ArithmeticAverage {
    public static double getArithmeticAverage(double[] numbers) {
        double sumOfNumbers = 0D;
        for (double number : numbers)
            sumOfNumbers += number;
        return sumOfNumbers / numbers.length;
    }
}


