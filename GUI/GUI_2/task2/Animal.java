package task2;

public class Animal implements IAnimalBehaviors {

    private String name;

    public Animal(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating...");
    }

    @Override
    public void move() {
        System.out.println(name + " is moving...");
    }

    @Override
    public void speak() {
        System.out.println(name + " is speaking...");
    }
}
