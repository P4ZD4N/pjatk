package task5;

public class Arena {

    private IGamer firstGamer;
    private IGamer secondGamer;
    private int firstGamerPoints;
    private int secondGamerPoints;

    public Arena(IGamer firstGamer, IGamer secondGamer) {
        this.firstGamer = firstGamer;
        this.secondGamer = secondGamer;
    }

    public void fight(int numberOfRounds) {
        int roundCounter = 1;

        int firstGamerChoice = firstGamer.play();
        int secondGamerChoice = secondGamer.play();

        while (roundCounter <= numberOfRounds) {
            switch (firstGamerChoice) {
                case 1 -> {
                    switch (secondGamerChoice) {
                        case 1 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Rock vs. Rock");
                            System.out.println("Draw!");
                            firstGamerPoints++;
                            secondGamerPoints++;
                        }
                        case 2 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Rock vs. Paper");
                            System.out.println("Second player won!");
                            secondGamerPoints++;
                        }
                        case 3 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Rock vs. Scissors");
                            System.out.println("First player won!");
                            firstGamerPoints++;
                        }
                    }
                }
                case 2 -> {
                    switch (secondGamerChoice) {
                        case 1 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Paper vs. Rock");
                            System.out.println("First player won!");
                            firstGamerPoints++;
                        }
                        case 2 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Paper vs. Paper");
                            System.out.println("Draw!");
                            firstGamerPoints++;
                            secondGamerPoints++;
                        }
                        case 3 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Paper vs. Scissors");
                            System.out.println("Second player won!");
                            secondGamerPoints++;
                        }
                    }
                }
                case 3 -> {
                    switch (secondGamerChoice) {
                        case 1 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Scissors vs. Rock");
                            System.out.println("Second player won!");
                            secondGamerPoints++;
                        }
                        case 2 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Scissors vs. Paper");
                            System.out.println("First player won!");
                            firstGamerPoints++;
                        }
                        case 3 -> {
                            System.out.println("Round " + roundCounter);
                            System.out.println("Scissors vs. Scissors");
                            System.out.println("Draw!");
                            firstGamerPoints++;
                            secondGamerPoints++;
                        }
                    }
                }
            }
            roundCounter++;
        }

        printResultAfterRounds(numberOfRounds);
    }

    public void printResultAfterRounds(int numberOfRounds) {
        System.out.println("Result after " + numberOfRounds + " rounds: ");
        System.out.println("First player score: " + firstGamerPoints);
        System.out.println("Second player score: " + secondGamerPoints);
        printWinner();
    }

    private void printWinner() {
        if (firstGamerPoints > secondGamerPoints)
            System.out.println("First player is winner!");
        else if (firstGamerPoints == secondGamerPoints)
            System.out.println("Game ends with draw!");
        else
            System.out.println("Second player is winner!");
    }
}
