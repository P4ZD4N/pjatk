package task4;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JFrame {

    private JPanel panelTop;
    private JButton button12;
    private JButton button24;
    private JPanel panelCenter;
    private JLabel timeLabel;
    private Timer timer;

    public Clock() {

        setTitle("Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        panelTop = new JPanel();
        panelTop.setBackground(Color.BLACK);

        button12 = new JButton("12");
        button12.setBackground(Color.GREEN);
        button12.addActionListener(e -> set12HourFormat());

        button24 = new JButton("24");
        button24.setBackground(Color.GREEN);
        button24.addActionListener(e -> set24HourFormat());

        panelTop.add(button12);
        panelTop.add(button24);

        panelCenter = new JPanel();
        panelCenter.setBackground(Color.BLACK);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        timeLabel.setForeground(Color.GREEN);

        panelCenter.add(timeLabel);

        timer = new Timer(1000, e -> {
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            timeLabel.setText(currentTime);
        });
        timer.start();

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
    }

    private void set12HourFormat() {

        timer.stop();
        timer = new Timer(1000, e -> {
            String currentTime = new SimpleDateFormat("hh:mm:ss a").format(new Date());
            timeLabel.setText(currentTime);
        });
        timer.start();
    }

    private void set24HourFormat() {

        timer.stop();
        timer = new Timer(1000, e -> {
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            timeLabel.setText(currentTime);
        });
        timer.start();
    }
}
