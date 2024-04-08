package task7;

import java.util.ArrayList;

public class Enclosure<T extends AAnimal> {

    private ArrayList<T> animalList;

    public Enclosure() {
        animalList = new ArrayList<>();
    }

    public void addAnimalToEnclosure(T animal) {
        animalList.add(animal);
    }

    public ArrayList<T> getEnclosure() {
        return animalList;
    }
}
