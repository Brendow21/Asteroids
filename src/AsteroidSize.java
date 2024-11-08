/**
 * Creates AsteroidSize enum.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public enum AsteroidSize {
    SMALL(10, 200), MEDIUM(20, 100), LARGE(30, 50);

    private int radius;
    private int points;

    /**
     * Constructor.
     * 
     * @param radius of asteroid
     * @param points of asteriod
     */
    AsteroidSize(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }

    /**
     * Gets radius.
     * 
     * @return radius
     */
    int getRadius() {
        return this.radius;
    }

    /**
     * Gets points.
     * 
     * @return points
     */
    int getPoints() {
        return this.points;
    }

    /**
     * Randomly generates size of asteroid.
     * 
     * @return size of asteroid
     */
    static AsteroidSize randomSize() {
        double temp = (Math.random());
        if (temp <= .25) {
            return SMALL;
        } else if (temp > .25 && temp <= .5) {
            return MEDIUM;
        } 
        return LARGE;
    }
}
