package App;

public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private double lifePoints;

    public Person(String name, String surname, int age, double lifePoints) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    protected boolean hasEnoughLifePoints() {
        return getLifePoints() > 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", lifePoints=" + lifePoints +
                '}';
    }
}
