import edu.macalester.graphics.CanvasWindow;
import java.awt.Color;

public class gameBoard {
    private CanvasWindow canvas;

    public gameBoard() {
        canvas = new CanvasWindow("PacMan but better", 900, 900);
    }

    public static void main(String[] args){
        new gameBoard();
    }
}

