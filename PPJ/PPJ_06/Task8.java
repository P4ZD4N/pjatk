import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] points = new int[8];

        for (int i = 0; i < points.length; i++) {
            System.out.print("Enter number: ");
            points[i] = in.nextInt();
        }

        System.out.println("A top-left corner: [" + points[0] + "," + points[1] + "]");
        System.out.println("A bottom-right corner: [" + points[2] + "," + points[3] + "]");
        System.out.println("B top-left corner: [" + points[4] + "," + points[5] + "]");
        System.out.println("B bottom-right corner: [" + points[6] + "," + points[7] + "]");

        int biggestXOfTLCorners = points[0] > points[4] ? points[0] : points[4];
        int smallestXOfBRCorners = points[2] > points[6] ? points[6] : points[2];
        int smallestYOfTLCorners = points[1] > points[5] ? points[5] : points[1];
        int biggestYOfBRCorners = points[3] > points[7] ? points[3] : points[7];

        if (smallestXOfBRCorners > biggestXOfTLCorners && smallestYOfTLCorners > biggestYOfBRCorners) {
            System.out.println("C is rectangle, which is created by common part of recntangles A and B");
            System.out.println("C top-left corner: [" + biggestXOfTLCorners + "," + smallestYOfTLCorners + "]");
            System.out.println("C bottom-right corner: [" + smallestXOfBRCorners + "," + biggestYOfBRCorners + "]");

            int x = 0;
            int y = 0;

            for (int i = smallestYOfTLCorners; i > biggestYOfBRCorners; i--) x += 1;
            for (int i = smallestXOfBRCorners; i > biggestXOfTLCorners; i--) y += 1;


            System.out.println("Area of C rectangle: " + (x * y));
        } else {
            System.err.println("Rectangles A and B doesn't have common part");
        }
    }
}