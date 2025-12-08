import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

public class Controller {
    private Man man;
    private Walls walls;
    private GameBoard board;
    private final double SPEED = 10;

    public Controller(Man man, Walls walls, GameBoard board) {
        this.man = man;
        this.walls = walls;
        this.board = board;
    }

    public void keyPressed(KeyboardEvent k) {
        Image shape = man.getShape();
        double newLeft = shape.getX();
        double newTop = shape.getY();


        if (k.getKey() == Key.DOWN_ARROW){
            newTop += SPEED;
            if (!collidesWithWall(newLeft, newTop)) man.goDown();

        } else if (k.getKey() == Key.UP_ARROW) {
            newTop -= SPEED;
            if (!collidesWithWall(newLeft, newTop)) man.goUp();

        } else if (k.getKey() == Key.LEFT_ARROW) {
            newLeft -= SPEED;
            if (!collidesWithWall(newLeft, newTop)) man.goLeft();

        } else if (k.getKey() == Key.RIGHT_ARROW) {
            newLeft += SPEED;
            if (!collidesWithWall(newLeft, newTop)) man.goRight();
        }

        board.getCookies().eatCookies(man);
    }
    private boolean collidesWithWall(double newX, double newY) {
        Image shape = man.getShape();
        double w = shape.getWidth();
        double h = shape.getHeight();

        double left = newX;
        double right = newX + w;
        double top = newY;
        double bottom = newY + h;

        if (left < 0 || top < 0 ||
            right > board.getWidth() ||
            bottom > board.getHeight()) {
                return true;
            }
        

        for(Rectangle wall : walls.getWalls()) {
            double wl = wall.getX();
            double wr = wl + wall.getWidth();
            double wt = wall.getY();
            double wb = wt + wall.getHeight();

            boolean overlap = right > wl && left < wr && bottom > wt && top < wb;

            if (overlap) return true;
        }
        return false;
    }
}