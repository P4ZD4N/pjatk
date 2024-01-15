public class ReFilter {
    public static int nextNumber = 0;
    public static int nextNumberInFilteredArray = 0;
    public static int[] filteredArray;
    public static boolean wasMethodPerformed = false;

    public static int[] reFilter(int[] numbers) {
        if (wasMethodPerformed) {
            nextNumber = 0;
            nextNumberInFilteredArray = 0;
            filteredArray = null;
            wasMethodPerformed = false;
        }

        if (nextNumber == 0)
            filteredArray = new int[countNumbersGreaterThan5(numbers)];

        if (nextNumber == numbers.length - 1) {
            if (numbers[nextNumber] > 5)
                filteredArray[nextNumberInFilteredArray] = numbers[nextNumber];
            wasMethodPerformed = true;
            return filteredArray;
        }

        if (numbers[nextNumber] > 5) {
            filteredArray[nextNumberInFilteredArray] = numbers[nextNumber];
            nextNumberInFilteredArray++;
        }

        nextNumber++;

        return reFilter(numbers);
    }

    private static int countNumbersGreaterThan5(int[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > 5) counter++;
        return counter;
    }
}
