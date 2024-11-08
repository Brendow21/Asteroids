/**
 * Utility methods for working with Poses, Points, and Vectors in Asteroids.
 * 
 * @author CS159 Instructors
 * @version 03/31/2021
 */
public class GameUtils {

    /**
     * Draw an isosceles triangle at the location and heading of the provided
     * Pose. The triangle will be centered at the (x,y) position of the Pose.
     *
     * @param pose location and heading for the triangle
     * @param width the width of the base of the triangle
     * @param height the height of the triangle
     */
    public static void drawPoseAsTriangle(Pose pose, double width,
            double height) {

        Point llPoint = transformPoseToScreen(pose,
                new Point(-.5 * height, -.5 * width));
        Point lrPoint = transformPoseToScreen(pose,
                new Point(-.5 * height, .5 * width));
        Point endPoint = transformPoseToScreen(pose, new Point(.5 * height, 0));

        double[] xs = new double[3];
        double[] ys = new double[3];

        xs[0] = llPoint.getX();
        xs[1] = endPoint.getX();
        xs[2] = lrPoint.getX();
        ys[0] = llPoint.getY();
        ys[1] = endPoint.getY();
        ys[2] = lrPoint.getY();

        StdDraw.polygon(xs, ys);
    }

    /**
     * Transform the coordinate frame defined by a Pose object to screen
     * coordinates.
     * 
     * @param pose the coordinate frame to transform from
     * @param point the point to transform (in pose coordinates)
     * @return the transformed point (in screen coordinates)
     */
    private static Point transformPoseToScreen(Pose pose, Point point) {
        double newX = point.getX() * Math.cos(pose.getHeading())
                - point.getY() * Math.sin(pose.getHeading()) + pose.getX();
        double newY = point.getX() * Math.sin(pose.getHeading())
                + point.getY() * Math.cos(pose.getHeading()) + pose.getY();
        return new Point(newX, newY);
    }

}
