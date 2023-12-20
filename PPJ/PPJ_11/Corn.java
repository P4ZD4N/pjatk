public class Corn {
    private int cornCount;

    public Corn(int cornCount) {
        this.cornCount = cornCount;
    }

    public Popcorn[] makePopcorn() {
        Popcorn[] popcorn = new Popcorn[cornCount];
        for (int i = 0; i < cornCount; i++)
            popcorn[i] = new Popcorn();
        return popcorn;
    }
}
