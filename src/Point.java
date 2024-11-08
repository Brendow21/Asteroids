/**
 * Encapsulation of a two-dimensional point.
 * 
 * @author CS159 Instructors
 * @version 03/31/2021
 */
public class Point {

    protected final double xPosition;
    protected final double yPosition;

    /**
     * Construct a point object.
     * 
     * @param xPosition position on the X-axis
     * @param yPosition position on the Y-axis
     */
    public Point(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getX() {
        return xPosition;
    }

    public double getY() {
        return yPosition;
    }

    /**
     * Return a new Point that is a copy of this point with provided
     * x-coordinate and the same y-coordinate as this point. (Since the Point
     * class is immutable, this provides a convenient alternative to a setter
     * method.)
     * 
     * @param newX The x-coordinate for the new point
     * @return A new point with the indicated x-coordinate
     */
    public Point newX(double newX) {
        return new Point(newX, yPosition);
    }

    /**
     * Return a new Point that is a copy of this point with provided
     * y-coordinate and the same x-coordinate as this point. (Since the Point
     * class is immutable, this provides a convenient alternative to a setter
     * method.)
     * 
     * @param newY The y-coordinate for the new point
     * @return A new point with the indicated y-coordinate
     */
    public Point newY(double newY) {
        return new Point(xPosition, newY);
    }

    /**
     * Move the point according the the provided vector.
     * 
     * @param vector The motion vector (probably encoding a velocity)
     * @return a new Point object that has been moved according to the provided
     *     vector
     */
    public Point move(Vector2D vector) {
        return new Point(getX() + vector.getX(), getY() + vector.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return xPosition == other.xPosition && yPosition == other.yPosition;
    }

    @Override
    public String toString() {
        return "Point[xPosition=" + xPosition + ", yPosition=" + yPosition
                + "]";
    }

}
