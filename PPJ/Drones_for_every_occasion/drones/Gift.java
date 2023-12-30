package drones;

public class Gift {
    private String nameOfContent;
    private double weight;
    private boolean isReadyToBeDelivered;

    public Gift(String nameOfContent, double weight) {
        this.nameOfContent = nameOfContent;
        this.weight = weight;
    }

    public void prepare() {
        isReadyToBeDelivered = true;
    }

    public void unpack() {
        if (isReadyToBeDelivered) {
            isReadyToBeDelivered = false;
            System.out.println(
                    "Unpacked drones.Gift{" +
                            "nameOfContent='" + nameOfContent + '\'' +
                            ", weight=" + weight +
                            ", isReadyToBeDelivered=" + isReadyToBeDelivered +
                            '}'
            );
        } else {
            System.out.println("drones.Gift is already unpacked!");
        }
    }

    public double getWeight() {
        return weight;
    }

    public boolean isReadyToBeDelivered() {
        return isReadyToBeDelivered;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "nameOfContent='" + nameOfContent + '\'' +
                ", weight=" + weight +
                ", isReadyToBeDelivered=" + isReadyToBeDelivered +
                '}';
    }
}
