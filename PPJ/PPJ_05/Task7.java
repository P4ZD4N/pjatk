public class Task7 {
    public static void main(String[] args) {
        double doubleVar = 1.0;

        // A = [0, inf)
        boolean isElementOfA = doubleVar >= 0;
        // B = (-inf, 1]
        boolean isElementOfB = 1 >= doubleVar;
        // C = [0, 1]
        boolean isElementOfC = isElementOfA && isElementOfB;


        if (isElementOfC) {
            System.out.println("Element of A, B and C");
        } else if (isElementOfA) {
            System.out.println("Element of A");
        } else if (isElementOfB) {
            System.out.println("Element of B");
        }
    }
}