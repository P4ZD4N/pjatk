package tasks;

public class RandomNumbers {
    public static void generateTenFromOneTo(int end) {
        int index = 1;
        while (index <= 10) {
            int randomNumber = (int) (Math.random() * end) + 1;
            System.out.println(index + ". " + randomNumber);
            index++;
        }
    }

    public static void generateTwentyFromOneTo(int end) {
        int index = 1;
        while (index <= 20) {
            int randomNumber = (int) (Math.random() * end) + 1;
            System.out.println(index + ". " + randomNumber);
            index++;
        }
    }
}
