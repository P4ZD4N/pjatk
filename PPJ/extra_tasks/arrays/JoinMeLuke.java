public class JoinMeLuke {
    private String[] mergedArray;

    public static String[] mergeArrays(String[] firstArray, String[] secondArray) {
        this.mergedArray = new String[firstArray.length + secondArray.length];

        for (int i = 0; i < firstArray.length; i++)
            mergedArray[i] = firstArray[i];

        int index = 0;
        for (int i = firstArray.length; i < mergedArray.length; i++)
            mergedArray[i] = secondArray[index++];

        return mergedArray;
    }
}
