import java.util.List;
public class Polygon {
    private List<Point> points;
    public Polygon(List<Point> points) {
        this.points = points;
    }
    public List<Point> getPoints() {
        return points;
    }
    public double perimeter() {
        double perimeter = 0;
        List<Point> points = this.points;
        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += points.get(i).distance(points.get(i + 1));
        }
        perimeter += points.get(points.size() - 1).distance(points.get(0));
        return perimeter;
    }
}