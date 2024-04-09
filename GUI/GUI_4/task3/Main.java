package task3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> listOfStrings = new ArrayList<>();

        listOfStrings.add("Ala");
        listOfStrings.add("ma");
        listOfStrings.add("Kota");

        System.out.println(listOfStrings.size());
        System.out.println(String.join(" ", listOfStrings));
    }
}
