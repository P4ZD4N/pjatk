import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        int[] firstArray = {1,5,3};
        int[] secondArray = {5,4,3,6,6,4,3};

        System.out.println(Arrays.toString(createNewArray(firstArray, secondArray, 1)));
        System.out.println(Arrays.toString(createNewArray(firstArray, secondArray, -1)));
    }
    private static int[] createNewArray(int[] firstArray, int[] secondArray, int number) {
        if (firstArray.length == secondArray.length) {
            return null;
        } else if (number > 0) {
            int biggerArrayLength = firstArray.length > secondArray.length ? firstArray.length : secondArray.length;
            int smallerArrayLength = firstArray.length > secondArray.length ? secondArray.length : firstArray.length;
            int[] elementsWhichDoesNotHavePairs = new int[biggerArrayLength - smallerArrayLength];
            int index = 0;

            if (firstArray.length == smallerArrayLength)
                for (int i = smallerArrayLength; i < biggerArrayLength; i++)
                    elementsWhichDoesNotHavePairs[index++] = secondArray[i];
            else
                for (int i = smallerArrayLength; i < biggerArrayLength; i++)
                    elementsWhichDoesNotHavePairs[index++] = firstArray[i];

            return elementsWhichDoesNotHavePairs;
        } else if (0 > number) {
            int smallerArrayLength = firstArray.length > secondArray.length ? secondArray.length : firstArray.length;
            int[] sumsOfTwoArraysElements = new int[smallerArrayLength];

            for (int i = 0; i < smallerArrayLength; i++)
                sumsOfTwoArraysElements[i] = firstArray[i] + secondArray[i];

            return sumsOfTwoArraysElements;
        } else throw new IllegalArgumentException("Something gone wrong");
    }
}
