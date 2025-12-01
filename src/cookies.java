import edu.macalester.graphics.Ellipse;

import java.awt.Color;
import java.awt.Shape;

public class Cookies {
    private Ellipse shape;
    private double radius = 7;


    public Cookies() {
        shape = new Ellipse(x, y, radius * 2, radius * 2);
        shape.setFillColor(color);
        this.radius = radius;
    }

    public Ellipse getShape() {
        return shape;
    }

}
