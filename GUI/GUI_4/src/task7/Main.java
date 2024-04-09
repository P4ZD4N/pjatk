package task7;

import task7.enums.Group;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ACarnivore lion = new ACarnivore("Lion", Group.MAMMAL) {

            @Override
            public void isScavenger() {
                System.out.println("Yes");
            }
        };
        ACarnivore tiger = new ACarnivore("Tiger", Group.MAMMAL) {

            @Override
            public void isScavenger() {
                System.out.println("No");
            }
        };

        AHerbivore parrot = new AHerbivore("Parrot", Group.BIRD);
        AHerbivore frog = new AHerbivore("Frog", Group.AMPHIBIAN);

        Worker tobias = new Worker("Tobias");
        Worker john = new Worker("John");
        Worker samuel = new Worker("Samuel");

        Enclosure<ACarnivore> carnivoreEnclosure = new Enclosure<>();
        carnivoreEnclosure.addAnimalToEnclosure(lion);
        carnivoreEnclosure.addAnimalToEnclosure(tiger);

        Enclosure<AHerbivore> herbivoreEnclosure = new Enclosure<>();
        herbivoreEnclosure.addAnimalToEnclosure(parrot);
        herbivoreEnclosure.addAnimalToEnclosure(frog);

        Zoo zoo = new Zoo(List.of(tobias, john, samuel), List.of(carnivoreEnclosure, herbivoreEnclosure));

        zoo.showAllAnimals();
        zoo.showAllWorkers();
    }
}
