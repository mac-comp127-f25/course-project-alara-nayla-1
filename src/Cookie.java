import edu.macalester.graphics.Ellipse;

import java.awt.Color;

public class Cookie {
    private Ellipse shape;
    private double diameter = 18;
    private double radius = 9;


    public Cookie(double x, double y) {
        shape = new Ellipse(x - radius, y - radius, diameter, diameter);
        shape.setFillColor(Color.YELLOW);
    }

    public Ellipse getShape() {
        return shape;
    }

}
