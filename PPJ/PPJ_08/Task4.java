import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[][][] operations = {
                {{100,-50,25}, {150,-300}, {300,-90,100}},
                {{90,-60,250}, {300,20,-100}},
                {{20,50},{300},{20,-20,40},{100,-200}}
        };
        int[] sums = new int[operations.length];
        fillSums(sums, operations);
        System.out.println(Arrays.toString(sums));
    }
    private static void fillSums(int[] sums, int[][][] operations) {
        int index = 0;
        int sum = 0;
        for (int[][] client : operations) {
            for (int[] clientsAccount : client) {
                for (int operation : clientsAccount) {
                    sum += operation;
                }
            }
            sums[index] = sum;
            index++;
            sum = 0;
        }
    }
}
