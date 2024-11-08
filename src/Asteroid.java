/**
 * Creates Asteroid enemy object.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class Asteroid extends Enemy {
    public static final int ASTEROID_SPEED = 1;

    /**
     * Constructor.
     * 
     * @param size of asteroid
     */
    public Asteroid(AsteroidSize size) {
        super(ASTEROID_SPEED, size.getRadius(), size.getPoints());
    }

    @Override
    public void draw() {
        StdDraw.circle(this.getPose().getX(), this.getPose().getY(), this.getRadius());
    }

}
