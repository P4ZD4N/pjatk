package tasks;

import java.util.Scanner;

public class RockPaperScissors {
    private static final Scanner scanner = new Scanner(System.in);

    public static void play() {
        String computerChoice = drawChoice();
        String userChoice = choose();

        if (userChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("Draw!");
        } else if (
                userChoice.equalsIgnoreCase("R") && computerChoice.equalsIgnoreCase("S") ||
                userChoice.equalsIgnoreCase("P") && computerChoice.equalsIgnoreCase("R") ||
                userChoice.equalsIgnoreCase("S") && computerChoice.equalsIgnoreCase("P")
        ) {
            System.out.println("User win!");
        } else {
            System.out.println("Computer win!");
        }
    }

    private static String drawChoice() {
        int randomNumber = (int) (Math.random() * 3);
        return switch (randomNumber) {
            case 0:
                yield "R";
            case 1:
                yield "P";
            case 2:
                yield "S";
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    private static String choose() {
        String userChoice = "";

        while (
                !userChoice.equalsIgnoreCase("R") &&
                        !userChoice.equalsIgnoreCase("P") &&
                        !userChoice.equalsIgnoreCase("S")
        ) {
            System.out.print("Enter your choice (R/P/S): ");
            userChoice = scanner.next().toLowerCase();
        }

        return userChoice;
    }
}
