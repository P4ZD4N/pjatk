package Tasks2_3;

public class FruitTree extends DeciduousTree {
    private String fruitName;

    public FruitTree(boolean eternallyGreen, int height, String treeCrossSection, String leafShape, String fruitName) {
        super(eternallyGreen, height, treeCrossSection, leafShape);
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + "fruitName=" + fruitName + "}";
    }
}
