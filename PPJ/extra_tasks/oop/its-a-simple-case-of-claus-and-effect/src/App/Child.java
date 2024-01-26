package App;

public class Child extends Person {
    private int schoolClass;
    private String dreamGift;

    public Child(String name, String lastName, int age, int schoolClass, String dreamGift) {
        super(name, lastName, age);
        this.schoolClass = schoolClass;
        this.dreamGift = dreamGift;
    }

    public int getSchoolClass() {
        return schoolClass;
    }

    public String getDreamGift() {
        return dreamGift;
    }
}
