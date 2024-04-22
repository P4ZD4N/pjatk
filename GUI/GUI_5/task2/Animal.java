package task2;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Animal {

    private String name;
    private double topSpeed;
    private double weight;
    private double height;


    public Animal(String name, double topSpeed, double height, double weight) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void findAndPrintDesiredAnimalsFromList(List<Animal> animals) {

        Scanner sc = new Scanner(System.in);

        System.out.println("- TOP_SPEED");
        System.out.println("- WEIGHT");
        System.out.println("- HEIGHT");
        System.out.print("Choose criterion: ");
        String choice = sc.next();

        Criterion criterion = Criterion.valueOf(choice.toUpperCase());

        switch (criterion) {

            case TOP_SPEED -> {

                System.out.print("Enter min. top speed: ");
                double minTopSpeed = sc.nextDouble();

                Predicate<Animal> predicateByMinTopSpeed = (animal) -> animal.getTopSpeed() >= minTopSpeed;
                animals.stream().filter(predicateByMinTopSpeed).forEach(animal -> System.out.println(animal));
            }

            case WEIGHT -> {

                System.out.print("Enter min. weight: ");
                double minWeight = sc.nextDouble();

                Predicate<Animal> predicateByMinWeight = (animal) -> animal.getWeight() >= minWeight;
                animals.stream().filter(predicateByMinWeight).forEach(animal -> System.out.println(animal));
            }

            case HEIGHT -> {

                System.out.print("Enter min. height: ");
                double minHeight = sc.nextDouble();

                Predicate<Animal> predicateByMinHeight = (animal) -> animal.getHeight() >= minHeight;
                animals.stream().filter(predicateByMinHeight).forEach(animal -> System.out.println(animal));
            }

            default -> throw new IllegalArgumentException("Incorrect choice!");
        }
    }

    public static void sortAnimalsDescendingBy(List<Animal> animals, Criterion criterion) {

        switch (criterion) {

            case TOP_SPEED -> {

                Comparator<Animal> topSpeedComparator = (animal1, animal2) -> (int) (animal2.getTopSpeed() - animal1.getTopSpeed());
                animals.sort(topSpeedComparator);
            }

            case WEIGHT -> {

                Comparator<Animal> weightComparator = (animal1, animal2) -> (int) (animal2.getWeight() - animal1.getWeight());
                animals.sort(weightComparator);
            }

            case HEIGHT -> {

                Comparator<Animal> heightComparator = (animal1, animal2) -> (int) (animal2.getHeight() - animal1.getHeight());
                animals.sort(heightComparator);
            }
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
