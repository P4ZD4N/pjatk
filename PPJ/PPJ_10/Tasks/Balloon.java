public class Balloon {
    private double helium;

    public Balloon() {
        helium = 0.005 + Math.random() * (0.009 - 0.005);
    }

    public double getLoad() {
        // PATTERN: 0,007 m^3 of helium can lift 6 grams
        final double HELIUM_PATTERN = 0.007;
        final double WEIGHT_PATTERN = 6;

        return (WEIGHT_PATTERN * helium) / HELIUM_PATTERN;
    }
}
