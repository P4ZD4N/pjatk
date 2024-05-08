package t3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel {

    private List<Renderable> shapes;
    private Frame frame;

    public Panel(Frame frame) {

        this.frame = frame;

        shapes = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            shapes.add(new Circle());
            shapes.add(new Rectangle());
            shapes.add(new Triangle());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Renderable shape : shapes) {
            shape.render(g);
        }
        setBackground(Color.BLACK);
    }

    public void saveShapesAsImages() {

        int index = 1;

        for (Renderable shape : shapes) {
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();

            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            shape.render(g2d);
            g2d.dispose();

            try {

                ImageIO.write(image, "png", new File(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)) + ".png"));
                index++;
            } catch (IOException e) {

                System.out.println("Something went wrong!");
            }
        }
    }
}
