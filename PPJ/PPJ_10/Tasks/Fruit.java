public class Fruit {
    String name;
    double weight;

    Fruit(String name) {
        this.name = name;
        this.weight = 0.5 + ((0.8 - 0.5) * Math.random());
    }

    public void show() {
        System.out.println("Fruit name: " + name);
        System.out.println("Fruit weight: " + weight);
    }
}
