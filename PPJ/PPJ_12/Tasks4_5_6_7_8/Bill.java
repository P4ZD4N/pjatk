package Tasks4_5_6_7_8;

import Exceptions.NotEnoughMoneyException;
import Task1.Person;

import java.io.FileWriter;
import java.io.IOException;

public class Bill {
    protected Person person;
    protected double balance;

    public Bill(Person owner, double balance) {
        this.person = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("New deposit: " + amount);
        System.out.println("Balance after operation: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new NotEnoughMoneyException("You don't have enough money to perform this operation!");
        } else {
            balance -= amount;
            System.out.println("New withdraw: " + amount);
            System.out.println("Balance after operation: " + balance);
        }
    }

    public void transfer(Bill bill, double amount) {
        if (amount > balance) {
            throw new NotEnoughMoneyException("You don't have enough money to perform this operation!");
        } else {
            balance -= amount;
            bill.balance += amount;
            System.out.println("New transfer: " + amount + " to " + bill.person.getName() + "'s bill");
            System.out.println("Balance after operation: " + balance);
        }
    }

    public double getBalance() {
        return balance;
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
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Something went wrong");
        }
    }
}
