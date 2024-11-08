/**
 * Creates Bullet object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class Bullet extends GameElement {
    public static final double BULLET_RADIUS = 1.5;
    public static final int BULLET_SPEED = 20;
    public static final int BULLET_DURATION = 20;
    private int counter;

    /**
     * Constructor.
     * 
     * @param pose Position.
     */
    public Bullet(Pose pose) {
        super(pose, new Vector2D(pose.getHeading(), BULLET_SPEED), BULLET_RADIUS);
        this.counter = 0;
    }

    @Override
    public void update() {
        super.update();
        this.counter++;
        this.velocity = this.velocity.newMagnitude(BULLET_SPEED);
        if (this.counter == BULLET_DURATION) {
            this.setDestroyed(true);
        }
    }

    @Override
    public void draw() {
        StdDraw.filledCircle(this.pose.getX(), this.pose.getY(), BULLET_RADIUS);
    }
}
