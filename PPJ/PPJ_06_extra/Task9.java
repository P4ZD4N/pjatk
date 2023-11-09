public class Task9 {
    public static void main(String[] args) {
        int iterations = 1;
        int same = 0;

        int firstDice;
        int secondDice;

        while (same != 1) {
            firstDice = (int) (Math.random() * 10);
            secondDice = (int) (Math.random() * 10);

            System.out.println(iterations + ". " + firstDice + " / " + secondDice);

            if (firstDice == 6 && firstDice == secondDice) {
                iterations++;
                same++;
            } else
                iterations++;
        }

        System.out.println("Dice rolls: " + (iterations - 1));
    }
}