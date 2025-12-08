import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public class GameBoard {
    private CanvasWindow canvas;
    private Walls walls;
    private Cookies cookies;
    private Man man;
    private Ghost ghost;
    private Controller controller;

    public GameBoard() {
        canvas = new CanvasWindow("PacMan But Better", 900, 900);
        
        Rectangle border = new Rectangle(20, 10, 860, 830);
        border.setStrokeWidth(10);
        border.setFillColor(Color.BLACK);
        border.setStrokeColor(Color.BLUE);
        canvas.add(border);
        
        walls = new Walls(canvas);
        cookies = new Cookies(canvas, walls);
        man = new Man(450, 450);
        ghost = new Ghost(450, 450);
        canvas.add(man.getShape());
        controller = new Controller(man, walls, this);

        canvas.onKeyDown(event -> {
            controller.keyPressed(event);
        });
    }
    public int getWidth() {
        return canvas.getWidth();
    }
    public int getHeight() {
        return canvas.getHeight();
    }

    public Cookies getCookies() {
        return cookies;
    }
    public static void main(String[] args) {
        new GameBoard();
    }
}
