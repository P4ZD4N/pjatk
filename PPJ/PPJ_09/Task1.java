import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1}
        };
        int[] newArray = new int[countElements(array)];
        fillNewArray(array, newArray);
        System.out.println(Arrays.toString(newArray));
    }
    private static int countElements(int[][] array) {
        int counter = 0;
        for (int[] subArray : array)
            for (int element : subArray)
                counter++;
        return counter;
    }
    private static void fillNewArray(int[][] array, int[] newArray) {
        int index = 0;
        for (int[] subArray : array)
            for (int element : subArray) {
                newArray[index] = element;
                index++;
            }
    }
}