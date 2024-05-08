package t3;

import java.awt.*;
import java.util.Random;

public class Rectangle implements Renderable {

    private int x, y, width, height;
    private Color color;
    private boolean filled;

    public Rectangle() {

        Random random = new Random();

        this.x = random.nextInt(1401);
        this.y = random.nextInt(1001);
        this.width = random.nextInt(100) + 40;
        this.height = random.nextInt(100) + 40;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        this.filled = random.nextBoolean();
    }

    @Override
    public void render(Graphics graphics) {

        graphics.setColor(color);

        if (filled)
            graphics.fillRect(x - width, y - height, width, height);
        else
            graphics.drawRect(x - width, y - height, width, height);
    }
}
