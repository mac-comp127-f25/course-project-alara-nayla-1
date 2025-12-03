import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

// public class GameBoard {
//     private CanvasWindow canvas;
//     public Line walls;
    

//     public GameBoard() {
//         canvas = new CanvasWindow("PacMan but better", 900, 900);

//         Rectangle border = new Rectangle(20, 10, 860, 830);
//         border.setStrokeWidth(10);
//         border.setFillColor(Color.BLACK);
//         border.setStrokeColor(Color.BLUE);
//         canvas.add(border);
//         canvas.add(walls);
//     }

//     public static void main(String[] args){
//         new GameBoard();
//     }
// }

public class GameBoard {
    private CanvasWindow canvas;
    private Walls walls;

    public GameBoard() {
        canvas = new CanvasWindow("PacMan But Better", 900, 900);
        
        Rectangle border = new Rectangle(20, 10, 860, 830);
        border.setStrokeWidth(10);
        border.setFillColor(Color.BLACK);
        border.setStrokeColor(Color.BLUE);
        canvas.add(border);
        
        walls = new Walls(canvas);
    }

    public static void main(String[] args) {
        new GameBoard();
    }
}
