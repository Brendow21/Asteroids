import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class TestStar {
    private Star s;

    @BeforeEach
    public void setup() {
        s = new Star(10, 15);
    }

    @Test
    public void testImplementsInterface() {
        assertTrue(s instanceof Drawable);
    }

    @Test
    public void testConstants() {
        assertEquals(1, Star.STAR_RADIUS);
    }

    @Test
    public void testConstructor() {
        TestHelpers.comparePoints(new Point(10, 15), s.getLocation());
    }

    @Test
    public void testDraw() {
        s.draw();

        String actual = StdDraw.getLastDraw();
        assertTrue("filledCircle(10.0, 15.0, 1.0)".equals(actual) || "circle(10.0, 15.0, 1.0)".equals(actual));
    }
}
