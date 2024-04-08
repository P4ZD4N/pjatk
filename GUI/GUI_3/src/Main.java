import task1.Singer;
import task2.IterNap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Task 1

        Singer s1 = new Singer("Darrey") {
            @Override
            public String sing() {
                return "eeae";

            }
        };

        Singer s2 = new Singer("Darrey") {
            @Override
            public String sing() {
                return "bebe";
            }
        };

        Singer s3 = new Singer("Houston") {
            @Override
            public String sing() {
                return "a4iBBiii";
            }
        };

        Singer s4 = new Singer("Carrey") {
            @Override
            public String sing() {
                return "oaooooooooooo";
            }
        };

        Singer s5 = new Singer("Madonna") {
            @Override
            public String sing() {
                return "aAa";
            }
        };

        List<Singer> singersList = new ArrayList<>();

        singersList.add(s1);
        singersList.add(s2);
        singersList.add(s3);
        singersList.add(s4);
        singersList.add(s5);

        for (Singer singer : singersList)
            System.out.println(singer);

        Collections.sort(singersList);
        System.out.println();

        for (Singer singer : singersList)
            System.out.println(singer);

        // Task 2

        IterNap text = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        for (char ch: text)
            System.out.print(ch + " ");System.out.println();
        text.setStartOnIndex(2);
        text.setStep(3);

        for (char ch: text)
            System.out.print(ch + " ");
    }
}