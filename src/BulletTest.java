import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Bullet Junit Test
 * 
 * @author Brendan Hom
 * @version 4/5/23
 *
 */
public class BulletTest {
    private Ship s;
    private Bullet b;

    @BeforeEach
    public void setup() {
        s = new Ship();
        b = new Bullet(s.getPose());
    }

    @Test
    public void testExtendsGameElement() {
        assertTrue(b instanceof GameElement);
    }

    @Test
    public void testUpdate() {
        b.update();
        assertEquals(new Vector2D(b.pose.getHeading(), Bullet.BULLET_SPEED), b.getVelocity());
        for (int i = 0; i < 20; i++) {
            b.update();
        }
        assertTrue(b.isDestroyed());
    }

    @Test
    public void testDraw() {
        b.draw();
        assertEquals("filledCircle(240.0, 240.0, 1.5)", StdDraw.getLastDraw());
    }
}
