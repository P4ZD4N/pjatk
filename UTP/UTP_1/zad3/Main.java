/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad3;


/*<-- niezbędne importy */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream()
            .filter(destination -> {
                String[] splittedDestination = destination.split(" ");
                return splittedDestination[0].length() == 3 && splittedDestination[0].equalsIgnoreCase("WAW");
            })
            .map(destination -> {
                String[] splittedDestination = destination.split(" ");
                String arrival = splittedDestination[1];
                double priceEUR = Double.parseDouble(splittedDestination[2]);
                double pricePLN = priceEUR * ratePLNvsEUR;

                return "to " + arrival + " - price in PLN: " + (int) pricePLN;
            })
            .collect(Collectors.toList());
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     * Podpowiedź: należy użyć strumieni
     */

    for (String r : result) System.out.println(r);
  }
}
