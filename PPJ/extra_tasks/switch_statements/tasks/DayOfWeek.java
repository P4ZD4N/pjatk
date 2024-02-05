package tasks;

public class DayOfWeek {
    public static void printName(int numberOfDay) {
        if (numberOfDay >= 1 && 7 >= numberOfDay) {
            switch (numberOfDay) {
                case 1 -> System.out.println("Monday");
                case 2 -> System.out.println("Tuesday");
                case 3 -> System.out.println("Wednesday");
                case 4 -> System.out.println("Thursday");
                case 5 -> System.out.println("Friday");
                case 6 -> System.out.println("Saturday");
                case 7 -> System.out.println("Sunday");
            }
        } else
            throw new IllegalArgumentException(numberOfDay + " - there is no such day of the week!");
    }
}
