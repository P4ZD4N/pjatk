public class Cuboid extends Rectangle {
    private double cuboidHeight;

    public Cuboid(double firstSide, double secondSide, double cuboidHeight) {
        super(firstSide, secondSide);
        this.cuboidHeight = cuboidHeight;
    }

    public double getArea() {
        return (2 * super.getArea()) + (2 * getFirstSide() * cuboidHeight) + (2 * getSecondSide() * cuboidHeight);
    }

    public double getVolume() {
        return super.getArea() * cuboidHeight;
    }
}
