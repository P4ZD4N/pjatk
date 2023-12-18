public class PersonTask5 {
    public String name;
    public String surname;
    public int birthYear;

    PersonTask5(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public void introduceYourself() {
        System.out.println(
                "Hello! My name is " + this.name
                + ". My surname is " + this.surname
                + ". I was born in " + this.birthYear
                + "."
        );
    }
}
