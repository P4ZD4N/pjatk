package App;

public class Gift {
    private static int nextId = 1;
    private final int id;
    private String content;
    private int weight;

    public Gift(String content, int weight) {
        id = nextId++;
        this.content = content;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getWeight() {
        return weight;
    }
}
