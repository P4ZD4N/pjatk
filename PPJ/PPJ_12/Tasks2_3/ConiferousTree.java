package Tasks2_3;

public class ConiferousTree extends Tree {
    private int needles;
    private double coneLength;

    public ConiferousTree(boolean eternallyGreen, int height, String treeCrossSection, int needles, double coneLength) {
        super(eternallyGreen, height, treeCrossSection);
        this.needles = needles;
        this.coneLength = coneLength;
    }

    @Override
    public String toString() {
        return super.toString() +"{" +
                "needles=" + needles +
                ", coneLength=" + coneLength +
                "}";
    }
}
