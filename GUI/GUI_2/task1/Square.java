package task1;

public class Square implements Comparable<Square> {

    private int length;
    private int number;
    private static int counter;

    public Square(int length) {
        counter++;
        this.length = length;
        number = counter;
    }

    public int getArea() {
        return length * length;
    }

    @Override
    public int compareTo(Square square) {
        if (isAreaBiggerThanAreaOf(square))
            return 1;
        else if (isAreaEqualToAreaOf(square))
            return 0;
        else if (isAreaSmallerThanAreaOf(square))
            return -1;
        else throw new IllegalArgumentException();
    }

    private boolean isAreaBiggerThanAreaOf(Square square) {
        return this.getArea() > square.getArea();
    }

    private boolean isAreaEqualToAreaOf(Square square) {
        return this.getArea() == square.getArea();
    }

    private boolean isAreaSmallerThanAreaOf(Square square) {
        return this.getArea() < square.getArea();
    }

    @Override
    public String toString() {
        return "Square number:" + number + ", area: " + getArea();
    }
}
