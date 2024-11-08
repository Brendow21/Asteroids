/**
 * Creates abstract GameElement class.
 * 
 * @author brenh
 * @version 4/3/23
 *
 */
public abstract class GameElement implements Drawable, Updatable {
    protected Pose pose;
    protected Vector2D velocity;
    protected double radius;
    protected boolean destroyed;

    /**
     * Constructor.
     * 
     * @param pose position
     * @param velocity velocity
     * @param radius radius
     */
    public GameElement(Pose pose, Vector2D velocity, double radius) {
        this.pose = pose;
        this.velocity = velocity;
        this.radius = radius;
    }

    /**
     * Gets Pose.
     * 
     * @return pose
     */
    public Pose getPose() {
        return this.pose;
    }

    /**
     * Gets Velocity.
     * 
     * @return velocity
     */
    public Vector2D getVelocity() {
        return this.velocity;
    }

    /**
     * Gets Radius.
     * 
     * @return radius
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Gets whether object is destroyed.
     * 
     * @return True if objects is destroyed False otherwise
     */
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /**
     * Sets object destroyed to true or false.
     * 
     * @param destroyed True/False
     */
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    /**
     * Checks if object collides with another GameElement object.
     * 
     * @param other GameElement
     * @return True if collides False otherwise
     */
    public boolean checkCollision(GameElement other) {
        double xDif = this.pose.getX() - other.pose.getX();
        double yDif = this.pose.getY() - other.pose.getY();
        double total = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));

        return total < (this.radius + other.radius);
    }

    @Override
    public void update() {
        if (!isDestroyed()) {
            this.pose = this.pose.move(this.velocity);
            if (this.pose.getX() > GameDriver.SCREEN_WIDTH) {
                this.pose = this.pose.newX(0);
            } else if (this.pose.getX() < 0) {
                this.pose = this.pose.newX(GameDriver.SCREEN_WIDTH);
            }
            if (this.pose.getY() > GameDriver.SCREEN_HEIGHT) {
                this.pose = this.pose.newY(0);
            } else if (this.pose.getY() < 0) {
                this.pose = this.pose.newY(GameDriver.SCREEN_HEIGHT);
            }
        }
    }

}
