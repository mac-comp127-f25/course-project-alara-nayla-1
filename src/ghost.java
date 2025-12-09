import edu.macalester.graphics.Image;

public class Ghost {
    private Image ghost1;
    private Integer speed = 14;
    private double x;
    private double y;

    public Ghost(double x, double y) {
        this.x = x;
        this.y = y;

        ghost1 = new Image(x, y, "pinkGhost.png");
        ghost1.setMaxHeight(40);
        ghost1.setMaxWidth(40);

        ghost1.setCenter(x, y);
    }
    public Image getShape() {
        return ghost1;

    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    // need to figure out the logic here and how to make the ghosts randomly move

    public void goUp() {
    y -= speed;
    }
}

