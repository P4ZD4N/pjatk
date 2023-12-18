import java.util.Arrays;

public class Donkey {
    private double mass = 400;
    private Balloon[] balloons = new Balloon[0];

    void addBalloon(Balloon balloon) {
        Balloon[] balloonsTemp = new Balloon[balloons.length + 1];
        for (int i = 0; i < balloons.length; i++)
            balloonsTemp[i] = balloons[i];
        balloonsTemp[balloonsTemp.length - 1] = balloon;
        balloons = balloonsTemp;
    }

    boolean isFlying() {
        double donkeyMassInGrams = mass * 1_000;
        double balloonsCanLift = 0;

        for (Balloon balloon : balloons)
            balloonsCanLift += balloon.getLoad();

        return balloonsCanLift >= donkeyMassInGrams;
    }

    void makeDonkeyFly(Balloon balloon) {
        Donkey donkey = new Donkey();

        int balloonsUsedToLiftDonkey = 0;
        while (!(donkey.isFlying())) {
            balloonsUsedToLiftDonkey++;
            donkey.addBalloon(balloon);
        }

        System.out.println(
                "I fly!!! (Balloons with load " +
                balloon.getLoad() +
                " used to lift donkey: " +
                balloonsUsedToLiftDonkey +
                ")"
        );
    }
}
