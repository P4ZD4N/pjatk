package t3;

import java.awt.*;
import java.util.Random;

public class Circle implements Renderable{

    private int x, y, radius;
    private Color color;
    private boolean filled;

    public Circle() {

        Random random = new Random();

        this.x = random.nextInt(1401);
        this.y = random.nextInt(1001);
        this.radius = random.nextInt(100) + 40;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        this.filled = random.nextBoolean();
    }

    @Override
    public void render(Graphics graphics) {

        graphics.setColor(color);

        if (filled)
            graphics.fillOval(x - radius, y - radius, radius, radius);
        else
            graphics.drawOval(x - radius, y - radius, radius, radius);
    }
}
