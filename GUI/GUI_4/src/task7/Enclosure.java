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

    @Override
    public String toString() {
        StringBuilder animalsStingBuilder = new StringBuilder();

        for (AAnimal animal : animalList)
            animalsStingBuilder.append(animal.getName());

        return "Enclosure{" + "animalList=" + animalsStingBuilder + '}';
    }
}
