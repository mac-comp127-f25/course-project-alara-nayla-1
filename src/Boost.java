import java.awt.Color;
import edu.macalester.graphics.Ellipse;

// Boost will provide Cookie Man with a speed power to collect cookies faster.

public class Boost {
    private Ellipse shape;
    private double diameter = 18;
    private double radius = 9;
    public boolean active = true;

    public Boost(double x, double y) {
        shape = new Ellipse(x - radius, y - radius, diameter, diameter);
        shape.setFillColor(Color.GREEN);
    }

    public Ellipse getShape() {
        return shape;
    }

    public boolean isActive() {
        return active;
    }

    public void deactive() {
        active = false;
    }
}
