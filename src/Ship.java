
/**
 * Creates Ship object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class Ship extends GameElement {
    public static final int SHIP_WIDTH = 10;
    public static final int SHIP_HEIGHT = 20;
    public static final double SHIP_TURN = 0.1;
    public static final double SHIP_MOVE = 0.1;
    public static final double FRICTION = 0.02;

    /**
     * Constructor.
     */
    public Ship() {
        super(new Pose(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2), new Vector2D(0, 0),
                SHIP_WIDTH);
    }

    /**
     * Turns ship left.
     */
    public void turnLeft() {
        this.pose = pose.newHeading(this.pose.getHeading() + SHIP_TURN);
    }

    /**
     * Turns ship right.
     */
    public void turnRight() {
        this.pose = pose.newHeading(this.pose.getHeading() - SHIP_TURN);

    }

    /**
     * Thrusts ship forward.
     */
    public void thrust() {
        Vector2D test = new Vector2D(this.pose.getHeading(), SHIP_MOVE);
        this.velocity = this.velocity.add(test);

    }

    @Override
    public void update() {
        super.update();
        if (this.getVelocity().getMagnitude() > Ship.FRICTION) {
            this.velocity = this.velocity.newMagnitude(this.velocity.getMagnitude() - Ship.FRICTION);
        } else if (this.getVelocity().getMagnitude() > 0) {
            this.velocity = this.velocity.newMagnitude(this.velocity.getMagnitude() - this.velocity.getMagnitude());
        }
    }

    @Override
    public void draw() {
        GameUtils.drawPoseAsTriangle(this.pose, SHIP_WIDTH, SHIP_HEIGHT);
    }
}
