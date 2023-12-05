public class Task7 {
    public static void main(String[] args) {
        int[][] firstArray = {
                {1,2,3,4,5,6,7},
                {2,3,4,5,6,7,8},
                {3,4,5,6,7,8,9},
                {4,5,6,7,8,9,1}
        };
        int[][] secondArray = {
                {1,2,3,4,5,6,7},
                {2,3,4,5,6,7,8},
                {3,4,5,6,7,8,9},
                {4,5,6,7,8,9,9}
        };

        System.out.println(isRectangle(firstArray));
        System.out.println(isSquare(firstArray));
        System.out.println(isSymmetric(firstArray));
        System.out.println(isSameShape(firstArray, secondArray));
        System.out.println(isSame(firstArray, secondArray));
    }

    private static boolean isRectangle(int[][] array) {
        int rows = array.length;
        int[] columnsInParticularRow = calculateHowManyColumnsInParticularRow(array);
        return allColumnsHaveSameSize(columnsInParticularRow) && columnsInParticularRow[0] != rows;
    }

    private static boolean isSquare(int[][] array) {
        int rows = array.length;
        int[] columnsInParticularRow = calculateHowManyColumnsInParticularRow(array);
        return allColumnsHaveSameSize(columnsInParticularRow) && columnsInParticularRow[0] == rows;
    }

    private static boolean isSymmetric(int[][] array) {
        if (isSquare(array)) {
            int rows = array.length;
            int[] columnsInParticularRow = calculateHowManyColumnsInParticularRow(array);
            boolean isSymmetric = true;
            for (int i = 0; i < array.length && isSymmetric; i++) {
                for (int j = 0; j < array[i].length && isSymmetric; j++) {
                    if (array[i][j] != array[j][i]) {
                        isSymmetric = false;
                    }
                }
            }
            return allColumnsHaveSameSize(columnsInParticularRow) && columnsInParticularRow[0] == rows && isSymmetric;
        } else {
            return false;
        }
    }

    private static boolean isSameShape(int[][] firstArray, int[][] secondArray) {
        int firstArrayRows = firstArray.length;
        int secondArrayRows = secondArray.length;
        int[] firstArrayColumnsInParticularRow = calculateHowManyColumnsInParticularRow(firstArray);
        int[] secondArrayColumnsInParticularRow = calculateHowManyColumnsInParticularRow(secondArray);

        boolean haveSameColumns = true;
        for (int i = 0; i < firstArrayColumnsInParticularRow.length && haveSameColumns; i++) {
            if (firstArrayColumnsInParticularRow[i] != secondArrayColumnsInParticularRow[i]) {
                haveSameColumns = false;
            }
        }
        return firstArrayRows == secondArrayRows && haveSameColumns;
    }

    private static boolean isSame(int[][] firstArray, int[][] secondArray) {
        if (isSameShape(firstArray, secondArray)) {
            boolean isSame = true;
            for (int i = 0; i < firstArray.length && isSame; i++) {
                for (int j = 0; j < firstArray[i].length && isSame; j++) {
                    if (firstArray[i][j] != secondArray[i][j]) {
                        isSame = false;
                    }
                }
            }
            return isSame;
        } else {
            return false;
        }
    }

    private static int[] calculateHowManyColumnsInParticularRow(int[][] array) {
        int[] columnsInParticularRow = new int[array.length];
        int columns = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                columns++;
            }
            columnsInParticularRow[i] = columns;
            columns = 0;
        }
        return columnsInParticularRow;
    }

    private static boolean allColumnsHaveSameSize(int[] columnsInParticularRow) {
        boolean allColumnsHaveSameSize = true;
        for (int i = 1; i < columnsInParticularRow.length && allColumnsHaveSameSize; i++) {
            if (columnsInParticularRow[i] != columnsInParticularRow[i - 1]) {
                allColumnsHaveSameSize = false;
            }
        }
        return allColumnsHaveSameSize;
    }
}
