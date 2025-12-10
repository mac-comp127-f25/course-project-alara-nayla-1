import java.util.Random;

import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class Ghost {
    private Image ghost1;
    // private Integer speed = 14;
    // private double x;
    // private double y;
    private double x, y;
    private double speed = 8;

    private int direction;
    private Random rand = new Random();

    private Walls walls;
    private GameBoard board;

    public Ghost(double x, double y, Walls walls, GameBoard board) {
        this.x = x;
        this.y = y;
        this.walls = walls;
        this.board = board;

        ghost1 = new Image(x, y, "pinkGhost.png");
        ghost1.setMaxHeight(40);
        ghost1.setMaxWidth(40);
        ghost1.setCenter(x, y);

        direction = rand.nextInt(4);
    }
    public Image getShape() {
        return ghost1;

    }
    // public double getX() {
    //     return x;
    // }
    // public double getY() {
    //     return y;
    // }
    public void update() {
        double newX = x;
        double newY = y;

        if (direction == 0) newY -= speed;
        if (direction == 1) newY += speed;
        if (direction == 2) newX -= speed;
        if (direction == 3) newX += speed;

        if (collidesWithWall(newX,newY) || collidesWithBorder(newX, newY)) {
            direction = rand.nextInt(4);
            return;
        }
        x = newX;
        y = newY;
        ghost1.setCenter(x, y);

        if (rand.nextInt(40) == 0) {
            direction = rand.nextInt(4);
        }
    }
    private boolean collidesWithBorder(double newX, double newY) {
        double w = ghost1.getWidth();
        double h = ghost1.getHeight();

        double left = newX - w/2;
        double right = newX + w/2;
        double top = newY - h/2;
        double bottom = newY + h/2;

        return left < 0 || top < 0 ||
               right > board.getWidth() ||
               bottom > board.getHeight();


    }
    private boolean collidesWithWall(double newX, double newY) {
        double w = ghost1.getWidth();
        double h = ghost1.getHeight();
       
        double left = newX - w/2;
        double right = newX + w/2;
        double top = newY - h/2;
        double bottom = newY + h/2;

        for(Rectangle wall : walls.getWalls()) {
            double wl = wall.getX();
            double wr = wl + wall.getWidth();
            double wt = wall.getY();
            double wb = wt + wall.getHeight();

            boolean overlap =
                right > wl && left < wr &&
                bottom > wt && top < wb;

            if (overlap) return true;
        }
        return false;
    }

}

