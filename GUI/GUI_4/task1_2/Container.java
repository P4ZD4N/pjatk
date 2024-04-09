package task1_2;

public class Container<T, S> {

    private T item1;
    private S item2;

    public Container(T item1, S item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public void print() {
        System.out.println("Item 1: " + item1);
        System.out.println("Item 2: " + item2);
    }

}
