/**
 * Creates a Star object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class Star implements Drawable {

    public static final int STAR_RADIUS = 1;
    private Point location;

    /**
     * Constructor.
     * 
     * @param x coordinate
     * @param y coordinate
     */
    public Star(double x, double y) {
        this.location = new Point(x, y);
    }

    /**
     * Gets Location.
     * 
     * @return location
     */
    public Point getLocation() {
        return this.location;
    }

    @Override
    public void draw() {
        StdDraw.filledCircle(this.location.getX(), this.location.getY(), STAR_RADIUS);
    }
}
