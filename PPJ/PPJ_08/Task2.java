public class Task2 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5},{1,9},{3,1,8}};
        int[] evenAndOdd = calculateEvenAndOdd(arr);

        System.out.println("Even: " + evenAndOdd[0]);
        System.out.println("Odd: " + evenAndOdd[1]);
    }
    private static int[] calculateEvenAndOdd(int[][] arr) {
        int even = 0;
        int odd = 0;

        for (int[] ints : arr) {
            for (int elementOfInts : ints) {
                if (elementOfInts % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        return new int[] {even, odd};
    }
}
