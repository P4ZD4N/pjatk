import java.util.Scanner;

public class Sniper {
    public static void play(String[] cans) {
        if (allElementsInArrayEqualsCan(cans)) {
            Scanner sc = new Scanner(System.in);
            int shotCounter = 0;

            while (!allCansShotDown(cans)) {
                int chosenCan = -1;

                while (!(chosenCan >= 0 && 9 >= chosenCan)) {
                    System.out.print("Choose can (0-9): ");
                    chosenCan = sc.nextInt();
                }

                if (cans[chosenCan] == null)
                    System.out.println("Can on this index was shot down earlier!");
                else if (cans[chosenCan].equals("Can")) {
                    System.out.println("You shot down a can!");
                    cans[chosenCan] = null;
                }

                shotCounter++;
            }

            System.out.println("Shot counter: " + shotCounter);
        } else throw new IllegalArgumentException("Some elements in array are incorrect!");
    }

    private static boolean allCansShotDown(String[] cans) {
        for (String probablyCan : cans)
            if (probablyCan != null)
                return false;
        return true;
    }

    private static boolean allElementsInArrayEqualsCan(String[] cans) {
        for (String probablyCan : cans)
            if (!probablyCan.equals("Can"))
                return false;
        return true;
    }
}
