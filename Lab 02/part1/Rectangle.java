public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    public Rectangle(Point a, Point b) {
        // find the top left and bottom right points
        topLeft = new Point(Math.min(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
        bottomRight = new Point(Math.max(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));
    }
    public Point getTopLeft() {
        return topLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }
    public double perimeter() {
        double width = bottomRight.getX() - topLeft.getX();
        double height = topLeft.getY() - bottomRight.getY();
        return 2 * (width + height);
    }
}
