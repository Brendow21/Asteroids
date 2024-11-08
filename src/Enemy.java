/**
 * Creates Abstract enemy class.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public abstract class Enemy extends GameElement {
    protected int points;

    /**
     * Constructor.
     * 
     * @param speed of enemy
     * @param radius of enemy
     * @param points of enemy
     */
    public Enemy(double speed, double radius, int points) {
        super(new Pose(AsteroidsGame.randomXPosition(), AsteroidsGame.randomYPosition(), AsteroidsGame.randomHeading()),
                new Vector2D(AsteroidsGame.randomHeading(), speed), radius);
        this.points = points;
    }
    
    /**
     * Gets points.
     * 
     * @return points
     */
    public int getPoints() {
        return this.points;
    }
}
