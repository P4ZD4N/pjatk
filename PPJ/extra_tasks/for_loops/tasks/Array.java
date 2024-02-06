package tasks;

public class Array {
    public static void printReversed(int[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.println(array[i]);
    }

    public static void printReversed(double[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.println(array[i]);
    }

    public static <T> void printReversed(T[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.println(array[i]);
    }
}
