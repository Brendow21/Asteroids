import java.awt.Color;
import java.util.ArrayList;

/**
 * Main class for Asteroids.
 * 
 * @author CS159 Instructors
 * @version s23
 */
public class AsteroidsGame implements Playable {

    public static final int LIVES = 3;
    private ArrayList<Drawable> drawElements;
    private ArrayList<Updatable> updateElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;
    private Ship ship;
    private NumericDisplay score;
    private NumericDisplay lives;

    /**
     * Constructs all game elements.
     */
    public AsteroidsGame() {
        StdDraw.setTitle("Generic Space Rock Shooter");

        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        // add background elements
        final int TOP = GameDriver.SCREEN_HEIGHT;
        score = new NumericDisplay(40, TOP - 20, "Score: ", 0);
        lives = new NumericDisplay(40, TOP - 40, "Lives: ", LIVES);
        drawElements.add(score);
        drawElements.add(lives);

        newShip();
    }

    /**
     * Adds enemy to game.
     * 
     * @param enemy to add
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        updateElements.add(enemy);
        drawElements.add(enemy);
    }

    /**
     * Creates and adds 100 stars with random locations.
     */
    private void newStars() {
        for (int i = 0; i < 100; i++) {
            this.drawElements.add(new Star(randomXPosition(), randomYPosition()));
        }
    }

    /**
     * Creates new 10 new enemies.
     */
    private void newEnemies() {
        for (int i = 0; i < 10; i++) {
            addEnemy(new Asteroid(AsteroidSize.randomSize()));
        }
    }

    /**
     * Creates new ship.
     */
    private void newShip() {
        this.ship = new Ship();
        shipAndBullets.add(this.ship);
        updateElements.add(this.ship);
        drawElements.add(this.ship);
    }

    /**
     * Starts a new game with 10 asteroids.
     */
    public void startGame() {
        newStars();
        newEnemies();
    }

    /**
     * Handle keyboard input from the game and move the ship and shoot bullets if the corresponding keys are pressed.
     */
    private void handleKeyboardInput() {
        if (GameDriver.spacePressed()) {
            Bullet bullet = new Bullet(ship.getPose());
            shipAndBullets.add(bullet);
            updateElements.add(bullet);
            drawElements.add(bullet);
        }

        if (GameDriver.leftPressed()) {
            ship.turnLeft();
        }

        if (GameDriver.rightPressed()) {
            ship.turnRight();
        }

        if (GameDriver.upPressed()) {
            ship.thrust();
        }
    }

    @Override
    public void update() {
        // freeze simulation if game is over
        if (lives.getValue() <= 0) {
            return;
        }

        // update everything (including newest bullet)
        handleKeyboardInput();
        for (Updatable item : updateElements) {
            item.update();
        }
        handleCollisions();
        removeDestroyedBullets();
        removeDestroyedEnemies();

        if (enemies.size() == 0) {
            newEnemies();
        }

        if (GameDriver.GENERATOR.nextDouble() < Saucer.SPAWN_PROB) {
            Saucer saucer = new Saucer();
            enemies.add(saucer);
            updateElements.add(saucer);
            drawElements.add(saucer);
        }
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(Color.white);
        score.draw();
        lives.draw();
        for (Drawable drawable : drawElements) {
            drawable.draw();
        }
    }

    /**
     * Handles collisions between the ship, bullets, and enemies. If a bullet collides with an asteroid an asteroid, it
     * is set to destroyed, if it collides with a saucer, it is set to destroyed and the score is increased by the
     * saucer point value. If the ship collides with an enemy, the ship and enemy are both set to destroyed, the score
     * is increased by the enemy point value, and the number of lives is reduced by 1 if it is greater than 0.
     */
    private void handleCollisions() {
        for (int e = enemies.size() - 1; e >= 0; e--) {
            for (int s = shipAndBullets.size() - 1; s >= 0; s--) {
                if (shipAndBullets.get(s).checkCollision(enemies.get(e))) {
                    if (shipAndBullets.get(s) instanceof Bullet) {
                        shipAndBullets.get(s).setDestroyed(true);
                        enemies.get(e).setDestroyed(true);
                        if (enemies.get(e) instanceof Saucer) {
                            score.setValue(score.getValue() + enemies.get(e).getPoints());
                        }
                    } else if (shipAndBullets.get(s).checkCollision(enemies.get(e))
                            && shipAndBullets.get(s) instanceof Ship) {
                        enemies.get(e).setDestroyed(true);
                        shipAndBullets.get(s).setDestroyed(true);
                        shipAndBullets.remove(ship);
                        updateElements.remove(ship);
                        drawElements.remove(ship);
                        lives.setValue(lives.getValue() - 1);
                        if (lives.getValue() > 0) {
                            newShip();
                        }
                    }
                }
            }
        }
    }

    /**
     * Removes Destroyed Bullets. If a bullet is set to destroyed, it is removed from shipAndBullets, drawElements, and
     * updateElements.
     */
    public void removeDestroyedBullets() {
        for (int i = 0; i < shipAndBullets.size(); i++) {
            if (shipAndBullets.get(i) instanceof Bullet) {
                Bullet b = (Bullet) shipAndBullets.get(i);
                if (b.isDestroyed()) {
                    shipAndBullets.remove(b);
                    drawElements.remove(b);
                    updateElements.remove(b);
                }
            }
        }
    }

    /**
     * Removes Destroyed enemies. If an enemy is set to destroyed, it is removed from enemies, drawElements, and
     * updateElements. If the enemy is an asteroid, the score is increased by the point value of the asteroid.
     */
    public void removeDestroyedEnemies() {
        for (int e = 0; e < enemies.size(); e++) {
            if (enemies.get(e).isDestroyed()) {
                Enemy n = (Enemy) enemies.get(e);
                if (n instanceof Asteroid) {
                    score.setValue(score.getValue() + enemies.get(e).getPoints());
                }
                enemies.remove(n);
                drawElements.remove(n);
                updateElements.remove(n);
            }
        }
    }

    /**
     * Generates a random X position on the screen.
     * 
     * @return the x position
     */
    protected static double randomXPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH;
    }

    /**
     * Generates a random Y position on the screen.
     * 
     * @return the y position
     */
    protected static double randomYPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT;
    }

    /**
     * Generates a random heading from the interval [0, 2*PI).
     * 
     * @return the heading
     */
    protected static double randomHeading() {
        return GameDriver.GENERATOR.nextDouble() * 2 * Math.PI;
    }

}