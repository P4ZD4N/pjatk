package task6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        HashMap<Car, Person> carsPersons = new HashMap<>();

        Person kowalski = new Person("Jan", "Kowalski");
        Person nowak = new Person("Adam", "Nowak");
        Person krawczyk = new Person("Bartosz", "Krawczyk");
        Person lewandowski = new Person("Robert", "Lewandowski");

        Car bmw = new Car("BMW", "SCZ12345");
        Car volvo = new Car("Volvo", "SC54321");
        Car renault = new Car("Renault", "SKL69696");
        Car bentley = new Car("Bentley", "WA55555");
        Car toyota = new Car("Toyota", "SCZ43534");
        Car mazda = new Car("Mazda", "SCZ23232");
        Car mercedes = new Car("Mercedes", "SZA44444");
        Car opel = new Car("Opel", "WWL89000");

        carsPersons.put(bmw, kowalski);
        carsPersons.put(volvo, kowalski);
        carsPersons.put(renault, krawczyk);
        carsPersons.put(bentley, lewandowski);
        carsPersons.put(toyota, nowak);
        carsPersons.put(mazda, lewandowski);
        carsPersons.put(mercedes, lewandowski);
        carsPersons.put(opel, nowak);

        for (Car car : carsPersons.keySet()) {
            Person ownerOfThisCar = carsPersons.get(car);

            System.out.print(ownerOfThisCar.getFirstName() + " " + ownerOfThisCar.getLastName());
            System.out.print(" -> ");
            System.out.print(car.getManufacturer() + " " + car.getRegistrationNumber());

            System.out.println();
        }

        for (Car car : carsPersons.keySet()) {
            if (car.getRegistrationNumber().startsWith("SCZ"))
                System.out.println(car.getManufacturer() + " " + car.getRegistrationNumber());
        }
    }
}
