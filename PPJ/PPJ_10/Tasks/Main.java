public class Main {
    public static void main(String[] args) {
        // Task 1
        {
            int radius = 4;
            System.out.println("Area: " + MathOperations.calculateCircleArea(radius, MathOperations.PI));
        }

        // Task 2
        {
            Car car = new Car(56.4, 8);
            Car.drive(car, 720);
        }

        // Task 3
        {
            PersonTask3 person = new PersonTask3();
            person.name = "John";
            person.surname = "Kowalski";
            person.birthYear = 1998;
        }

        // Task 4
        {
            Fruit apple = new Fruit("apple");
            apple.show();
        }

        // Task 5
        {
            PersonTask5 person1 = new PersonTask5("John", "Kowalski", 2003);
            PersonTask5 person2 = new PersonTask5("Michael", "Nowak", 1989);
            PersonTask5 person3 = new PersonTask5("Mark", "Lewandowski", 2000);
            PersonTask5 person4 = new PersonTask5("Matthew", "Brzezinski", 1980);

            person1.introduceYourself();
            person2.introduceYourself();
            person3.introduceYourself();
            person4.introduceYourself();
        }

        // Task 6
        {
            ShoppingCart shoppingCart1 = new ShoppingCart("Wiktor");
            ShoppingCart shoppingCart2 = new ShoppingCart("Łukasz");

            Product product1 = new Product("Milk", 3.50);
            Product product2 = new Product("Cheese", 2.61);
            Product product3 = new Product("Ketchup", 4.10);

            shoppingCart1.addProduct(product1);
            shoppingCart1.addProduct(product2);
            shoppingCart1.addProduct(product3);

            shoppingCart1.displayProducts();

            shoppingCart2.addProduct(product3);

            shoppingCart2.displayProducts();
        }

        // Task 7
        {
            Balloon balloon = new Balloon();
            System.out.println(balloon.getLoad());

            Donkey donkey = new Donkey();
            donkey.addBalloon(balloon);
            System.out.println(donkey.isFlying());

            donkey.makeDonkeyFly(balloon);
        }
    }
}
