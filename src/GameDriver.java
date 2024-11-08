import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Driver for game applications.
 * 
 * @author CS159 Instructors
 * @version s23
 */
public class GameDriver {

    public static final Color SCREEN_COLOR = new Color(0, 0, 0);
    public static final int DRAW_DELAY = 10; // in milliseconds
    public static final int SCREEN_WIDTH = 480;
    public static final int SCREEN_HEIGHT = 480;

    // Game objects should use this random number generator rather than using
    // different generators across multiple classes. This approach facilitates
    // reproducible testing by setting an initial seed for this generator.
    public static final Random GENERATOR = new Random(0);

    /**
     * Create a game object and a display screen, and execute the main update and draw loop.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // initialize the game screen
        StdDraw.setCanvasSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        StdDraw.setXscale(0, SCREEN_WIDTH);
        StdDraw.setYscale(0, SCREEN_HEIGHT);
        StdDraw.enableDoubleBuffering();

        // create a game object
        // Playable game = new BounceGame();
        Playable game = new AsteroidsGame();
        game.startGame();

        // main game loop
        while (true) {
            StdDraw.clear(SCREEN_COLOR);
            game.update();
            game.draw();
            StdDraw.show();
            StdDraw.pause(DRAW_DELAY);
        }

    }

    public static boolean spacePressed() {
        return StdDraw.hasNextKeyTyped() && StdDraw.nextKeyTyped() == ' ';
    }

    public static boolean leftPressed() {
        return StdDraw.isKeyPressed(KeyEvent.VK_LEFT);
    }

    public static boolean rightPressed() {
        return StdDraw.isKeyPressed(KeyEvent.VK_RIGHT);
    }

    public static boolean upPressed() {
        return StdDraw.isKeyPressed(KeyEvent.VK_UP);
    }
}
