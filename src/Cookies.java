import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Rectangle;

/**
 * Cookies is the grid path that Cookie Man follows to avoid collision with borders and maze walls.
 */
public class Cookies {
    private List<Cookie> cookies = new ArrayList<>();
    private Walls walls;
    private CanvasWindow canvas;

    public Cookies(CanvasWindow canvas, Walls walls) {
        this.canvas = canvas;
        this.walls = walls;
        createCookies(canvas);
    }

    private void createCookies(CanvasWindow canvas) {
        double space = 38;

        for (double x = 40; x < GameBoard.GAME_WIDTH - 40; x += space) {
            for (double y = 40; y < GameBoard.GAME_HEIGHT - 80; y += space) {
                if(collidesWithWall(x, y)) continue;
                addCookie(canvas, x, y);
            }
        }
    }

    private boolean collidesWithWall(double x, double y) {
        double radius = 7;
        for (Rectangle wall : walls.getWalls()) {
            double left = x - radius; 
            double right = x + radius;
            double top = y - radius;
            double bottom = y + radius;
            double wallLeft = wall.getX();
            double wallRight = wall.getX() + wall.getWidth();
            double wallTop = wall.getY();
            double wallBottom = wall.getY() + wall.getHeight();
            boolean overlap = right > wallLeft && left < wallRight && bottom > wallTop && top < wallBottom;
            if (overlap) return true;
        }
        return false;
    }

    private void addCookie(CanvasWindow canvas, double x, double y) {
        Cookie cookie = new Cookie(x, y);
        cookies.add(cookie);
        canvas.add(cookie.getShape());
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public int eatCookies(Man man) {
        double manLeft = man.getShape().getX();
        double manRight = manLeft + man.getShape().getWidth();
        double manTop = man.getShape().getY();
        double manBottom = manTop + man.getShape().getHeight();
        int pointsEarned = 0;
        Iterator<Cookie> iterator = cookies.iterator();
        
        while(iterator.hasNext()) {
        Cookie cookie = iterator.next();
        Ellipse shape = cookie.getShape();
        double cookieLeft = shape.getX();
        double cookieRight = cookieLeft + shape.getWidth();
        double cookieTop = shape.getY();
        double cookieBottom = cookieTop + shape.getHeight();
        boolean overlap = manRight > cookieLeft && manLeft < cookieRight && manBottom > cookieTop && manTop < cookieBottom;
            if (overlap) {
                canvas.remove(shape);
                iterator.remove();
                pointsEarned += 10;
            }
        }
        return pointsEarned;
    }
}
