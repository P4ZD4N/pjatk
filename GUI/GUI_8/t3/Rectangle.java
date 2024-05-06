package t3;

import java.awt.*;
import java.util.Random;

public class Rectangle implements Renderable {

    @Override
    public void render(Graphics graphics) {

        Random random = new Random();

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int x = random.nextInt(1081);
        int y = random.nextInt(1921);

        int radius = random.nextInt(300);

        int filled = random.nextInt(2);

        graphics.setColor(new Color(red, green, blue));

        switch (filled) {
            case 0 -> graphics.drawRect(x, y, radius, radius);
            case 1 -> graphics.fillRect(x, y, radius, radius);
        }
    }
}
