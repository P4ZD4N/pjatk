import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = in.nextDouble();
        System.out.print("Enter b: ");
        double b = in.nextDouble();
        System.out.print("Enter c: ");
        double c = in.nextDouble();
        System.out.print("Enter d: ");
        double d = in.nextDouble();
        System.out.print("Enter e: ");
        double e = in.nextDouble();
        System.out.print("Enter f: ");
        double f = in.nextDouble();

        System.out.println("");

        System.out.println(a + "x + " + b + "y = " + c);
        System.out.println(d + "x + " + e + "y = " + f);

        System.out.println("");

        System.out.println(a * (d) + "x + " + b * (d) + "y = " + c * (d));
        System.out.println(d * (-a) + "x + " + e * (-a) + "y = " + f * (-a));

        System.out.println("");

        System.out.println((b * (d) - e * (a)) + "y = " + (c * (d) - f * (a)));
        System.out.println("y = " + ((c * (d) - f * (a)) / (b * (d) - e * (a))));

        System.out.println(a + "x + " + (b * ((c * (d) - f * (a)) / (b * (d) - e * (a)))) + " = " + c);
        System.out.println(a + "x = " + c + " - " + (b * ((c * (d) - f * (a)) / (b * (d) - e * (a)))));

        System.out.println("");

        System.out.println("x = " + (c - (b * ((c * (d) - f * (a)) / (b * (d) - e * (a))))) / a);
        System.out.println("y = " + ((c * (d) - f * (a)) / (b * (d) - e * (a))));
    }
}