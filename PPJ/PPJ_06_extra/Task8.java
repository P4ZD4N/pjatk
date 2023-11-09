import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;

        System.out.println("Both players should enter one of three options: ");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
        System.out.println("");

        int firstPlayerChoice = 0;
        int secondPlayerChoice = 0;

        while (firstPlayerScore != secondPlayerScore + 3  && secondPlayerScore != firstPlayerScore + 3) {
            for (int i = 1; firstPlayerScore != secondPlayerScore + 3  && secondPlayerScore != firstPlayerScore + 3; i++) {
                System.out.println("Round " + i + "!");

                System.out.print("1st player: ");
                while (!(3 >= firstPlayerChoice && firstPlayerChoice >= 1))
                    firstPlayerChoice = in.nextInt();

                System.out.print("2nd player: ");
                while (!(3 >= secondPlayerChoice && secondPlayerChoice >= 1))
                    secondPlayerChoice = in.nextInt();

                if (
                        ((firstPlayerChoice == 1) && (secondPlayerChoice == 1)) ||
                        ((firstPlayerChoice == 2) && (secondPlayerChoice == 2)) ||
                        ((firstPlayerChoice == 3) && (secondPlayerChoice == 3))
                ) {
                    System.out.println("Round " + i + " ended in a draw!");
                    firstPlayerScore++;
                    secondPlayerScore++;
                    firstPlayerChoice = 0;
                    secondPlayerChoice = 0;
                } else if (
                        ((firstPlayerChoice == 2) && (secondPlayerChoice == 1)) ||
                        ((firstPlayerChoice == 3) && (secondPlayerChoice == 2)) ||
                        ((firstPlayerChoice == 1) && (secondPlayerChoice == 3))
                ) {
                    System.out.println("First player won round " + i + "!");
                    firstPlayerScore++;
                    firstPlayerChoice = 0;
                    secondPlayerChoice = 0;
                } else {
                    System.out.println("Second player won round " + i + "!");
                    secondPlayerScore++;
                    firstPlayerChoice = 0;
                    secondPlayerChoice = 0;
                }

            }

            System.out.println(
                    firstPlayerScore > secondPlayerScore ? "First player won the game!" : "Second player won the game!"
            );
            System.out.println("First player score: " + firstPlayerScore);
            System.out.println("Second player score: " + secondPlayerScore);
        }
    }
}