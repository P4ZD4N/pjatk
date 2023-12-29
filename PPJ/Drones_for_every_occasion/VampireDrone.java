public class VampireDrone {
    private final String construcktor = "Bram Stoker";
    private boolean isTransformed = false;
    private double weight;
    private double batteryLevel;

    public VampireDrone(double weight, double batteryLevel) {
        this.weight = weight;
        this.batteryLevel = batteryLevel;
    }

    public void drainEnergy(Drone drone) {
        if (isTransformed) {
            System.out.println("This drone is Bat Drone!");
        } else {
            double drainedEnergy = drone.getBatteryLevel() / 2;
            drone.setBatteryLevel(drone.getBatteryLevel() - drainedEnergy);
            batteryLevel += drainedEnergy;
            System.out.println("Energy drained!");
        }
    }

    public void turnIntoBatDrone() {
        isTransformed = true;
        batteryLevel /= 2;
        weight /= 2;
        System.out.println("I am Bat Drone now!");
    }

    @Override
    public String toString() {
        return "VampireDrone{" +
                "construcktor='" + construcktor + '\'' +
                ", isTransformed=" + isTransformed +
                ", weight=" + weight +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
