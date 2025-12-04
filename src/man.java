import java.awt.Color;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;

    public class Man {
        // private Ellipse shape;
        // private double diameter = 20;
        // private double radius = 10;
        private Image man1;

        public Man(double x, double y) {

            man1 = new Image(x, y, "pacman.png");
            man1.setMaxHeight(45);
            man1.setMaxWidth(45);

            man1.setCenter(450, 450);
        // shape = new Ellipse(x - radius, y - radius, diameter, diameter);
        // shape.setFillColor(Color.RED);
    }
        public Image getShape() {
            return man1;
    // public Ellipse getShape() {
    //     return shape;
    }
}
