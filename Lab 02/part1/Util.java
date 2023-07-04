import java.util.List;

public class Util {
    /**
     * @param circle
     * @return perimeter
     */
    public static double perimeter(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }
    /**
     * @param polygon
     * @return perimeter
     */
    public static double perimeter(Polygon polygon) {
        double perimeter = 0;
        List<Point> points = polygon.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += points.get(i).distance(points.get(i + 1));
        }
        perimeter += points.get(points.size() - 1).distance(points.get(0));
        return perimeter;
    }
    /**
     * @param rectangle
     * @return perimeter
     */
    public static double perimeter(Rectangle rectangle) {
        double width = rectangle.getBottomRight().getX() - rectangle.getTopLeft().getX();
        double height = rectangle.getTopLeft().getY() - rectangle.getBottomRight().getY();
        return 2 * (width + height);
    }
}