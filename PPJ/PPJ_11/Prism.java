public class Prism extends Triangle {
    private double height;

    public Prism(double side, double height) {
        super(side);
        this.height = height;
    }

    public double getArea() {
        return (2 * super.getArea()) + (3 * (getSide() * height));
    }

    public double getVolume() {
        return super.getArea() * height;
    }
}
