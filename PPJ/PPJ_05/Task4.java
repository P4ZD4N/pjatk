public class Task4 {
    public static void main(String[] args) {
        boolean doesSignificantWork = true;
        boolean nobelPrizeCandidate = true;
        boolean makesBreakthrough = false;

        /* Code:

        if (doesSignificantWork) {
            if (makesBreakthrough) {
                nobelPrizeCandidate = true;
            } else {
                nobelPrizeCandidate = false;
            }
        } else if (!doesSignificantWork)
            nobelPrizeCandidate = false;

        */

        /* Simpler code:

        if (doesSignificantWork && makesBreakthrough) {
            nobelPrizeCandidate = true;
        } else {
            nobelPrizeCandidate = false;
        }

        */

        // The same code with ternary operator:

        nobelPrizeCandidate = (doesSignificantWork && makesBreakthrough) ? true : false;
    }
}