package Tasks2_3;

public class DeciduousTree extends Tree {
    public String leafShape;

    public DeciduousTree(boolean eternallyGreen, int height, String treeCrossSection, String leafShape) {
        super(eternallyGreen, height, treeCrossSection);
        this.leafShape = leafShape;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + "leafShape=" + leafShape + "}";
    }
}
