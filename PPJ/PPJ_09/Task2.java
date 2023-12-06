import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] array = new int[(int)(Math.random() * 10) + 1][(int)(Math.random() * 10) + 1];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = (int)(Math.random() * 10);

        for (int[] arr : array)
            System.out.println(Arrays.toString(arr));

        System.out.println();

        for (int[] arr : createArrayWithoutDuplicates(array))
            System.out.println(Arrays.toString(arr));
    }

    private static int[][] createArrayWithoutDuplicates(int[][] array) {
        int[][] arrayWithoutDuplicates = new int[array.length][];

        for (int i = 0; i < array.length; i++)
            arrayWithoutDuplicates[i] = removeDuplicates(array[i]);

        return arrayWithoutDuplicates;
    }

    private static int[] removeDuplicates(int[] array) {
        int[] temp = createTemporaryArray(array);
        int duplicates = 0;

        for (int i = 0; i < array.length; i++) {
            int duplicatesOfElement = 0;
            for (int j = 0; j < temp.length; j++) {
                if (array[i] == temp[j])
                    duplicatesOfElement++;
            }
            if (duplicatesOfElement == 0)
                temp[i] = array[i];
            duplicates += duplicatesOfElement;
        }

        int[] withoutDuplicates = new int[array.length - duplicates];

        int index = 0;
        for (int i = 0; i < temp.length; i++)
            if (temp[i] != 100) {
                withoutDuplicates[index] = temp[i];
                index++;
            }

        return withoutDuplicates;
    }

    private static int[] createTemporaryArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < temp.length; i++)
            temp[i] = 100;
        return temp;
    }
}
