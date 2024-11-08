import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit Tests for Ship class.
 * 
 * @author Brendan Hom
 * @version 4/3/23
 *
 */
public class ShipTest {
    private Ship s;

    @BeforeEach
    public void setup() {
        s = new Ship();
    }

    @Test
    public void testExtendsGameElement() {
        assertTrue(s instanceof GameElement);
    }

    @Test
    public void testConstructor() {
        TestHelpers.comparePoints(new Point(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2), s.getPose());
    }

    @Test
    public void testTurnLeft() {
        s.turnLeft();
        s.update();
        assertEquals(Math.PI / 2 + Ship.SHIP_TURN, s.getPose().getHeading());
    }

    @Test
    public void testTurnRight() {
        s.turnRight();
        s.update();
        assertEquals(Math.PI / 2 - Ship.SHIP_TURN, s.getPose().getHeading());
    }

    @Test
    public void testThrust() {
        s.thrust();
        s.update();
        TestHelpers.comparePoints(new Point(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2 + Ship.SHIP_MOVE),
                s.getPose());
    }

    @Test
    public void testDraw() {
        s.draw();
        assertEquals("polygon()", StdDraw.getLastDraw());
    }

    @Test
    public void testUpdate() {
        s.update();
        Vector2D test = new Vector2D(s.getVelocity().getHeading(), Ship.SHIP_MOVE - Ship.FRICTION);
        s.thrust();
        s.update();
        assertEquals(test.getMagnitude(), s.getVelocity().getMagnitude());
        for (int i = 0; i < 4; i ++) {
            s.update();
        }
        assertEquals(0, s.getVelocity().getMagnitude());
    }
}
