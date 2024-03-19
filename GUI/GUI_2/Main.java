import task1.Square;
import task2.Animal;
import task3.Amphibious;
import task3.Auto;
import task3.Boat;
import task4.Singer;
import task5.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // TASK 1

        Square square1 = new Square(5);
        Square square2 = new Square(4);
        Square square3 = new Square(7);
        Square square4 = new Square(8);
        Square square5 = new Square(2);

        List<Square> squares = new ArrayList<>(List.of(square1, square2, square3, square4, square5));

        for (Square square : squares)
            System.out.println(square);

        Collections.sort(squares);
        System.out.println("---");

        for (Square square : squares)
            System.out.println(square);

        // TASK 2

        Animal wiktor = new Animal("wiktor");

        wiktor.speak();
        wiktor.move();
        wiktor.eat();

        // TASK 3

        Auto auto = new Auto();
        Boat boat = new Boat();
        Amphibious amphibious = new Amphibious();

        auto.move();
        boat.move();
        amphibious.move();

        // TASK 4

        Singer s1 = new Singer("Eminem") {
            @Override
            public String sing() {
                return "Will the real Slim Shady please stand up? I repeat, will the real Slim Shady please stand up?";

            }
        };
        Singer s2 = new Singer("Snoop Dogg") {
            @Override
            public String sing() {
                return "That's how it is for me 'cause I live a boss' life";
            }
        };
        Singer s3 = new Singer("50 Cent") {
            @Override
            public String sing() {
                return "I'll take you to the candy shop, I'll let you lick the lollipop";
            }
        };

        Singer[] singers = {s1, s2, s3};

        for (Singer singer : singers)
            System.out.println(singer);

        System.out.println("\n" + Singer.loudest(singers));

        // TASK 5

        Arena arena = new Arena(new GamerRandom(), new GamerPaper());
        arena.fight(2);
    }
}