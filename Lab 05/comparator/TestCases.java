import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      ArtistComparator artistComparator = new ArtistComparator();
       // compare the list using the artistComparator
         // the result should be less than 0
        int result = artistComparator.compare(songs[5], songs[6]);
        // check if the result is less than 0
        assertTrue(result < 0);

   }

   @Test
   public void testLambdaTitleComparator()
   {
      // use a lambda expression to create a TitleComparator
        Comparator<Song> titleComparator = (Song s1, Song s2) -> s1.getTitle().compareTo(s2.getTitle());
        // compare the list using the titleComparator
        // the result should be greater than 0
        int result = titleComparator.compare(songs[0], songs[1]);
        // check if the result is greater than 0
        assertTrue(result > 0);

   }

   @Test
   public void testYearExtractorComparator()
   {
      // use a lambda expression to create a YearComparator
        Comparator<Song> yearComparator = (Song s1, Song s2) -> s1.getYear() - s2.getYear();
        // compare the list using the yearComparator
        // the result should be 0
        int result = yearComparator.compare(songs[0], songs[1]);
        // check if the result is 0
        assertEquals(0, result);
   }

   @Test
   public void testComposedComparator()
   {
      // test the ComposedComparator class
      ArtistComparator c1 = new ArtistComparator();
      Comparator<Song> c2 = (Song s1, Song s2) -> s1.getYear() - s2.getYear();
      ComposedComparator myComposedComparator = new ComposedComparator(c1, c2);
      // Now, check if it works
        int result = myComposedComparator.compare(songs[3], songs[7]);
        // check the result
        assertTrue(result > 0);
   }

   @Test
   public void testThenComparing()
   {
      // use thenComparing() instead of ComposedComparator
        Comparator<Song> c1 = (Song s1, Song s2) -> s1.getArtist().compareTo(s2.getArtist());
        Comparator<Song> c2 = (Song s1, Song s2) -> s1.getYear() - s2.getYear();
        Comparator<Song> myComparator = c1.thenComparing(c2);
        // Now, check if it works
        int result = myComparator.compare(songs[3], songs[7]);
        // check the result
        assertTrue(result > 0);

   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      Comparator<Song> Artist = (Song s1, Song s2) -> s1.getArtist().compareTo(s2.getArtist());
      Comparator<Song> Year = (Song s1, Song s2) -> s1.getYear() - s2.getYear();
      Comparator<Song> Title = (Song s1, Song s2) -> s1.getTitle().compareTo(s2.getTitle());
      Comparator<Song> myComparator = Artist.thenComparing(Title).thenComparing(Year);
      songList.sort(
            myComparator
      );

      assertEquals(songList, expectedList);
   }
}
