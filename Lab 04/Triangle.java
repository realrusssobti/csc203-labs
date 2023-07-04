// Define a Java class Triangle that implements the Shape interface. Triangles have three Points 
// indicating its vertices and a Color. To simplify your solution, the vertices will always be given in 
// counter-clockwise order. However, there are calculations for the area of a Triangle that will work 
// with the vertices in any order. In addition to implementing the required methods specified by the 
// Shape interface you must also implement the following methods. (Again, note that the input 
// parameters for each method, if any, are intentionally not shown):  
// o Triangle() - A constructor with parameters to initialize all its instance variables. Do not 
// implement a default constructor. The first Point passed to the constructor will be vertex 
// A, the second Point vertex B, and so on. 
// o Point getVertexA() - Returns the Point representing vertex A of the Triangle. 
// o Point getVertexB() - Returns the Point representing vertex B of the Triangle. 
// o Point getVertexC() - Returns the Point representing vertex C of the Triangle. 
import java.awt.Color;
import java.awt.Point;
public class Triangle implements Shape {
    //"getColor", "setColor", "getArea", "getPerimeter", "translate",
    // "getVertexA", "getVertexB", "getVertexC"
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private Color color;
    public Triangle(Point vertexA, Point vertexB, Point vertexC, Color color) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.color = color;
    }
    public Point getVertexA() {
        return vertexA;
    }
    public Point getVertexB() {
        return vertexB;
    }
    public Point getVertexC() {
        return vertexC;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void translate(Point p) {
        // Add the x and y values of the point to the x and y values of each vertex.
        vertexA.x += p.x;
        vertexA.y += p.y;
        vertexB.x += p.x;
        vertexB.y += p.y;
        vertexC.x += p.x;
        vertexC.y += p.y;
        return;
    }
    public double getArea() {
        // This is the determinant method for finding the area of a triangle. 
        double area = 0.5 * Math.abs(vertexA.x * (vertexB.y - vertexC.y) + vertexB.x * (vertexC.y - vertexA.y) + vertexC.x * (vertexA.y - vertexB.y));
        return area;
    }
    public double getPerimeter() {
        // Use the distance formula to find side lengths, then add them up. 
        double sideA = Math.sqrt(Math.pow(vertexB.x - vertexA.x, 2) + Math.pow(vertexB.y - vertexA.y, 2));
        double sideB = Math.sqrt(Math.pow(vertexC.x - vertexB.x, 2) + Math.pow(vertexC.y - vertexB.y, 2));
        double sideC = Math.sqrt(Math.pow(vertexA.x - vertexC.x, 2) + Math.pow(vertexA.y - vertexC.y, 2));
        double perimeter = sideA + sideB + sideC;
        return perimeter;
    }



}
