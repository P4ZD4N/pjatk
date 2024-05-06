package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Policeman policeman1 = new Policeman("Andrzej", "Śródmieście");
        Policeman policeman2 = new Policeman("Karol", "Wola");
        Policeman policeman3 = new Policeman("Michał", "Targówek");
        Policeman policeman4 = new Policeman("Bartosz", "Włochy");
        Policeman policeman5 = new Policeman("Jakub", "Ursynów");

        Captain captain = new Captain();

        captain.startAll();
        // captain.stopAll();
        captain.changeShifts();
    }
}