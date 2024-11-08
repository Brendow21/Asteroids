/**
 * Creates Saucer object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class Saucer extends Enemy {
    public static final int HALF_WIDTH = 10;
    public static final int HALF_HEIGHT = 5;
    public static final int SAUCER_SPEED = 2;
    public static final int SAUCER_POINTS = 400;
    public static final double SPAWN_PROB = 0.002;
    public static final double TURN_PROB = 0.05;

    /**
     * Constructor.
     */
    public Saucer() {
        super(SAUCER_SPEED, HALF_WIDTH, SAUCER_POINTS);
    }

    @Override
    public void update() {
        this.pose = this.pose.move(this.velocity);
        if (GameDriver.GENERATOR.nextDouble() < TURN_PROB) {
            this.pose = this.pose.newHeading(GameDriver.GENERATOR.nextDouble() * 360 * Math.PI / 180);
            this.velocity = this.velocity.newHeading(GameDriver.GENERATOR.nextDouble() * 360 * Math.PI / 180);
        }
        if (this.pose.getX() > GameDriver.SCREEN_WIDTH || this.pose.getY() > GameDriver.SCREEN_HEIGHT
                || this.pose.getX() < 0 || this.pose.getY() < 0) {
            this.setDestroyed(true);
        }
    }

    @Override
    public void draw() {
        StdDraw.rectangle(this.pose.getX(), this.pose.getY(), HALF_WIDTH, HALF_HEIGHT);
    }

}
