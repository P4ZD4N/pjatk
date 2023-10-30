public class Task8 {
    public static void main(String[] args) {
        int wrt = -3;

        // A = (-15, -10] U (-5, 0) U (5, 10)
        boolean isElementOfA = (-10 >= wrt && wrt > -15) || (0 > wrt && wrt > -5) || (wrt > 5 && 10 > wrt);
        // B = (-inf, -13 U (-8, -3]
        boolean isElementOfB = (-13 > wrt);
        // C = [-4, inf)
        boolean isElementOfC = (wrt > -4);

        System.out.println(wrt + " is element of A: " + isElementOfA);
        System.out.println(wrt + " is element of B: " +isElementOfB);
        System.out.println(wrt + " is element of C: " +isElementOfC);
    }
}