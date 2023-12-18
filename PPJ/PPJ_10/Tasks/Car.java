public class Car {
    private double fuelLevel;
    private double fuelConsumptionPer100Km;

    public Car(double fuelLevel, double fuelConsumptionPer100Km) {
        this.fuelLevel = fuelLevel;
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
    }

    public static void drive(Car car, int distance) {
        double fuelConsumption = (distance / 100D) * car.fuelConsumptionPer100Km;
        if (car.fuelLevel >= fuelConsumption)
            System.out.println("Engine started! Remaining fuel liters after this distance: " + (car.fuelLevel - fuelConsumption));
        else
            System.out.println("Not enough fuel! " + (fuelConsumption - car.fuelLevel) + " liters of fuel missing");
    }
}
