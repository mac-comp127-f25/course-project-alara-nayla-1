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
        double space = 20;

        for (double x = 40; x <860; x += space) {
            for (double y = 40; y < 820; y += space) {
                if(collidesWithWall(x, y)) continue;
                addCookie(canvas, x, y);
                }
        }
    }
    private boolean collidesWithWall(double x, double y) {
        for (Rectangle wall : walls.getWalls()) {
            if (wall.containsPoint(x, y)) {
                return true;
            }
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
