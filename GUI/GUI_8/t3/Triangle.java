package t3;

import java.awt.*;
import java.util.Random;

public class Triangle implements Renderable {

    private int x, y;
    private int[] xPoints, yPoints;
    private Color color;
    private boolean filled;

    public Triangle() {

        Random random = new Random();

        this.x = random.nextInt(1201) + 100;
        this.y = random.nextInt(801) + 100;
        this.xPoints = new int[] {random.nextInt(801) + 50, random.nextInt(801) + 50, random.nextInt(801) + 50};
        this.yPoints = new int[] {random.nextInt(801) + 50, random.nextInt(801) + 50, random.nextInt(801) + 50};
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        this.filled = random.nextBoolean();
    }

    @Override
    public void render(Graphics graphics) {

        graphics.setColor(color);

        if (filled)
            graphics.fillPolygon(xPoints, yPoints, 3);
        else
            graphics.drawPolygon(xPoints, yPoints, 3);
    }
}
