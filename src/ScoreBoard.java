import edu.macalester.graphics.GraphicsText;
import java.awt.Color;

public class ScoreBoard {
    private int score;
    private int lives;
    private GraphicsText scoreText;
    private GraphicsText livesText;
    
    public ScoreBoard(double x, double y) {
        this.score = 0;
        this.lives = 3;
        
        scoreText = new GraphicsText("Score: 0", x, y);
        scoreText.setFillColor(Color.WHITE);
        scoreText.setFontSize(24);
        
        livesText = new GraphicsText("Lives: 3", x, y + 30);
        livesText.setFillColor(Color.WHITE);
        livesText.setFontSize(24);
    }
    
    public void addPoints(int points) {
        score += points;
        updateScoreDisplay();
    }
    
    public void loseLife() {
        lives--;
        updateLivesDisplay();
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLives() {
        return lives;
    }
    
    private void updateScoreDisplay() {
        scoreText.setText("Score: " + score);
    }
    
    private void updateLivesDisplay() {
        livesText.setText("Lives: " + lives);
    }
    
    public GraphicsText getScoreText() {
        return scoreText;
    }
    
    public GraphicsText getLivesText() {
        return livesText;
    }
}
