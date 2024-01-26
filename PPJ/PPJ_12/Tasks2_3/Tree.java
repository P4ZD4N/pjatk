package Tasks2_3;

public class Tree {
    private boolean eternallyGreen;
    private int height;
    private String treeCrossSection;

    public Tree(boolean eternallyGreen, int height, String treeCrossSection) {
        this.eternallyGreen = eternallyGreen;
        this.height = height;
        this.treeCrossSection = treeCrossSection;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "eternallyGreen=" + eternallyGreen +
                ", height=" + height +
                ", treeCrossSection='" + treeCrossSection + '\'' +
                '}';
    }
}
