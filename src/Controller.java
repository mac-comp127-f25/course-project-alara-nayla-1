import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

public class Controller {
    private Man man1;

    public Controller(Man man) {
        this.man1 = man;
    }

    public void keyPressed(KeyboardEvent k) {

        if (k.getKey() == Key.DOWN_ARROW){
            man1.goDown();

        } else if (k.getKey() == Key.UP_ARROW) {
            man1.goUp();

        } else if (k.getKey() == Key.LEFT_ARROW) {
            man1.goLeft();

        } else if (k.getKey() == Key.RIGHT_ARROW) {
            man1.goRight();

        }
    
    }
}