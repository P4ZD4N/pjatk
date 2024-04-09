package task7;

import task7.enums.Group;

public abstract class ACarnivore extends AAnimal {

    public ACarnivore(String name, Group group) {
        super(name, group);
    }

    public abstract void isScavenger();
}
