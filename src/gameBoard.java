import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public class gameBoard {
    private CanvasWindow canvas;
    public Line walls;
    public GraphicsObject cookies;

    public gameBoard() {
        canvas = new CanvasWindow("PacMan but better", 900, 900);

        Rectangle border = new Rectangle(20, 10, 860, 830);
        border.setStrokeWidth(10);
        border.setFillColor(Color.BLACK);
        border.setStrokeColor(Color.BLUE);
        canvas.add(border);
        canvas.add(walls);
        canvas.add(cookies);
    }

    public static void main(String[] args){
        new gameBoard();
    }
}

