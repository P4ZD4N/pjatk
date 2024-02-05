package tasks;

public class NumberComparator {
    public static void compare(int firstNumber, int secondNumber) {
        if (firstNumber == secondNumber)
            System.out.println(firstNumber + " = " + secondNumber);
        else if (firstNumber > secondNumber)
            System.out.println(firstNumber + " > " + secondNumber);
        else
            System.out.println(secondNumber + " > " + firstNumber);
    }

    public static void findBiggest(int[] numbers) {
        int biggest = Integer.MIN_VALUE;

        for (int number : numbers)
            if (number > biggest)
                biggest = number;

        System.out.println("Biggest number: " + biggest);
    }

    public static void findSmallest(int[] numbers) {
        int smallest = Integer.MAX_VALUE;

        for (int number : numbers)
            if (smallest > number)
                smallest = number;

        System.out.println("Smallest number: " + smallest);
    }
}
