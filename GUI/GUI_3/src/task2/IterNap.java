package task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterNap implements Iterable<Character> {

    private String text;
    private int startIndex = 0;
    private int step = 1;

    public IterNap(String text) {
        this.text = text;
    }

    @Override
    public Iterator<Character> iterator() {

        return new Iterator<Character>() {

            private int currentIndex = startIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < text.length();
            }

            @Override
            public Character next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                char currentChar = text.charAt(currentIndex);

                currentIndex += step;

                return currentChar;
            }
        };
    }

    public void setStartOnIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
