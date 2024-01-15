public class ReIterator {
    private static int index = 0;

    public static void iterate(String[] arr) {
        if (index == arr.length - 1) {
            System.out.println(arr[index]);
            index = 0;
            return;
        }

        System.out.println(arr[index++]);
        iterate(arr);
    }
}
