package Tasks4_5_6_7_8;

import Exceptions.DebitLimitExceededException;
import Task1.Person;

import java.io.FileWriter;
import java.io.IOException;

public class VIPAccount extends Account {
    private static int debitExceedCounter = 0;
    protected double debitLimit;

    public VIPAccount(Person person, double balance, double interestRate, double debitLimit) {
        super(person, balance, interestRate);
        this.debitLimit = 0 - debitLimit;
    }

    public void withdraw(double amount) {
        try {
            if (debitLimit > balance - amount) {
                throw new DebitLimitExceededException("");
            } else {
                balance -= amount;
                System.out.println("New withdraw: " + amount);
                System.out.println("Balance after operation: " + balance);
            }
        } catch (DebitLimitExceededException e) {
            System.out.println("You exceeded your debit limit! You can't perform this operation!");
            debitExceedCounter++;
        }
    }

    public void transfer(Bill bill, double amount) {
        try {
            if (debitLimit > balance - amount) {
                throw new DebitLimitExceededException("");
            } else {
                balance -= amount;
                bill.balance += amount;
                System.out.println("New transfer: " + amount + " to " + bill.person.getName() + "'s bill");
                System.out.println("Balance after operation: " + balance);
            }
        } catch (DebitLimitExceededException e) {
            System.out.println("You exceeded your debit limit! You can't perform this operation!");
            debitExceedCounter++;
        }
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
            fileWriter.write("\nBalance after adding interest rate: " + (balance + Math.abs(balance * interestRate) / 100));
            fileWriter.write("\nAttempts to exceed debit: " + debitExceedCounter);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Something went wrong");
        }
    }
}
