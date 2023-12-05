import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5,6},
                {2,3,4,5,6,7},
                {3,4,5,6,7,8},
                {4,5,6,7,8,9}
        };

        for (int[] subArray : array)
            System.out.println(Arrays.toString(subArray));

        System.out.println();

        for (int[] subArray : trans(array))
            System.out.println(Arrays.toString(subArray));

    }
    public static int[][] trans(int[][] array) {
        if (isRectangular(array)) {
            int rows = array.length;
            int columns = 0;

            for (int element : array[0])
                columns++;

            int[][] transformed = new int[columns][rows];

            int firstElement = array[0][0];
            for (int i = 0; i < transformed.length; i++) {
                for (int j = 0; j < transformed[i].length; j++)
                    transformed[i][j] = firstElement++;
                firstElement = array[0][0] + i + 1;
            }

            return transformed;
        } else throw new IllegalArgumentException("Array isn't rectangular");
    }
    private static boolean isRectangular(int[][] array) {
        int rows = array.length;
        int[] columnsAtParticularRow = new int[rows];
        int columns = 0;
        for (int i = 0; i < array.length; i++) {
            for (int element : array[i])
                columns++;
            columnsAtParticularRow[i] = columns;
            columns = 0;
        }

        boolean allRowsHaveSameNumberOfColumns = true;
        for (int i = 1; i < columnsAtParticularRow.length && allRowsHaveSameNumberOfColumns; i++)
            if (columnsAtParticularRow[i] != columnsAtParticularRow[i - 1])
                allRowsHaveSameNumberOfColumns = false;
        return allRowsHaveSameNumberOfColumns && rows != columnsAtParticularRow[0];
    }
}
