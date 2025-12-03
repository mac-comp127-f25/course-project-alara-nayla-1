import java.awt.Color;


// public class Walls {

// public Walls() {
//     Line wall = new Line(60, 100, 30, 100);
//     wall.setStrokeColor(Color.BLUE);
// }
// }

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Walls {
    
    public Walls(CanvasWindow canvas) {
        createWalls(canvas);
    }
    
    private void createWalls(CanvasWindow canvas) {
        // Top left section
        addWall(canvas, 70, 60, 150, 40);
        addWall(canvas, 250, 60, 100, 40);
        addWall(canvas, 70, 170, 80, 50);
        addWall(canvas, 180, 170, 170, 50);
        
        // Top center section
        addWall(canvas, 390, 60, 120, 200);
        
        // Top right section
        addWall(canvas, 550, 60, 100, 40);
        addWall(canvas, 680, 60, 150, 40);
        addWall(canvas, 680, 170, 150, 40);
        addWall(canvas, 550, 170, 100, 40);
        
        // Left side mid section
        addWall(canvas, 70, 280, 80, 40);
        addWall(canvas, 180, 280, 80, 130);
        
        // Center ghost house
        addWall(canvas, 290, 280, 80, 40);
        addWall(canvas, 290, 390, 80, 45);
        addWall(canvas, 530, 280, 80, 40);
        addWall(canvas, 530, 390, 80, 45);
        addWall(canvas, 380, 510, 140, 40);
        
        // Right side mid section
        addWall(canvas, 640, 280, 80, 130);
        addWall(canvas, 750, 280, 80, 40);
        
        // Bottom left section
        addWall(canvas, 70, 510, 80, 40);
        addWall(canvas, 70, 620, 150, 40);
        addWall(canvas, 250, 620, 100, 40);
        addWall(canvas, 180, 730, 170, 40);
        
        // Bottom center
        addWall(canvas, 380, 620, 140, 80);
        
        // Bottom right section
        addWall(canvas, 750, 510, 80, 40);
        addWall(canvas, 680, 620, 150, 40);
        addWall(canvas, 550, 620, 100, 40);
        addWall(canvas, 550, 730, 170, 40);
    }
    
    private void addWall(CanvasWindow canvas, double x, double y, double width, double height) {
        Rectangle wall = new Rectangle(x, y, width, height);
        wall.setFillColor(Color.BLUE);
        wall.setStrokeColor(Color.BLUE);
        wall.setStrokeWidth(1);
        canvas.add(wall);
    }
}