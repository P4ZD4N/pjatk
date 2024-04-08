package task1;

import java.util.ArrayList;
import java.util.List;

public abstract class Singer implements Comparable<Singer> {

    private static int counter = 1;
    private int id;
    private String name;

    public Singer(String name) {
        this.id = counter++;
        this.name = name;
    }

    public abstract String sing();

    @Override
    public int compareTo(Singer o) {
        int thisDistinctLetters = Singer.getNumberOfDistinctLetters(this.sing());
        int otherDistinctLetters = Singer.getNumberOfDistinctLetters(o.sing());

        if (thisDistinctLetters != otherDistinctLetters)
            return otherDistinctLetters - thisDistinctLetters;

        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0)
            return nameComparison;

        return this.id - o.id;
    }

    private static int getNumberOfDistinctLetters(String text) {
        List<String> distinctLetters = new ArrayList<>();
        String[] letters = text.split("");

        for (String letter : letters)
            if (!distinctLetters.contains(letter))
                distinctLetters.add(letter);

        return distinctLetters.size();
    }

    @Override
    public String toString() {
        return "(" + id + ") " + name + ": " + sing();
    }
}
