package task7;

import task7.enums.Group;

public abstract class AAnimal {

    private String name;
    private Group group;

    public AAnimal(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
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
