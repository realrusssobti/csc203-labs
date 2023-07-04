// Define a Java class Circle that implements the Shape interface. Circles have a radius, a 
// center, and a Color. In addition to implementing the required methods specified by the Shape 
// interface you must also implement the following methods. (Again, note that the input parameters 
// for each method, if any, are intentionally not shown):  
// o Circle() - A constructor with parameters to initialize all its instance variables. Do not 
// implement a default constructor. 
// o double getRadius() - Returns the radius of the Circle. 
// o void setRadius() - Sets the radius of the Circle 
// o Point getCenter() - Returns the center of the Circle 
import java.awt.Color;
import java.awt.Point;
public class Circle implements Shape{
    // "getColor", "setColor", "getArea", "getPerimeter", "translate",
    //      "getRadius", "setRadius", "getCenter"
    private double radius;
    private Point center;
    private Color color;
    
    public Circle(double radius, Point center, Color color) {
        this.radius = radius;
        this.center = center;
        this.color = color;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public Point getCenter() {
        return center;
    }
    
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public void translate(Point p) {
        center.x += p.x;
        center.y += p.y;
    }
   
    
}
