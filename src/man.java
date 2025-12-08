// import java.awt.Color;

// import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;

    public class Man {
        // private Ellipse shape;
        // private double diameter = 20;
        // private double radius = 10;
        private Image man1;
        private Integer speed = 14;
        private double x;
        private double y;

        public Man(double x, double y) {
            this.x = x;
            this.y = y;

            man1 = new Image(x, y, "pacman.png");
            man1.setMaxHeight(40);
            man1.setMaxWidth(40);

            man1.setCenter(x, y);
        // shape = new Ellipse(x - radius, y - radius, diameter, diameter);
        // shape.setFillColor(Color.RED);
    }
        public Image getShape() {
            return man1;
    // public Ellipse getShape() {
    //     return shape;
    }

    public void goUp() {
        man1.setRotation(270);
        y -= speed;
        man1.setCenter(x,y);
    }
    public void goDown() {
        man1.setRotation(90);
        y += speed;
        man1.setCenter(x,y);
    }
    public void goLeft() {
        man1.setRotation(180);
        x -= speed;
        man1.setCenter(x,y);
    }
    public void goRight() {
        man1.setRotation(0);
        x += speed;
        man1.setCenter(x,y);
    }
    //for hit of walls
    // public void moveTo(double newX, double newY) {
    //     x = newX;
    //     y = newY;
    //     man1.setCenter(x, y);
    // }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
