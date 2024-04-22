package task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        Animal lion = new Animal("Lion", 34.6, 1.80, 90);
        Animal dog = new Animal("Dog", 15.2, 0.87, 25);
        Animal crocodile = new Animal("Crocodile", 10, 0.45, 213);
        Animal jaguar = new Animal("Jaguar", 67.9, 0.71, 89);

        animals.add(lion);
        animals.add(dog);
        animals.add(crocodile);
        animals.add(jaguar);

        System.out.println("Before: " + animals);
//        Animal.sortAnimalsDescendingBy(animals, Criterion.TOP_SPEED);
//        System.out.println("After sorting by Top Speed: " + animals);
//        Animal.sortAnimalsDescendingBy(animals, Criterion.WEIGHT);
//        System.out.println("After sorting by Weight: " + animals);
        Animal.sortAnimalsDescendingBy(animals, Criterion.HEIGHT);
        System.out.println("After sorting by Height: " + animals);

        Animal.findAndPrintDesiredAnimalsFromList(animals);
    }
}
