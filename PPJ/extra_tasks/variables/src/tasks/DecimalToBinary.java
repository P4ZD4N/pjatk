package tasks;

public class DecimalToBinary {
    private static int[] binaryDigits = new int[0];

    public static void convert(long decimalNumber) {
        if (binaryDigits.length != 0)
            binaryDigits = new int[0];

        int nextDigit;
        for (int i = 0; decimalNumber > 0; i++) {
            nextDigit = (int) (decimalNumber % 2);
            addDigitToArray(nextDigit);
            decimalNumber /= 2;
        }

        displayBinaryDigit();
    }

    private static void addDigitToArray(int digit) {
        int[] binaryDigitsWithNewDigit = new int[binaryDigits.length + 1];
        for (int i = 0; i < binaryDigits.length; i++)
            binaryDigitsWithNewDigit[i] = binaryDigits[i];
        binaryDigitsWithNewDigit[binaryDigits.length] = digit;
        binaryDigits = binaryDigitsWithNewDigit;
    }

    private static void displayBinaryDigit() {
        for (int i = binaryDigits.length - 1; i >= 0; i--)
            System.out.print(binaryDigits[i]);
    }
}
