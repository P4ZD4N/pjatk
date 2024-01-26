package Task1;

public class Welder extends Person {
    private int yearsOfWork;

    public Welder(String name, int yearsOfWork) {
        super(name);
        this.yearsOfWork = yearsOfWork;
    }

    public String getName() {
        return super.getName() + ", seniority: " + yearsOfWork + " years";
    }
}
