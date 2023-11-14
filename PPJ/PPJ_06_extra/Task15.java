public class Task15 {
    public static void main(String[] args) {
        int lineNumber = 1;
        for (int i = 75; i <= 150; i++) {
            System.out.println(lineNumber + ". " + (char) i + " - " + i);
            lineNumber++;
        }
    }
}