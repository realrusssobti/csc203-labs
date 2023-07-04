public class Lab00 {
   public static void main(String[] args) {
      // declaring and initializing some variables
      int x = 5;
      String y = "hello";
      double z = 9.8;
      // printing the variables
      System.out.println("x: " + x + " y: " + y + " z: " + z);
      // A list
      int[] nums = new int[] { 3, 6, -1, 2 };
      for (int i = 0; i < nums.length; i++) {
         System.out.println(nums[i]);
      }
      // Call a function
      int numFound = charCount('l', y);
      System.out.println("Found: " + numFound);

      // counting for loop
      for (int i = 0; i < 11; i++) {
         System.out.print(i + " ");
      }
   }

   public static int charCount(char c, String s) {
      int count = 0;
      char[] charArray = s.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
         if (c == charArray[i]) {
            count++;
         }
      }
      return count;
   }
}
