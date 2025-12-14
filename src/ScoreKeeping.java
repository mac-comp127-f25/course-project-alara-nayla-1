
/**
 * Keeps track of the player's score and the lives left.
 */

public class ScoreKeeping {
    private int score;
    private int lives;
    
    public ScoreKeeping(double x, double y) {
        this.score = 0;
        this.lives = 3;
    }
    
    public void addPoints(int points) {
        score += points;
    }
    
    public void loseLife() {
        lives--;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLives() {
        return lives;
    }
}
