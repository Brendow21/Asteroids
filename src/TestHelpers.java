import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHelpers {
    private static final double EPSILON = 0.01;
    
    public static boolean closeEnough(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }
    
    public static void comparePoses(Pose a, Pose b) {
        comparePoints(a, b);
        assertEquals(a.getHeading(), b.getHeading(), EPSILON, "Pose.heading");
    }
    
    public static void comparePoints(Point a, Point b) {
        assertEquals(a.getX(), b.getX(), EPSILON, "Point.xPosition");
        assertEquals(a.getY(), b.getY(), EPSILON, "Point.yPosition");
    }
    
    public static void compareVectors(Vector2D a, Vector2D b) {
        assertEquals(a.getX(), b.getX(), EPSILON, "Vector2D.xComponent");
        assertEquals(a.getY(), b.getY(), EPSILON, "Vector2D.yComponent");
    }
}
