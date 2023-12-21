public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");

        // Task 1
        {
            Corn corn = new Corn(4);
            System.out.println(corn.makePopcorn());
        }

        System.out.println("Task 2:");

        // Task 2
        {
            Person person1 = new Person("Wiktor", 2003);
            Person person2 = new Person("Paweł", 2009);
            Person person3 = new Person("Michał", 1980);
            Person person4 = new Person("Zuzia", 1998);
            Person person5 = new Person("Piotr", 2006);
            Person[] persons = {person1, person2, person3, person4, person5};

            System.out.println(person1.getName());
            System.out.println(person3.getAge());
            System.out.println(Person.getOlder(person3, person4));
            System.out.println(Person.getOldest(persons));

            System.out.println();

            for (Person person : persons) {
                System.out.println(person);
            }

            Person.sortByAgeAscending(persons);
            System.out.println();

            for (Person person : persons) {
                System.out.println(person);
            }

            Person.sortByAgeDescending(persons);
            System.out.println();

            for (Person person : persons) {
                System.out.println(person);
            }
        }

        System.out.println("Task 3:");

        // Task 3
        {
            Word word = new Word();

            word.addChar('p');
            word.addChar('j');
            word.addChar('a');
            word.addChar('t');
            word.addChar('k');

            word.show();

            System.out.println();
            System.out.println(word.length());
        }

        System.out.println("Task 4:");

        // Task 4
        {
            Word word1 = new Word();

            word1.addChar('I');

            Word word2 = new Word();

            word2.addChar('l');
            word2.addChar('o');
            word2.addChar('v');
            word2.addChar('e');

            Word word3 = new Word();

            word3.addChar('P');
            word3.addChar('J');
            word3.addChar('A');
            word3.addChar('T');
            word3.addChar('K');

            PhraseArray phraseArray = new PhraseArray();

            phraseArray.addWordAtEnd(word1);
            phraseArray.addWordAtEnd(word2);
            phraseArray.addWordAtEnd(word3);

            phraseArray.show();

            System.out.println();

            PhraseSinglyLinkedList phraseSinglyLinkedList = new PhraseSinglyLinkedList();

            phraseSinglyLinkedList.addWordAtEnd(word1);
            phraseSinglyLinkedList.addWordAtEnd(word2);
            phraseSinglyLinkedList.addWordAtEnd(word3);

            phraseSinglyLinkedList.show();
        }

        System.out.println("Task 5: ");

        // Task 5
        {
            Rectangle rectangle = new Rectangle(5, 6);
            System.out.println(rectangle.getArea());

            System.out.println();

            Cuboid cuboid = new Cuboid(5, 6, 7);
            System.out.println(cuboid.getArea());
            System.out.println(cuboid.getVolume());

            System.out.println();

            Triangle triangle = new Triangle(4);
            System.out.println(triangle.getArea());

            System.out.println();

            Pyramid pyramid = new Pyramid(5, 6);
            System.out.println(pyramid.getArea());
            System.out.println(pyramid.getVolume());

            System.out.println();

            Prism prism = new Prism(8, 6);
            System.out.println(prism.getArea());
            System.out.println(prism.getVolume());
        }
    }
}