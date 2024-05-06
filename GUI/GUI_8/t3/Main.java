package t3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Frame frame = new Frame();

        List<Circle> circles = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            circles.add(new Circle());
            rectangles.add(new Rectangle());
            triangles.add(new Triangle());
        }

        for (Circle circle : circles) {
            circle.render(frame.getGraphics());
        }

        for (Rectangle rectangle : rectangles) {
            rectangle.render(frame.getGraphics());
        }

        for (Triangle triangle : triangles) {
            triangle.render(frame.getGraphics());
        }
    }
}