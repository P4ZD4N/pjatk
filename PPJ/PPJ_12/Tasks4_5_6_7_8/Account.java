package Tasks4_5_6_7_8;

import Task1.Person;

import java.io.FileWriter;
import java.io.IOException;

public class Account extends Bill {
    protected double interestRate;

    public Account(Person person, double balance, double interestRate) {
        super(person, balance);
        this.interestRate = interestRate;
    }

    public void update() {
        System.out.println("Owner's name: " + person.getName());
        System.out.println("Type: " + getClass().getSimpleName());
        System.out.println("Balance: "  + balance);

        try {
            FileWriter fileWriter = new FileWriter(getClass().getSimpleName() + "_raport_" + person.getName() + ".txt");
            fileWriter.write("Owner's name: " + person.getName());
            fileWriter.write("\nType: " + getClass().getSimpleName());
            fileWriter.write("\nBalance: " + balance);
            fileWriter.write("\nBalance after adding interest rate: " + (balance + ((balance * interestRate) / 100)));
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Something went wrong");
        }
    }
}
