// Define a Java class WorkSpace to hold Shape objects. The WorkSpace class shold have one 
// private instance variable of type List<Shape> to hold Shape objects. You may choose which 
// kind of List you use. The WorkSpace class should have the following public methods. (Note 
// that this time the parameters are specified!):  
// o WorkSpace() - A default constructor to initialize its instance variable to an empty List. 
// The constructor should not take any parameters. (If you do nothing in this constructor, 
// you may omit it from your code altogether.) 
// o void add(Shape shape) - Adds an object which implements the Shape interface to 
// the end of the List in the WorkSpace. 
// o Shape get(int index) - Returns the specified Shape from the WorkSpace. 
// o int size() - Returns the number of Shapes contained by the WorkSpace. 
// o List<Circle> getCircles() - Returns a List of all the Circle objects contained 
// by the WorkSpace. 
// o List<Rectangle> getRectangles() - Returns a List of all the Rectangle 
// objects contained by the WorkSpace. 
// o List<Triangle> getTriangles() - Returns a List of all the Triangle objects 
// contained by the WorkSpace. 
// o List<ConvexPolygon> getConvexPolygons() - Returns a List of all the 
// ConvexPolygon objects contained by the WorkSpace. 
// o List<Shape> getShapesByColor(Color color) - Returns a List of all the 
// Shape objects contained by the WorkSpace that match the specified Color. 
// o double getAreaOfAllShapes() - Returns the sum of the areas of all the Shapes 
// contained by the WorkSpace. 
// o double getPerimeterOfAllShapes() - Returns the sum of the perimeters of all the 
// Shapes contained by the WorkSpace.
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
public class WorkSpace {
    private List<Shape> shapes;
    public WorkSpace() {
        shapes = new ArrayList<Shape>();
    }
    public void add(Shape shape) {
        shapes.add(shape);
    }
    public Shape get( int index) {
        try {
            if (index < 0 || index >= shapes.size()) {
                throw new Exception("Index out of bounds");

            }
            return shapes.get(index);

        } catch (Exception e) {
            // TODO: handle exception
            return new Circle(420, new Point(69, 69), Color.BLACK) {
                @Override
                public double getArea() {
                    return 0;
                }
                @Override
                public double getPerimeter() {
                    return 0;
                }
                @Override
                public void translate(Point p) {
                }
                @Override
                public String toString() {
                    return "Error";
                }
            };
            }
        }

    public List<Circle> getCircles() {
        List<Circle> circles = new ArrayList<Circle>();
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                circles.add((Circle) shape);
            }
        }
        return circles;
    }
    
    public List<Rectangle> getRectangles() {
        List<Rectangle> rectangles = new ArrayList<Rectangle>();
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                rectangles.add((Rectangle) shape);
            }
        }
        return rectangles;
    }

    public List<Triangle> getTriangles() {
        List<Triangle> triangles = new ArrayList<Triangle>();
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                triangles.add((Triangle) shape);
            }
        }
        return triangles;
    }
    public List<ConvexPolygon> getConvexPolygons() {
        List<ConvexPolygon> convexPolygons = new ArrayList<ConvexPolygon>();
        for (Shape shape : shapes) {
            if (shape instanceof ConvexPolygon) {
                convexPolygons.add((ConvexPolygon) shape);
            }
        }
        return convexPolygons;
    }
    public List<Shape> getShapesByColor(Color color) {
        List<Shape> shapesByColor = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (shape.getColor().equals(color)) {
                shapesByColor.add(shape);
            }
        }
        return shapesByColor;
    }

    public double getAreaOfAllShapes() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        return area;
    }
    public double getPerimeterOfAllShapes() {
        double perimeter = 0;
        for (Shape shape : shapes) {
            perimeter += shape.getPerimeter();
        }
        return perimeter;
    }
    
}
