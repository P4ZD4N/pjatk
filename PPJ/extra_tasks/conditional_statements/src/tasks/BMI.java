package tasks;

public class BMI {
    public static void calculate(double heightInMeters, double weight) {
        if (isEnteredHeightCorrect(heightInMeters)) {
            double bmi = weight / Math.pow(heightInMeters, 2);
            displayResult(bmi);
        } else
            throw new IllegalArgumentException("Entered height is incorrect!");
    }

    private static boolean isEnteredHeightCorrect(double enteredHeight) {
        return enteredHeight > 0.5 && 2.5 > enteredHeight;
    }

    private static void displayResult(double bmi) {
        if (bmi >= 40) {
            System.out.println("Obese (Class III)");
        } else if (bmi >= 35) {
            System.out.println("Obese (Class II)");
        } else if (bmi >= 30) {
            System.out.println("Obese (Class I)");
        } else if (bmi >= 25) {
            System.out.println("Overweight");
        } else if (bmi >= 18.5) {
            System.out.println("Normal range");
        } else if (bmi >= 17) {
            System.out.println("Underweight (Mild thinness)");
        } else if (bmi >= 16) {
            System.out.println("Underweight (Moderate thinness)");
        } else if (16 > bmi) {
            System.out.println("Underweight (Severe thinness)");
        }
    }
}
