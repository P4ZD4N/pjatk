package tasks;

public class BlowingBubbles {
    public static void sort(int[] numbers) {
        int sorts;
        do {
            sorts = 0;
            for (int i = 1; i < numbers.length; i++) {
                int temp;
                if (numbers[i] < numbers[i - 1]) {
                    temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                    sorts++;
                }
            }
        } while (sorts > 0);
    }
}
