public class TwistAndShout {
    private String[] array;

    public TwistAndShout(String[] array) {
        this.array = array;
    }

    public void reverseArray() {
        String[] reversedArray = new String[array.length];

        for (int i = 0; i < array.length; i++)
            reversedArray[i] = array[array.length - 1 - i];

        array = reversedArray;
    }

    public void displayArray() {
        for (String element : array)
            System.out.println(element);
    }
}
