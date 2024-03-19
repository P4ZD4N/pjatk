package task5;

import java.util.Scanner;

public class GamerHuman implements IGamer {

    @Override
    public int play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 -> Rock, 2 -> Paper, 3 -> Scissors");
        System.out.print("Enter choice: ");

        int choice = 0;
        while (isBetween1And3(choice))
            choice = sc.nextInt();

        return choice;
    }

    private boolean isBetween1And3(int choice) {
        return (!(choice >= 1 && 3 >= choice));
    }

    @Override
    public String name() {
        return null;
    }
}
