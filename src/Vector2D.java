/**
 * Class representing a two-dimensional vector. This class provides methods for
 * interacting with a vector as x and y components *or* as a heading (direction)
 * and magnitude (length).
 * 
 * A heading of 0 represents a vector pointing directly to the right, the
 * heading increases as vectors are rotated in a counter-clockwise direction.
 * 
 * @author CS159 Instructors
 * @version 03/31/2021
 */
public class Vector2D {

    private final double xComponent;
    private final double yComponent;

    /**
     * Construct a new vector from the provided heading and magnitude.
     * 
     * A heading of 0 represents a vector pointing directly to the right, the
     * heading increases as vectors are rotated in a counter-clockwise
     * direction.
     * 
     * @param heading Initial heading (in radians)
     * @param magnitude Initial magnitude (length)
     */
    public Vector2D(double heading, double magnitude) {
        if (magnitude < 0) {
            throw new IllegalArgumentException(
                    "Vector magnitude cannot be less than 0.");
        }
        xComponent = Math.cos(heading) * magnitude;
        yComponent = Math.sin(heading) * magnitude;
    }

    /**
     * Returns a newly created Vector2D object created from the provided (x, y)
     * values.
     * 
     * @param xComponent The x component of the vector
     * @param yComponent The y component of the vector
     * @return A new vector with the provided x and y components
     */
    public static Vector2D fromXY(double xComponent, double yComponent) {
        double heading = Math.atan2(yComponent, xComponent);
        double magnitude = Math.sqrt(
                xComponent * xComponent + yComponent * yComponent);
        return new Vector2D(heading, magnitude);
    }

    public double getX() {
        return xComponent;
    }

    public double getY() {
        return yComponent;
    }

    /**
     * Get the length of the vector.
     * 
     * @return The magnitude (length) of this vector
     */
    public double getMagnitude() {
        return Math.sqrt(xComponent * xComponent + yComponent * yComponent);
    }

    /**
     * Vector direction.
     * 
     * @return The heading of this vector in radians
     */
    public double getHeading() {
        return Math.atan2(getY(), getX());
    }

    /**
     * Return a new Vector that is a copy of this vector with provided
     * magnitude. (Since the Vector class is immutable, this provides a
     * convenient alternative to a setter method.)
     * 
     * @param magnitude The magnitude of the new vector
     * @return A new Vector with the provided magnitude.
     */
    public Vector2D newMagnitude(double magnitude) {
        if (magnitude < 0) {
            throw new IllegalArgumentException(
                    "Vector magnitude cannot be less than 0");
        }
        return new Vector2D(getHeading(), magnitude);
    }

    /**
     * Return a new Vector that is a copy of this vector with provided heading.
     * (Since the Vector class is immutable, this provides a convenient
     * alternative to a setter method.)
     * 
     * @param heading The heading of the new vector
     * @return A new Vector with the provided heading.
     */
    public Vector2D newHeading(double heading) {
        return new Vector2D(heading, getMagnitude());
    }

    /**
     * Add the provided vector to this vector and return the result.
     * 
     * @param other Another vector
     * @return The result of adding the two vectors
     */
    public Vector2D add(Vector2D other) {
        return Vector2D.fromXY(xComponent + other.xComponent,
                yComponent + other.yComponent);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2D)) {
            return false;
        }
        Vector2D other = (Vector2D) obj;
        return xComponent == other.xComponent && yComponent == other.yComponent;
    }

    @Override
    public String toString() {
        return "Vector2D[xComponent=" + xComponent + ", yComponent="
                + yComponent + "]";
    }

}
