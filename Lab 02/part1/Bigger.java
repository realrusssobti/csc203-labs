public class Bigger {
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p) {
        double circlePerimeter = c.perimeter();
        double rectanglePerimeter = r.perimeter();
        double polygonPerimeter = p.perimeter();
        double max = Math.max(circlePerimeter, rectanglePerimeter);
        return Math.max(max, polygonPerimeter);
    }
        
    }

