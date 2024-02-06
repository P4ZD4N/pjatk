import tasks.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Array.getBiggestElement(new int[] {1,3,2,5,4,7,6,5,5}));
        System.out.println(Array.getSmallestElement(new int[] {1,3,2,5,4,7,6,5,5}));
        System.out.println(Array.getSumOfAllElements(new int[] {2,3,1}));
        System.out.println(Arrays.toString(Array.getReversed(new int[] {1,2,3,4,5})));
        System.out.println(Array.getAverageOfAllElements(new int[] {1,3,5,7}));
        System.out.println(Array.isNumberInArray(5, new int[] {1,2,4,3,5,7,6}));
        System.out.println(Arrays.toString(Array.getSorted(new int[] {1,3,2,5,4,7,6,5,5})));
    }
}