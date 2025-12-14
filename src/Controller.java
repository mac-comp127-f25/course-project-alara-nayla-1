import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

// Controller sets the system of control for Cookie Man with the arrow keys and specific constraints for movement.

public class Controller {
    private Man man;
    private Walls walls;
    private GameBoard board;
    private Boost boost;
    private long boostEndTime = 0;

    public Controller(Man man, Walls walls, GameBoard board) {
        this.man = man;
        this.walls = walls;
        this.board = board;
        this.boost = board.getBoost();
    }

    public void keyPressed(KeyboardEvent k) {
        Image shape = man.getShape();
        double newLeft = shape.getX();
        double newTop = shape.getY();
        double speed = man.getSpeed();
        
        if (k.getKey() == Key.DOWN_ARROW) {
            newTop += speed;
            if (!collidesWithWall(newLeft, newTop)) man.goDown();
        } else if (k.getKey() == Key.UP_ARROW) {
            newTop -= speed;
            if (!collidesWithWall(newLeft, newTop)) man.goUp();
        } else if (k.getKey() == Key.LEFT_ARROW) {
            newLeft -= speed;
            if (!collidesWithWall(newLeft, newTop)) man.goLeft();
        } else if (k.getKey() == Key.RIGHT_ARROW) {
            newLeft += speed;
            if (!collidesWithWall(newLeft, newTop)) man.goRight();
        }
        
        int points = board.getCookies().eatCookies(man);
        board.addScore(points);
        checkBoostCollision();
        updateBoostTimer();
    }

    private boolean collidesWithWall(double newX, double newY) {
        Image shape = man.getShape();
        double w = shape.getWidth();
        double h = shape.getHeight();

        double left = newX;
        double right = newX + w;
        double top = newY;
        double bottom = newY + h;

        double borderLeft = GameBoard.BORDER_LEFT;
        double borderRight = GameBoard.BORDER_LEFT + GameBoard.BORDER_WIDTH;
        double borderTop = GameBoard.BORDER_TOP;
        double borderBottom = GameBoard.BORDER_TOP + GameBoard.BORDER_HEIGHT;
    

        if (left < borderLeft || top < borderTop ||
            right > borderRight || bottom > borderBottom) {
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
    
    private void checkBoostCollision() {
        if (!boost.isActive()) return;

        double manLeft = man.getShape().getX();
        double manRight = manLeft + man.getShape().getWidth();
        double manTop = man.getShape().getY();
        double manBottom = manTop + man.getShape().getHeight();

        Ellipse b = boost.getShape();
        double bLeft = b.getX();
        double bRight = bLeft + b.getWidth();
        double bTop = b.getY();
        double bBottom = bTop + b.getHeight();

        boolean overlap =
            manRight > bLeft && manLeft < bRight &&
            manBottom > bTop && manTop < bBottom;

        if (overlap) {
            boost.deactive();
            board.getCanvas().remove(b);

            man.doubleSpeed();
            boostEndTime = System.currentTimeMillis() + 10000;
        }
    }

    private void updateBoostTimer() {
        if(boostEndTime > 0 && System.currentTimeMillis() > boostEndTime) {
            man.resetSpeed();
            boostEndTime = 0;
    }
    
}
}