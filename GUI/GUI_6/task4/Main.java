package task4;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Account account1 = new Account("Wiktor", 10000D);
        Account account2 = new Account("Zuzia", 10000D);

        account1.setBackUpAccount(account2);
        account2.setBackUpAccount(account1);

        double account1BalanceBefore = account1.getBalance();
        double account2BalanceBefore = account2.getBalance();

        account1.start();
        account1.join();
        account2.start();
        account2.join();

        double account1BalanceAfter = account1.getBalance();
        double account2BalanceAfter = account2.getBalance();

        System.out.println();
        System.out.println("Account 1 balance before: " + account1BalanceBefore);
        System.out.println("Account 2 balance before: " + account2BalanceBefore);
        System.out.println("Sum: " + (account1BalanceBefore + account2BalanceBefore));
        System.out.println();
        System.out.println("Account 1 balance after: " + account1BalanceAfter);
        System.out.println("Account 2 balance after: " + account2BalanceAfter);
        System.out.println("Sum: " + (account1BalanceAfter + account2BalanceAfter));
    }
}
