import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases2
{
   public static final double DELTA = 0.00001;

   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetX()
   {
      assertEquals(1.0, new Point(1.0, 2.0).getX(), DELTA);
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */

   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getX",
         "getY",
         "getRadius",
         "getAngle",
         "rotate90"
         );

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class,
         double.class,
         double.class,
         double.class,
         Point.class
         );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0]
         );

      verifyImplSpecifics(Point.class, expectedMethodNames,
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

      // verify that fields are final

      final List<String> nonFinalFields = Arrays.stream(
         clazz.getDeclaredFields())
            .filter(f -> !Modifier.isFinal(f.getModifiers()))
            .map(f -> f.getName())
            .collect(Collectors.toList());
      assertEquals("Unexpected non-final fields", 0, nonFinalFields.size());
   }
   // test creating a point
   @Test
   public void testPoint1()
   {
      Point p = new Point(1.0, 2.0);
      assertEquals(1.0, p.getX(), DELTA);
      assertEquals(2.0, p.getY(), DELTA);
   }
   // test getY
   @Test
   public void testGetY()
   {
      Point p = new Point(1.0, 2.0);
      assertEquals(2.0, p.getY(), DELTA);
   }
   // test getRadius
   @Test
   public void testGetRadius()
   {
      Point p = new Point(1.0, 2.0);
      assertEquals(Math.sqrt(5), p.getRadius(), DELTA);
   }
   // test getAngle
   @Test
   public void testGetAngle()
   {
      Point p = new Point(1.0, 2.0);
      assertEquals(Math.atan2(2.0, 1.0), p.getAngle(), DELTA);
   }
   // test rotate90
   @Test
   public void testRotate90()
   {
      Point p = new Point(1.0, 2.0);
      Point q = p.rotate90();
      assertEquals(-2.0, q.getX(), DELTA);
      assertEquals(1.0, q.getY(), DELTA);
   }
   
   
}
