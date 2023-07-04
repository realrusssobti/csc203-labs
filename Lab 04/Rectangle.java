// Define a Java class Rectangle that implements the Shape interface. Rectangles have a width, 
// a height, a Point indicating the topLeftCorner, and a Color. In addition to implementing the 
// required methods specified by the Shape interface you must also implement the following 
// methods. (Again, note that the input parameters for each method, if any, are intentionally not 
// shown):  
// o Rectangle() - A constructor with parameters to initialize all its instance variables. Do 
// not implement a default constructor. 
// o double getWidth() - Returns the width of the Rectangle. 
// o void setWidth() - Sets the width of the Rectangle 
// o double getHeight() - Returns the height of the Rectangle. 
// o void setHeight() - Sets the height of the Rectangle 
// o Point getTopLeft() - Returns the Point representing the top left corner of the 
// Rectangle 
import java.awt.Color;
import java.awt.Point;
public class Rectangle implements Shape{
    // "getColor", "setColor", "getArea", "getPerimeter", "translate",
    //      "getWidth", "setWidth", "getHeight", "setHeight", "getTopLeft"
    private double width;
    private double height;
    private Point topLeft;
    private Color color;
    public Rectangle(double width, double height, Point topLeft, Color color) {
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public void translate(Point p) {
        topLeft.x += p.x;
        topLeft.y += p.y;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public Point getTopLeft() {
        return topLeft;
    }
    
}
