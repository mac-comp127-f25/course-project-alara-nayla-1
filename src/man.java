import edu.macalester.graphics.Image;

public class Man {
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
    }

    public Image getShape() {
        return man1;
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

    public double getX() {
        return x;
    }
    
    public double getY() {
    return y;
    }

    public void resetPosition(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        man1.setCenter(x, y);
    }
}
