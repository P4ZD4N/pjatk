package App;

public class Trap {
    private static int nextId = 1;
    private int id;
    private String name;
    private double damageAmount;
    private String damageDescription;
    private boolean isActive = true;

    public Trap(String name, double damageAmount, String damageDescription) {
        id = nextId++;
        this.name = name;
        this.damageAmount = damageAmount;
        this.damageDescription = damageDescription;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDamageAmount() {
        return damageAmount;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive() {
        isActive = true;
    }

    public void setInactive() {
        isActive = false;
    }

    @Override
    public String toString() {
        return "Trap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damageAmount=" + damageAmount +
                ", damageDescription='" + damageDescription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
