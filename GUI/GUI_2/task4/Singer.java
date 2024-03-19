package task4;

public abstract class Singer {

    private static int counter = 0;
    private int id;
    private String name;

    public Singer(String name) {
        this.id = counter++;
        this.name = name;
    }

    public abstract String sing();

    public static Singer loudest(Singer[] singers) {
        return getLoudestSinger(singers);
    }

    private static Singer getLoudestSinger(Singer[] singers) {
        Singer loudestSinger = null;
        int loudestSingerUppercaseLetters = 0;


        for (Singer singer : singers) {
            int thisSingerUppercaseLetters = getThisSingerUppercaseLetters(singer);
            if (isThisSingerLouderThanLoudestSingerSoFar(thisSingerUppercaseLetters, loudestSingerUppercaseLetters)) {
                loudestSinger = singer;
                loudestSingerUppercaseLetters = thisSingerUppercaseLetters;
            }
        }

        return loudestSinger;
    }

    private static int getThisSingerUppercaseLetters(Singer singer) {
        int thisSingerUppercaseLetters = 0;
        String textSangBySinger = singer.sing();

        for (int i = 0; i < textSangBySinger.length(); i++)
            if (Character.isUpperCase(textSangBySinger.charAt(i)))
                thisSingerUppercaseLetters++;
        return thisSingerUppercaseLetters;
    }

    private static boolean isThisSingerLouderThanLoudestSingerSoFar(
            int thisSingerUppercaseLetters, int loudestSingerSoFarUppercaseLetters
    ) {
        return thisSingerUppercaseLetters > loudestSingerSoFarUppercaseLetters;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
