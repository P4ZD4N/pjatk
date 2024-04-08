package task5;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> monthsDays = new HashMap<>();

        monthsDays.put(1, 31);
        monthsDays.put(2, 29);
        monthsDays.put(3, 31);
        monthsDays.put(4, 30);
        monthsDays.put(5, 31);
        monthsDays.put(6, 30);
        monthsDays.put(7, 31);
        monthsDays.put(8, 31);
        monthsDays.put(9, 30);
        monthsDays.put(10, 31);
        monthsDays.put(11, 30);
        monthsDays.put(12, 31);

        System.out.println("March: " + monthsDays.get(3) + " days");
        System.out.println(monthsDays);
    }
}
