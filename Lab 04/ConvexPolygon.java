// Define a Java class ConvexPolygon that implements the Shape interface. A ConvexPolygon 
// have a java Point array (not ArrayList) indicating its vertices and a Color. Assume the 
// Points in the Point array will always be given in counter-clockwise order. In addition to 
// implementing the required methods specified by the Shape interface you must also implement 
// the following methods. (Again, note that the input parameters for each method, if any, are 
// intentionally not shown):  
// o ConvexPolygon() - A constructor with parameters to initialize all its instance variables. 
// Do not implement a default constructor. 
// o Point getVertex() - Takes an index and returns the specified vertex of the 
// ConvexPolygon. 
import java.awt.Color;
import java.awt.Point;

public class ConvexPolygon implements Shape {
    // "getColor", "setColor", "getArea", "getPerimeter", "translate",
    //      "getVertex"
    private Point[] vertices;
    private Color color;
    public ConvexPolygon(Point[] vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }
    public Point getVertex(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index >= vertices.length) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return vertices[index];
        
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getArea() {
        double area = 0;
        for (int i = 0; i < vertices.length; i++) {
            int j = (i + 1) % vertices.length;
            area += vertices[i].x * vertices[j].y;
            area -= vertices[i].y * vertices[j].x;
        }
        area /= 2;
        return Math.abs(area);
    }
    public double getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.length; i++) {
            int j = (i + 1) % vertices.length;
            perimeter += Math.sqrt(Math.pow(vertices[j].x - vertices[i].x, 2) + Math.pow(vertices[j].y - vertices[i].y, 2));
        }
        return perimeter;
    }
    public void translate(Point p) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].x += p.x;
            vertices[i].y += p.y;
        }
        return;
    }
    
    
}
