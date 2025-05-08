/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomersPurchaseSortFind {

    private File file;
    private List<Purchase> purchases;

    public void readFile(String filePath) {
        file = new File(filePath);
        Scanner reader;

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        List<Purchase> purchases = new ArrayList<>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] lineSplit = line.split(";");
            purchases.add(new Purchase(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]));
        }

        reader.close();

        this.purchases = purchases;
    }

    public void showSortedBy(String sortedBy) {
        if (sortedBy.equalsIgnoreCase("nazwiska")) {
            try {
                showSortedByNazwiska();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else if (sortedBy.equalsIgnoreCase("koszty")) {
            try {
                showSortedByKoszty();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
    }

    private void showSortedByNazwiska() throws FileNotFoundException {
        List<Purchase> sorted = new ArrayList<>(purchases);
        sorted.sort(
            Comparator
                .comparing((Purchase p) -> p.getFullName().split(" ")[0])
                .thenComparing(Comparator.comparing(Purchase::getId).reversed())
        );

        System.out.println("Nazwiska");
        sorted.forEach(System.out::println);
    }

    private void showSortedByKoszty() throws FileNotFoundException {
        List<Purchase> sorted = new ArrayList<>(purchases);

        sorted.sort(
            Comparator
                .comparing((Purchase p) -> Float.parseFloat(p.getPrice()) * Float.parseFloat(p.getQuantity())).reversed()
                .thenComparing(Purchase::getId)
        );

        System.out.println("Koszty");
        sorted.forEach(purchase ->
            System.out.println(
                purchase +
                " (koszt: " +
                Float.parseFloat(purchase.getPrice()) * Float.parseFloat(purchase.getQuantity()) +
                ")"
            )
        );
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        purchases.stream()
            .filter(purchase -> purchase.getId().equalsIgnoreCase(id))
            .forEach(System.out::println);
    }
}
