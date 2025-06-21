package zad1;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class Database {

    private final String url;
    private final TravelData travelData;

    public Database(String url, TravelData travelData) {
        this.url = url;
        this.travelData = travelData;
    }

    public void create() {

        try (Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS travel_offers");
            statement.executeUpdate(
            "CREATE TABLE travel_offers " +
                "(country VARCHAR(100), departure DATE, arrival DATE, place VARCHAR(100), price DOUBLE, currency VARCHAR(100))");

            PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO travel_offers(country, departure, arrival, place, price, currency) " +
                "VALUES (?, ?, ?, ?, ?, ?)");

            travelData.getTravelOffers().forEach(travelOffer -> {
                try {
                    preparedStatement.setString(1, travelOffer.getCountry());
                    preparedStatement.setString(2, travelOffer.getDeparture().toString());
                    preparedStatement.setString(3, travelOffer.getArrival().toString());
                    preparedStatement.setString(4, travelOffer.getPlace());
                    preparedStatement.setDouble(5, travelOffer.getPrice());
                    preparedStatement.setString(6, travelOffer.getCurrency());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Failed to insert travel offer: " + e.getMessage());
                }
            });
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public void showGui() {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Travel offers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);

            JComboBox<String> localeBox = new JComboBox<>(new String[]{"pl_PL", "en_GB"});
            JTextField dateFormatField = new JTextField("yyyy-MM-dd", 10);
            JButton refreshButton = new JButton("Refresh");

            JTable table = new JTable(new DefaultTableModel(new String[]{"Travel offers"}, 0));
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Locale: "));
            topPanel.add(localeBox);
            topPanel.add(new JLabel("Date format:"));
            topPanel.add(dateFormatField);
            topPanel.add(refreshButton);

            refreshButton.addActionListener(e -> {
                String loc = (String) localeBox.getSelectedItem();
                String dateFormat = dateFormatField.getText();
                List<String> travelOffers = travelData.getOffersDescriptionsList(loc, dateFormat);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                travelOffers.forEach(offer -> model.addRow(new Object[]{offer}));
            });

            frame.getContentPane().add(topPanel, "North");
            frame.getContentPane().add(scrollPane, "Center");
            frame.setVisible(true);
            refreshButton.doClick();
        });
    }
}
