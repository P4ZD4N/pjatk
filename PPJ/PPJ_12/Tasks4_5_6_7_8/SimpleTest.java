package Tasks4_5_6_7_8;

import Task1.Person;

public class SimpleTest {
    private static Person susan = new Person("Susan");
    private static Person wiktor = new Person("Wiktor");

    private static Bill billWiktor = new Bill(wiktor, 500);
    private static Bill billSusan = new Bill(susan, 500);
    private static Account accountSusan = new Account(susan, 500, 5);
    private static VIPAccount vipAccountSusan = new VIPAccount(susan, 500, 5, 200);

    private static Bill[] bills = {billSusan, accountSusan, vipAccountSusan};

    public static void run() {
        testDepositMethod();
        testWithdrawMethod();
        testTransferMethod();
        testUpdateMethod();
    }

    private static void testDepositMethod() {
        for (Bill bill : bills)
            bill.deposit(50);
    }

    private static void testWithdrawMethod() {
        for (Bill bill : bills)
            bill.withdraw(150);
    }

    private static void testTransferMethod() {
        for (Bill bill : bills)
            bill.transfer(billWiktor, 20);
    }

    private static void testUpdateMethod() {
        for (Bill bill : bills)
            bill.update();
    }
}
