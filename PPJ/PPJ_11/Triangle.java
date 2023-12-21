public class Triangle {
    private double side;

    public Triangle(double side) {
        this.side = side;
    }

    public double getArea() {
        return (Math.pow(side, 2) * Math.sqrt(3)) / 4;
    }

    public double getSide() {
        return side;
    }
}
