import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private CanvasWindow canvas;
    private Walls walls;
    private Cookies cookies;
    private Man man;
    private Controller controller;
    private List<Ghost> ghosts = new ArrayList<>();
    private ScoreKeeping scoreKeeping;
    private boolean gameOver = false;
    private boolean invincible = false;
    private final double startingX = 450;
    private final double startingY = 450;


    public GameBoard() {
        canvas = new CanvasWindow("Cookie Man", 900, 900);
        Rectangle border = new Rectangle(20, 10, 860, 830);

        border.setStrokeWidth(10);
        border.setFillColor(Color.BLACK);
        border.setStrokeColor(Color.BLUE);
        canvas.add(border);

        walls = new Walls(canvas);
        cookies = new Cookies(canvas, walls);
        man = new Man(startingX, startingY);

        scoreKeeping = new ScoreKeeping(30, 870);

        Ghost ghost1 = new Ghost(150, 400, walls, this);
        Ghost ghost2 = new Ghost(750, 400, walls, this);
        ghosts.add(ghost1);
        ghosts.add(ghost2);

        canvas.add(man.getShape());
        canvas.add(ghost1.getShape());
        canvas.add(ghost2.getShape());

        canvas.animate(() -> {
            if (!gameOver) {
                for (Ghost g : ghosts) {
                g.update();
                }
                checkGhostCollision();
            }
        });

        controller = new Controller(man, walls, this);

        canvas.onKeyDown(event -> {
            if (!gameOver) {
                controller.keyPressed(event);
            }
        });
    }

    private void checkGhostCollision() {
        if (invincible) return;
        double manLeft = man.getShape().getX();
        double manRight = manLeft + man.getShape().getWidth();
        double manTop = man.getShape().getY();
        double manBottom = manTop + man.getShape().getHeight();
        
        for (Ghost ghost : ghosts) {
            double ghostLeft = ghost.getShape().getX();
            double ghostRight = ghostLeft + ghost.getShape().getWidth();
            double ghostTop = ghost.getShape().getY();
            double ghostBottom = ghostTop + ghost.getShape().getHeight();
            
            boolean overlap = manRight > ghostLeft && manLeft < ghostRight &&
                manBottom > ghostTop && manTop < ghostBottom;
            
            if (overlap) {
                handleGhostHit();
                return;
            }
        }
    }
    
    private void handleGhostHit() {
        scoreKeeping.loseLife();
        invincible = true;
        
        if (scoreKeeping.getLives() <= 0) {
            endGame(false);
        } else {
            man.resetPosition(startingX, startingY);
            canvas.pause(1000);
            invincible = false;
        }
    }
    
    public void addScore(int points) {
        if (gameOver) return;
        
        scoreKeeping.addPoints(points);
        
        if (scoreKeeping.getScore() >= 3200) {
            endGame(true);
        }
    }
    
    private void endGame(boolean won) {
        gameOver = true;

        Rectangle messageBg = new Rectangle(0, 0, 700, 80);
        messageBg.setFillColor(Color.GRAY);
        messageBg.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.add(messageBg);
        
        GraphicsText message = new GraphicsText();
        if (won) {
            message.setText("YOU WIN! Score: " + scoreKeeping.getScore());
        } else {
            message.setText("GAME OVER! Final Score: " + scoreKeeping.getScore());
        }
        message.setFillColor(Color.YELLOW);
        message.setFontSize(36);
        message.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.add(message);
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
