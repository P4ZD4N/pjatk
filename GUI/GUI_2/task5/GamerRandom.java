package task5;

public class GamerRandom implements IGamer {

    @Override
    public int play() {
        int min = 1;
        int max = 3;
        int choice = (int) (Math.random() * (max - min + 1) + min);

        return choice;
    }

    @Override
    public String name() {
        return null;
    }
}
