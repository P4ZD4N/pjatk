package task4;

import java.util.Random;

public class Account extends Thread {

    private String ownerName;
    private Account backUpAccount;
    private double balance;

    public Account(String ownerName, double balance) {

        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Account getBackUpAccount() {
        return backUpAccount;
    }

    public void setBackUpAccount(Account backUpAccount) {
        this.backUpAccount = backUpAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void send(Account account) {

        for (int i = 0; i < 8; i++) {

            Random random = new Random();
            double amount = random.nextDouble(51);

            this.balance -= amount;

            account.setBalance(account.getBalance() + amount);

            System.out.println(this.getOwnerName() + " sent " + amount + " to " + account.getOwnerName() + "'s account");
        }
    }

    @Override
    public void run() {

        send(backUpAccount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", backUpAccount=" + backUpAccount +
                ", balance=" + balance +
                '}';
    }
}
