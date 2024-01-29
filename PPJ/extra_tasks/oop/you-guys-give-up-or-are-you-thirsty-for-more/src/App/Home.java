package App;

import java.util.Arrays;

public class Home {
    private String address;
    private String ownersName;
    private Kevin kidInside;
    private Trap[] traps = new Trap[0];

    public Home(String address, String ownersName) {
        this.address = address;
        this.ownersName = ownersName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isKidInside() {
        return kidInside != null;
    }

    public Kevin getKidInside() {
        return kidInside;
    }

    public void setKidInside(Kevin kidInside) {
        this.kidInside = kidInside;
    }

    public Trap[] getTraps() {
        return traps;
    }

    public void setTraps(Trap[] traps) {
        this.traps = traps;
    }

    @Override
    public String toString() {
        return "Home{" +
                "address='" + address + '\'' +
                ", ownersName='" + ownersName + '\'' +
                ", kidInside=" + (kidInside != null ? kidInside.getName() : "null") +
                ", traps=" + Arrays.toString(traps) +
                '}';
    }
}
