package task7;

public abstract class AAnimal {

    private String name;
    private String group;

    public AAnimal(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "AAnimal{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
