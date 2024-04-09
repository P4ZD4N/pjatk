package task1_2;

public class Main {

    public static void main(String[] args) {

        Container<Integer, String> containerInteger = new Container<>(20, "Wiktor");
        Container<Double, Long> containerString = new Container<>(3.214325243, 999999999999999999L);

        containerInteger.print();
        containerString.print();
    }
}