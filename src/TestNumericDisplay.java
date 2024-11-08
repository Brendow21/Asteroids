import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNumericDisplay {
    private NumericDisplay nd;
    
    @BeforeEach
    public void setup() {
        nd = new NumericDisplay(50, 60, "capybara", 2000);
    }
    
    @Test
    public void testImplementsInterface() {
        assertTrue(nd instanceof Drawable);
    }
    
    @Test
    public void testConstructor() {
        TestHelpers.comparePoints(new Point(50, 60), nd.getLocation());
        assertEquals(2000, nd.getValue());
    }
    
    @Test
    public void testSetValue() {
        nd.setValue(1001);
        assertEquals(1001, nd.getValue());
    }
    
    @Test
    public void testDraw() {
        nd.draw();
        assertEquals("textLeft(50.0, 60.0, capybara2000)", StdDraw.getLastDraw());
    }
}
