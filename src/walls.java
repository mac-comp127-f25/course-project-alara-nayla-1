import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Walls {
    private List<Rectangle> wallList = new ArrayList<>();
    
    public Walls(CanvasWindow canvas) {
        createWalls(canvas);
    }

    public List<Rectangle> getWalls() { 
        return wallList;
    }
    
    private void createWalls(CanvasWindow canvas) {
        // Top left section
        addWall(canvas, 70, 60, 130, 40);
        addWall(canvas, 250, 60, 80, 40);
        addWall(canvas, 70, 170, 60, 50);
        addWall(canvas, 180, 170, 150, 50);
        
        // Top center section
        addWall(canvas, 390, 60, 120, 150);
        
        // Top right section
        addWall(canvas, 580, 60, 70, 40);
        addWall(canvas, 700, 60, 90, 40);
        addWall(canvas, 700, 170, 90, 40);
        addWall(canvas, 580, 170, 70, 40);
        
        // Left side mid section
        addWall(canvas, 70, 280, 60, 40);
        addWall(canvas, 180, 280, 60, 130);
        
        // Center ghost house
        addWall(canvas, 290, 280, 80, 40);
        addWall(canvas, 290, 390, 80, 45);
        addWall(canvas, 530, 280, 60, 40);
        addWall(canvas, 530, 390, 60, 45);
        addWall(canvas, 380, 510, 140, 40);
        
        // Right side mid section
        addWall(canvas, 640, 280, 60, 130);
        addWall(canvas, 750, 280, 60, 40);
        
        // Bottom left section
        addWall(canvas, 70, 510, 50, 40);
        addWall(canvas, 70, 620, 130, 40);
        addWall(canvas, 250, 620, 80, 40);
        addWall(canvas, 180, 730, 130, 40);
        
        // Bottom center
        addWall(canvas, 380, 620, 120, 80);
        
        // Bottom right section
        addWall(canvas, 750, 510, 50, 40);
        addWall(canvas, 680, 620, 130, 40);
        addWall(canvas, 550, 620, 80, 40);
        addWall(canvas, 550, 730, 130, 40);
    }
    
    // Adds the blue borders
    private void addWall(CanvasWindow canvas, double x, double y, double width, double height) {
        Rectangle wall = new Rectangle(x, y, width, height);
        wall.setFillColor(Color.BLUE);
        wall.setStrokeColor(Color.BLUE);
        wall.setStrokeWidth(1);
        canvas.add(wall);
        wallList.add(wall);
    }
}