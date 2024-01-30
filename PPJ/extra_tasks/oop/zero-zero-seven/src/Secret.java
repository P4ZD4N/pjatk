public class Secret {
    private static int nextId = 1;
    private int id;
    private String name;
    private String contents;
    private double value;

    public Secret(String name, String contents, double value) {
        id = nextId++;
        this.name = name;
        this.contents = contents;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                ", value=" + value +
                '}';
    }
}
