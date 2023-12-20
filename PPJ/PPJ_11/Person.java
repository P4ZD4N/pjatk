import java.time.Year;

public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(String name) {
        this.name = name;
        this.birthYear = 1990;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    public static Person getOlder(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge() > secondPerson.getAge() ? firstPerson : secondPerson;
    }

    public static Person getOldest(Person[] persons) {
        Person oldestPerson = persons[0];
        for (Person person : persons)
            if (person.getAge() > oldestPerson.getAge())
                oldestPerson = person;
        return oldestPerson;
    }

    public static void sortByAgeAscending(Person[] persons) {
        int operations;
        Person temp;

        do {
            operations = 0;
            for (int i = 1; i < persons.length; i++) {
                if (persons[i - 1].getAge() > persons[i].getAge()) {
                    operations++;
                    temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;
                }
            }
        } while (operations != 0);
    }

    public static void sortByAgeDescending(Person[] persons) {
        int operations;
        Person temp;

        do {
            operations = 0;
            for (int i = 1; i < persons.length; i++) {
                if (persons[i].getAge() > persons[i - 1].getAge()) {
                    operations++;
                    temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;
                }
            }
        } while (operations != 0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
