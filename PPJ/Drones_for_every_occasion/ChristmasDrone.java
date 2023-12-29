public class ChristmasDrone {
    private Gift gift;
    private double weight;
    private double enginePower;

    public ChristmasDrone(Gift gift, double weight, double enginePower) {
        this.gift = gift;
        this.weight = weight;
        this.enginePower = enginePower;
    }

    public void deliverGift() {
        if (weight + gift.getWeight() > enginePower || gift == null || !gift.isReadyToBeDelivered()) {
            System.out.println("Gift cannot be delivered!");
        } else {
            System.out.println("Delivered " + gift);
            gift = null;
        }
    }

    @Override
    public String toString() {
        return "ChristmasDrone{" +
                "gift=" + gift +
                ", weight=" + weight +
                ", enginePower=" + enginePower +
                '}';
    }
}
