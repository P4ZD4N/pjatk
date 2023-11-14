import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter x (x of center of circle): ");
        int xCircleCenter = in.nextInt();
        System.out.print("Enter y (y of center of circle): ");
        int yCircleCenter = in.nextInt();
        System.out.print("Enter circle radius: ");
        int circleRadius = in.nextInt();
        System.out.print("Enter x (x of point): ");
        int xPoint = in.nextInt();
        System.out.print("Enter y (y of point): ");
        int yPoint = in.nextInt();

        double distanceBetweenCircleCenterAndPoint = Math.sqrt(Math.pow(xPoint - xCircleCenter, 2) + Math.pow(yPoint - yCircleCenter, 2));

        if (circleRadius - distanceBetweenCircleCenterAndPoint > 0)
            System.out.println("Point lies inside the circle");
        else if (circleRadius - distanceBetweenCircleCenterAndPoint == 0)
            System.out.println("Point lies on the circle");
        else
            System.out.println("Point lies outside the circle");
    }
}