package task7;

public class Worker {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cleanAnimal(AAnimal animal) {
        System.out.println(animal.getName() + " cleaned!");
    }

    public void feedAnimal(AAnimal animal) {
        System.out.println(animal.getName() + " fed!");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
