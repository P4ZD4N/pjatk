import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter x (x of top-left corner of rectangle): ");
        int xTopLeftCornerOfRectangle = in.nextInt();
        System.out.print("Enter y (y of top-left corner of rectangle): ");
        int yTopLeftCornerOfRectangle = in.nextInt();
        System.out.print("Enter height of rectangle: ");
        int rectangleHeight = in.nextInt();
        System.out.print("Enter width of rectangle: ");
        int rectangleWidth = in.nextInt();
        System.out.print("Enter x (x of point): ");
        int xPoint = in.nextInt();
        System.out.print("Enter y (y of point): ");
        int yPoint = in.nextInt();

        System.out.println(
                "Coordinates of rectangle's top-left corner: [" + xTopLeftCornerOfRectangle + "," + yTopLeftCornerOfRectangle + "]"
        );
        System.out.println(
                "Coordinates of rectangle's bottom-rigth corner: ["
                + (xTopLeftCornerOfRectangle + rectangleWidth)
                + ","
                + (yTopLeftCornerOfRectangle - rectangleHeight)
                + "]"
        );
        System.out.println("Coordinates of point: [" + xPoint + "," + yPoint + "]");

        if (
                (xPoint >= xTopLeftCornerOfRectangle && (xTopLeftCornerOfRectangle + rectangleWidth) >= xPoint) &&
                (yPoint >= (yTopLeftCornerOfRectangle - rectangleHeight) && yTopLeftCornerOfRectangle >= yPoint)
        )
            System.out.println("Point [" + xPoint + "," + yPoint + "] belongs to this rectangle");
        else
            System.out.println("Point [" + xPoint + "," + yPoint + "] does not belong to this rectangle");
    }
}