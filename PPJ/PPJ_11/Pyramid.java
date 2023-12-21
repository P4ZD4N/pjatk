public class Pyramid extends Triangle {
    private double height;

    public Pyramid(double side, double height) {
        super(side);
        this.height = height;
    }

    public double getArea() {
        return super.getArea() + (0.5 * super.getArea() * ((Math.sqrt(3)) * getSide()));
    }

    public double getVolume() {
        return (super.getArea() * height) / 3;
    }
}
