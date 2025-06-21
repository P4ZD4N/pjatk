package zad1;


import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TravelOffer {

    private final Locale locale;
    private final String countryName;
    private final String countryCode;
    private final Date departure;
    private final Date arrival;
    private final String place;
    private final Double price;
    private final String currency;

    public TravelOffer(String line) throws ParseException {
        String[] parts = line.split("\t");

        locale = Locale.forLanguageTag(parts[0].replace('_', '-'));
        countryName = parts[1];
        countryCode = Arrays.stream(Locale.getAvailableLocales())
                .filter(loc -> loc.getDisplayCountry(locale).equalsIgnoreCase(countryName))
                .map(Locale::getCountry)
                .filter(code -> !code.isEmpty())
                .findFirst()
                .orElse("");
        departure = Date.valueOf(parts[2]);
        arrival = Date.valueOf(parts[3]);
        place = parts[4];

        NumberFormat format = NumberFormat.getInstance(locale);
        Number number = format.parse(parts[5]);

        price = number.doubleValue();
        currency = parts[6];
    }

    public String toLocalizedString(Locale locale, DateFormat dateFormat, ResourceBundle bundle) {

        String translatedCountry = translateCountry(locale);
        String translatedPlace = translatePlace(place, bundle);

        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(2);

        return String.format(
                "%s %s %s %s %s %s",
                translatedCountry,
                dateFormat.format(departure),
                dateFormat.format(arrival),
                translatedPlace,
                numberFormat.format(price),
                currency
        );
    }

    private String translateCountry(Locale locale) {
        if (countryCode == null || countryCode.isEmpty()) return countryName;
        return new Locale("", countryCode).getDisplayCountry(locale);
    }

    private String translatePlace(String place, ResourceBundle bundle) {

        try {
            return bundle.getString(place.toLowerCase());
        } catch (MissingResourceException e) {
            return place;
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public String getCountry() {
        return countryName;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public String getPlace() {
        return place;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
