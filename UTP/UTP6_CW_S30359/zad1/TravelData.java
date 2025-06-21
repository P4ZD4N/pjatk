package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class TravelData {

    private final List<TravelOffer> travelOffers = new ArrayList<>();

    public TravelData(File dataDir) {
        for (File file : Objects.requireNonNull(dataDir.listFiles())) {

            if (!file.getName().endsWith(".txt")) {
                continue;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    travelOffers.add(new TravelOffer(line));
                }
            } catch (Exception e) {
                System.out.println("Error with reading file '" + file.getPath() + "': " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public List<String> getOffersDescriptionsList(String loc, String dateFormat) {

        Locale locale = Locale.forLanguageTag(loc.replace('_', '-'));
        DateFormat format = new SimpleDateFormat(dateFormat);
        ResourceBundle bundle = ResourceBundle.getBundle("translations", locale);

        return travelOffers.stream()
                .map(offer -> offer.toLocalizedString(locale, format, bundle))
                .collect(Collectors.toList());
    }

    public List<TravelOffer> getTravelOffers() {
        return travelOffers;
    }
}
