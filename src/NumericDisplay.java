/**
 * Create NumericDisplay object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class NumericDisplay implements Drawable {
    private String prefix;
    private int value;
    private Point location;

    /**
     * Constructor.
     * 
     * @param xPos x position
     * @param yPos y position
     * @param prefix of display
     * @param value of display
     */
    public NumericDisplay(int xPos, int yPos, String prefix, int value) {
        this.location = new Point(xPos, yPos);
        this.prefix = prefix;
        this.value = value;

    }

    /**
     * Gets Location.
     * 
     * @return location
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Gets Value.
     * 
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets value.
     * 
     * @param value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void draw() {
        StdDraw.textLeft(this.location.getX(), this.location.getY(), prefix + String.valueOf(getValue()));
    }
}
