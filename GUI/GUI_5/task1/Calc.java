package task1;

public class Calc {

    public static int add(int a, int b) {

        ICalc myAdd = (x, y) -> x + y;

        return myAdd.calc(a, b);
    }

    public static int subtract(int a, int b) {

        ICalc mySubtract = (x, y) -> x - y;

        return mySubtract.calc(a, b);
    }

    public static int multiply(int a, int b) {

        ICalc myMultiply = (x, y) -> x * y;

        return myMultiply.calc(a, b);
    }

    public static int divide(int a, int b) {

        ICalc myDivide = (x, y) -> (int) x / y;

        return myDivide.calc(a, b);
    }
}
