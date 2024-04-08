package task7;

public abstract class ACarnivore extends AAnimal {

    public ACarnivore(String name, String group) {
        super(name, group);
    }

    public abstract void isScavenger();
}
