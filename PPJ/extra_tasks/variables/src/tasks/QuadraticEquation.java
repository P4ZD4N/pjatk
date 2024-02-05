package tasks;

public class QuadraticEquation {
    public static void calculate(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);

            System.out.println("Two solutions!");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x1 = -b / (2 * a);

            System.out.println("One solution! x1 = " + x1);
        } else
            System.out.println("No solutions! Delta: " + delta);
    }
}
