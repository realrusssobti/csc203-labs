import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PartOneTestCases
{
   public static final double DELTA = 0.001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[][] {new Class[0]});

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testUtilImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "perimeter", "perimeter", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[] {Circle.class},
         new Class[] {Polygon.class},
         new Class[] {Rectangle.class});

      verifyImplSpecifics(Util.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, Point.class.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
   // Test cases for Perimeters
   @Test
   public void testCirclePerimeter()
   {
      Circle circle = new Circle(new Point(0, 0), 1);
      assertEquals(2 * Math.PI, Util.perimeter(circle), DELTA);
   }

   @Test
   public void testRectanglePerimeter()
   {
      Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(1, 1));
      System.out.println(Util.perimeter(rectangle));
      assertEquals(4, Util.perimeter(rectangle), DELTA);
   }

   @Test
   public void testPolygonPerimeter()
   {
      Polygon polygon = new Polygon(Arrays.asList(
         new Point(0, 0), new Point(1, 0), new Point(1, 1)));
      assertEquals(3.414, Util.perimeter(polygon), DELTA);
   }

   // Test cases for getCenter
   @Test
   public void testCircleCenter()
   {
      Circle circle = new Circle(new Point(0, 0), 1);
      // check x
      assertEquals(0, circle.getCenter().getX(), DELTA);
      // check y
      assertEquals(0, circle.getCenter().getY(), DELTA);
      
   }

   // Test cases for getTopLeft
   @Test
   public void testRectangleTopLeft()
   {
      Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(1, 1));
      // check x
      assertEquals(0, rectangle.getTopLeft().getX(), DELTA);
      // check y
      assertEquals(1, rectangle.getTopLeft().getY(), DELTA);

   }
   // Test cases for getBottomRight
   @Test
   public void testRectangleBottomRight()
   {
      Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(1, 1));
      // check x
      assertEquals(1, rectangle.getBottomRight().getX(), DELTA);
      // check y
      assertEquals(0, rectangle.getBottomRight().getY(), DELTA);

   }
   // Test cases for getPoints
   @Test
   public void testPolygonPoints()
   {
      // list of points
      List<Point> points = Arrays.asList(
         new Point(0, 0), new Point(1, 0), new Point(1, 1));
      Polygon polygon = new Polygon(points);
      // check x and y values
      for (int i = 0; i < points.size(); i++)
      {
         assertEquals(points.get(i).getX(), polygon.getPoints().get(i).getX(), DELTA);
         assertEquals(points.get(i).getY(), polygon.getPoints().get(i).getY(), DELTA);
      }
   }

   // Test cases for getRadius
   @Test
   public void testCircleRadius()
   {
      Circle circle = new Circle(new Point(0, 0), 1);
      assertEquals(1, circle.getRadius(), DELTA);
   }


}
