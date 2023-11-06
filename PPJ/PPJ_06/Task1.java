public class Task1 {
    public static void main(String[] args) {
        int number = 1;

        // while won't work even once bcs condition is false
        while (number == 0) {
            System.out.println("while");
        }

        // do while will work once bcs code inside always works at least once, even when condition is false
        do {
            System.out.println("do-while");
        } while (number == 0);
    }
}