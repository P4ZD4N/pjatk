package App;

import Exceptions.NoGiftsLeftException;

public class Santa extends Person {
    private boolean isWorking;
    private String cityLocation;
    private String[] cityHistory = new String[0];
    private Child[] naughtyKidsList;
    private Gift[] gifts = new Gift[0];

    public Santa(String name, String lastName, int age, Child[] naughtyKidsList) {
        super(name, lastName, age);
        this.naughtyKidsList = naughtyKidsList;
    }

    public void startWork() {
        if (!isWorking) {
            isWorking = true;
            System.out.println("Santa starts working!");
        } else
            System.out.println("Santa is working!");
    }

    public void stopWork() {
        if (areAllGiftsGiven() && isWorking) {
            isWorking = false;
            System.out.println("Santa stops working!");
        } else
            System.out.println("Santa can't stop working right now!");
    }

    private boolean areAllGiftsGiven() {
        for (Gift gift : gifts)
            if (gift != null)
                return false;

        return true;
    }

    public void giveGift(Child child) {
        if (wasKidNaughty(child)) {
            System.out.println("This kid was naughty!");
        } else {
            for (int i = gifts.length - 1; i >= 0; i--)
                if (gifts[i] != null) {
                    if (gifts[i].getContent().equals(child.getDreamGift()))
                        System.out.println("He/She dreamt about this gift!");
                    else
                        System.out.println("He/She thanked for this gift!");

                    gifts[i] = null;
                    break;
                }
        }
    }

    private boolean wasKidNaughty(Child child) {
        for (Child naughtyKid : naughtyKidsList)
            if (child.equals(naughtyKid))
                return true;

        return false;
    }

    public void visitCity(String city) {
        if (didSantaVisitedCity(city)) {
            System.out.println("Santa visited this city earlier!");
        } else {
            cityLocation = city;

            String[] newCityHistory = new String[cityHistory.length + 1];

            for (int i = 0; i < cityHistory.length; i++)
                newCityHistory[i] = cityHistory[i];

            newCityHistory[cityHistory.length] = city;

            cityHistory = newCityHistory;

            System.out.println("Santa is in " + city + " right now!");
        }
    }

    private boolean didSantaVisitedCity(String city) {
        for (String visitedCity : cityHistory)
            if (visitedCity.equals(city))
                return true;

        return false;
    }

    public Gift findHeaviestGift() {
        if (gifts.length == 0)
            throw new NoGiftsLeftException("No gifts left!");
        else {
            Gift heaviest = gifts[0];

            for (Gift gift : gifts)
                if (gift.getWeight() > heaviest.getWeight())
                    heaviest = gift;

            return heaviest;
        }
    }

    public void addGift(Gift gift) {
        Gift newGift = gift;

        if (gift == null) {
            newGift = new Gift("The principal's father's handshake", 0);
        }

        Gift[] newGifts = new Gift[gifts.length + 1];

        for (int i = 0; i < gifts.length; i++)
            newGifts[i] = gifts[i];

        newGifts[gifts.length] = newGift;

        gifts = newGifts;
    }
}
