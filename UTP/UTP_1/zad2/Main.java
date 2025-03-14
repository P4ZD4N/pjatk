/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad2;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(dest -> {
                            String[] splittedDest = dest.split(" ");
                            return splittedDest[0].length() == 3 && splittedDest[0].equalsIgnoreCase("WAW");
                       }  /*<-- lambda wyrażenie
                                *  selekcja wylotów z Warszawy (zaczynających się od WAW)
                                */
                       )
                       .mapEvery(dest -> {
                           String[] splittedDest = dest.split(" ");
                           String arrival = splittedDest[1];
                           double priceEUR = Double.parseDouble(splittedDest[2]);
                           double pricePLN = priceEUR * xrate;

                           return "to " + arrival + " - price in PLN: " + (int) pricePLN;
                       }/*<-- lambda wyrażenie
                                   *  wyliczenie ceny przelotu w PLN
                                   *  i stworzenie wynikowego napisu
                                   */
                       );
  }

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
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
