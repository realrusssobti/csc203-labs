public class Point {
    private final double x;
    private final double y;
//    "getX",
//         "getY",
//         "getRadius",
//         "getAngle",
//         "rotate90"

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return Math.sqrt(x*x + y*y);
    }
    public double getAngle() {
        return Math.atan2(y, x);
    }
    public Point rotate90() {
        // Rotate a point 90 degrees counter-clockwise
        return new Point(-y, x);
    }


}
