public class Exercise1 {
    public static void show(String[] arr, int count) {
        if (count == 0) {
            System.out.println(arr[count]);
            return;
        }
        System.out.println(arr[count]);
        show(arr, count-1);
    }
}
