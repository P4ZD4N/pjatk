package tasks;

public class FibonacciSequence {
    public static void printFibonacciNumbers(int lastNumber) {
        long currentState = 0;

        long number = 1;
        long nextNumber = 1;

        for (int i = 1; i <= lastNumber; i++) {
            if (i % 3 == 1) {
                System.out.println(currentState);
                currentState = number + nextNumber;
            } else if (i % 3 == 2) {
                System.out.println(number);
                number = nextNumber + currentState;
            } else if (i % 3 == 0) {
                System.out.println(nextNumber);
                nextNumber = number + currentState;
            }
        }
    }
}
