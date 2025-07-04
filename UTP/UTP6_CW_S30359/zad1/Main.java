/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad1;


import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    File dataDir = new File("data");
    TravelData travelData = new TravelData(dataDir);
    String dateFormat = "yyyy-MM-dd";
    for (String locale : Arrays.asList("pl_PL", "en_GB")) {
      List<String> odlist = travelData.getOffersDescriptionsList(locale, dateFormat);
      for (String od : odlist) System.out.println(od);
    }
    // --- część bazodanowa
    String url = "jdbc:mysql://127.0.0.1:3306/travels?user=wiktorc";/*<-- tu należy wpisać URL bazy danych */
    Database db = new Database(url, travelData);
    db.create();
    db.showGui();
  }

}
