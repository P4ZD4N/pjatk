import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5,6,7},
                {2,3,4,5,6,7,8},
                {3,4,5,6,7,8,9},
                {4,5,6,7,8,9,1}
        };
        System.out.println(Arrays.deepToString(inner(array)));
    }
    private static int[][] inner(int[][] array) {
        if (arrayHasAtLeast3RowsAnd3Columns(array) && arrayIsRectangular(array)) {
            int[][] inner = new int[array.length - 2][array[0].length - 2];

            for (int i = 1; i < array.length - 1; i++) {
                for (int j = 1; j < array[i].length - 1; j++) {
                    inner[i - 1][j - 1] = array[i][j];
                }
            }
            return inner;
        } else {
            throw new IllegalArgumentException("Incorrect array");
        }
    }
    private static boolean arrayHasAtLeast3RowsAnd3Columns(int[][] array) {
        int rows = array.length;
        int columns = 0;
        boolean arrayHasAtLeast3Columns = true;
        for (int[] row : array) {
            for (int number : row) {
                columns++;
            }
            if (3 > columns) {
                arrayHasAtLeast3Columns = false;
                break;
            }
            columns = 0;
        }
        return arrayHasAtLeast3Columns && rows >= 3;
    }
    private static boolean arrayIsRectangular(int[][] array) {
        int[] columnsAtParticularRow = new int[array.length];
        int columns = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                columns++;
            }
            columnsAtParticularRow[i] = columns;
            columns = 0;
        }
        boolean isRectangular = true;
        for (int i = 1; i < columnsAtParticularRow.length && isRectangular; i++) {
            if (columnsAtParticularRow[i] != columnsAtParticularRow[i - 1]) {
                isRectangular = false;
            }
        }
        return isRectangular;
    }
}
