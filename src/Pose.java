/**
 * A Pose is a Point with an associated heading.
 * 
 * @author CS159 Instructors
 * @version 03/31/2021
 */
public class Pose extends Point {

    private final double heading;

    /**
     * Construct a Pose.
     * 
     * @param xPosition position on the X-axis
     * @param yPosition position on the Y-axis
     * @param heading the heading (in radians)
     */
    public Pose(double xPosition, double yPosition, double heading) {
        super(xPosition, yPosition);
        this.heading = heading;
    }

    public double getHeading() {
        return heading;
    }

    /**
     * Return a new Pose that is a copy of this pose with provided x-coordinate.
     * (Since the Pose class is immutable, this provides a convenient
     * alternative to a setter method.)
     * 
     * @param newX The x-coordinate for the new pose
     * @return A new pose with the indicated x-coordinate
     */
    public Pose newX(double newX) {
        return new Pose(newX, yPosition, heading);
    }

    /**
     * Return a new Pose that is a copy of this pose with provided y-coordinate.
     * (Since the Pose class is immutable, this provides a convenient
     * alternative to a setter method.)
     * 
     * @param newY The y-coordinate for the new pose
     * @return A new pose with the indicated y-coordinate
     */
    public Pose newY(double newY) {
        return new Pose(xPosition, newY, heading);
    }

    /**
     * Return a new Pose that is a copy of this pose with provided heading.
     * (Since the Pose class is immutable, this provides a convenient
     * alternative to a setter method.)
     * 
     * @param newHeading The heading for the new pose
     * @return A new pose with the indicated y-coordinate
     */
    public Pose newHeading(double newHeading) {
        return new Pose(xPosition, yPosition, newHeading);
    }

    /**
     * Move the pose according the the provided vector.
     * 
     * @param vector The motion vector (probably encoding a velocity)
     * @return The pose at the new location.
     */
    public Pose move(Vector2D vector) {
        return new Pose(getX() + vector.getX(), getY() + vector.getY(),
                heading);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pose)) {
            return false;
        }
        Pose other = (Pose) obj;
        return xPosition == other.xPosition && yPosition == other.yPosition
                && heading == other.heading;
    }

    @Override
    public String toString() {
        return "Pose[xPosition=" + xPosition + ", yPosition=" + yPosition
                + ", heading=" + heading + "]";
    }

}
