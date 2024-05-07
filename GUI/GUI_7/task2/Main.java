package task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Bandit bandit = Bandit.createBandit();

        Policeman policeman1 = new Policeman("Andrzej", "Śródmieście");
        Policeman policeman2 = new Policeman("Karol", "Wola");
        Policeman policeman3 = new Policeman("Michał", "Targówek");
        Policeman policeman4 = new Policeman("Bartosz", "Włochy");
        Policeman policeman5 = new Policeman("Jakub", "Ursynów");

        bandit.start();
        Captain.startAll();
    }
}