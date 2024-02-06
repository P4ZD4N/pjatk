package tasks;

public class Array {
    public static int getBiggestElement(int[] numbers) {
        int biggest = Integer.MIN_VALUE;
        for (int number : numbers)
            if (number > biggest)
                biggest = number;
        return biggest;
    }

    public static int getSmallestElement(int[] numbers) {
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers)
            if (smallest > number)
                smallest = number;
        return smallest;
    }

    public static int getSumOfAllElements(int[] numbers) {
        int sum = 0;
        for (int number : numbers)
            sum += number;
        return sum;
    }

    public static int[] getReversed(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = numbers.length - 1, j = 0; i >= 0; i--, j++)
            reversed[j] = numbers[i];
        return reversed;
    }

    public static double getAverageOfAllElements(int[] numbers) {
        return (double) getSumOfAllElements(numbers) / numbers.length;
    }

    public static boolean isNumberInArray(int number, int[] numbers) {
        for (int numberFromArray : numbers)
            if (number == numberFromArray)
                return true;
        return false;
    }

    public static int[] getSorted(int[] numbers) {
        int sorts;
        int temp;

        do {
            sorts = 0;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                    sorts++;
                }
            }
        } while (sorts > 0);

        return numbers;
    }
}