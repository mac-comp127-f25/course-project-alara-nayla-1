import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private CanvasWindow canvas;
    private Walls walls;
    private Cookies cookies;
    private Man man;
    // private Ghost ghost;
    private Controller controller;

    private List<Ghost> ghosts = new ArrayList<>();

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
        Ghost ghost1 = new Ghost(450, 450, walls, this);
        Ghost ghost2 = new Ghost(400, 450, walls, this);
        ghosts.add(ghost1);
        ghosts.add(ghost2);

        canvas.add(man.getShape());
        canvas.add(ghost1.getShape());
        canvas.add(ghost2.getShape());

        canvas.animate(() -> {
            for (Ghost g : ghosts) {
                g.update();
            }
        });

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
