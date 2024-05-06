package t3;

import java.awt.*;
import java.util.Random;

public class Triangle implements Renderable {

    @Override
    public void render(Graphics graphics) {

        Random random = new Random();

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int[] xPoints = {random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)};
        int[] yPoints = {random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)};

        int filled = random.nextInt(2);

        graphics.setColor(new Color(red, green, blue));

        switch (filled) {
            case 0 -> graphics.drawPolygon(xPoints, yPoints, 3);
            case 1 -> graphics.fillPolygon(xPoints, yPoints, 3);
        }
    }
}
