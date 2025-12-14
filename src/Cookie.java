import edu.macalester.graphics.Ellipse;
import java.awt.Color;

// Creates the cookie-points that Cookie Man collects.

public class Cookie {
    private Ellipse shape;
    private double diameter = 16;
    private double radius = 8;

    public Cookie(double x, double y) {
        shape = new Ellipse(x - radius, y - radius, diameter, diameter);
        shape.setFillColor(Color.YELLOW);
    }

    public Ellipse getShape() {
        return shape;
    }
}
