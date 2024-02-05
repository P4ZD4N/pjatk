package tasks;

public class PolishGrades {
    public static void printDescription(int grade) {
        if (grade >= 1 && 6 >= grade) {
            switch (grade) {
                case 1:
                    System.out.println("Unsatisfactory");
                    break;
                case 2:
                    System.out.println("Passing");
                    break;
                case 3:
                    System.out.println("Satisfactory");
                    break;
                case 4:
                    System.out.println("Good");
                    break;
                case 5:
                    System.out.println("Very good");
                    break;
                case 6:
                    System.out.println("Excellent");
                    break;
            }
        } else
            throw new IllegalArgumentException(grade + " - this grade does not occurs in polish grading system!");
    }
}
