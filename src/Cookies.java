import java.util.List;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Cookies {
    private List<Cookie> cookies = new ArrayList<>();
    private Walls walls;

    public Cookies(CanvasWindow canvas, Walls walls) {
        this.walls = walls;
        createCookies(canvas);
    }
    private void createCookies(CanvasWindow canvas) {
        double space = 38;

        for (double x = 40; x <860; x += space) {
            for (double y = 40; y < 820; y += space) {
                if(collidesWithWall(x, y)) continue;
                addCookie(canvas, x, y);
                }
        }
    }
    private boolean collidesWithWall(double x, double y) {
        double radius = 9;
        for (Rectangle wall : walls.getWalls()) {
            double left = x - radius; 
            double right = x + radius;
            double top = y - radius;
            double bottom = y + radius;

            double wallLeft = wall.getX();
            double wallRight = wall.getX() + wall.getWidth();
            double wallTop = wall.getY();
            double wallBottom = wall.getY() + wall.getHeight();

            boolean overlap = right > wallLeft && left < wallRight && 
                bottom > wallTop && top < wallBottom;
            
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
}
