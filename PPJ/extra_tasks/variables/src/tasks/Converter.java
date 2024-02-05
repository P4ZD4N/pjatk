package tasks;

public class Converter {
    public static double getCentimetersToInches(double centimeters) {
        return centimeters / 2.54;
    }

    public static double getCentimetersToMeters(double centimeters) {
        return centimeters / 100;
    }

    public static double getCentimetersToKilometers(double centimeters) {
        return centimeters / 1000;
    }

    public static double getCentimetersToMiles(double centimeters) {
        return centimeters / 160_934.4;
    }
}
