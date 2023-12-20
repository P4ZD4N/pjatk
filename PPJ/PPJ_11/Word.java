public class Word {
    private char[] array;
    private int number;

    public Word() {
        this.array = new char[100];
        this.number = 0;
    }

    public void addChar(char character) {
        int index = 0;
        for (; array[index] != '\u0000'; index++);
        array[index] = character;
    }

    public void show() {
        for (int i = 0; i < array.length && array[i] != '\u0000'; i++)
            System.out.print(array[i]);
    }

    public int length() {
        int letters = 0;
        for (int i = 0; i < array.length && array[i] != '\u0000'; i++)
            letters++;
        return letters;
    }
}
