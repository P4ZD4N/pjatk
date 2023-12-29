public class Drone {
    private int uniqueId;
    private String name;
    private double weight;
    private double enginePower;
    private double batteryLevel;

    public Drone(int uniqueId, String name, double weight, double enginePower, double batteryLevel) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.weight = weight;
        this.enginePower = enginePower;
        this.batteryLevel = batteryLevel;
    }

    public boolean checkFlyParameters() {
        return enginePower > weight && batteryLevel > 0;
    }

    public void fly(double distance) {
        if (batteryLevel >= distance) {
            batteryLevel = -distance;
            System.out.println("Drone is flying!");
        } else {
            System.out.println("Drone can't fly at this moment!");
        }

    }

    public void revEngine() {
        int numberOfRevs = (int) (enginePower / weight);

        for (int i = 0; i < numberOfRevs; i++)
            System.out.println("Vroom");
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", enginePower=" + enginePower +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
