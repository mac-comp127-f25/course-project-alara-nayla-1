import edu.macalester.graphics.Ellipse;

import java.awt.Color;

public class Cookie {
    private Ellipse shape;
    private double radius = 7;


    public Cookie() {
        shape = new Ellipse(0, 0, radius * 2, radius * 2);
        shape.setFillColor(Color.YELLOW);
    }

    public Ellipse getShape() {
        return shape;
    }

}
