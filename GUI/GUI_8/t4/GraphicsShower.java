package t4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GraphicsShower extends JFrame implements ActionListener {

    private JButton browseButton;
    private JTextField filePathField;
    private JLabel imageLabel;

    public GraphicsShower() {

        setTitle("Graphics shower");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        browseButton = new JButton("Browse");
        browseButton.addActionListener(this);

        filePathField = new JTextField(20);
        filePathField.setEditable(false);

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 200));

        panel.add(filePathField);
        panel.add(browseButton);

        add(panel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == browseButton) {

            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                filePathField.setText(filePath);

                ImageIcon icon = new ImageIcon(filePath);
                imageLabel.setIcon(icon);
            }
        }
    }
}
