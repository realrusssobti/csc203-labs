import java.time.LocalTime;

class CourseSection {
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
                        final int enrollment, final LocalTime startTime, final LocalTime endTime) {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   // additional likely methods not defined since they are not needed for testing
   /*
   For the CourseSection class, you must implement equals and hashCode in long form (i.e., you must
   program all computations explicitly). Be sure to handle null values.
    */

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (obj.getClass() != this.getClass()) {
         return false;
      }
      CourseSection other = (CourseSection) obj;
      return this.prefix.equals(other.prefix) && this.number.equals(other.number) && this.enrollment == other.enrollment && this.startTime.equals(other.startTime) && this.endTime.equals(other.endTime);
   }
   public int hashCode() {
      // create a string representation of the object
        String str = this.prefix + this.number + this.enrollment + this.startTime + this.endTime;
        // hash this string recursively
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = 69 * hash + str.charAt(i);
        }
        return hash;
   }

}
