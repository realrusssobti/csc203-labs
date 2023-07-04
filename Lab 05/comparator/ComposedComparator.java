import java.util.Comparator;

public class ComposedComparator implements Comparator<Song> {
    private Comparator<Song> c1;
    private Comparator<Song> c2;

    public ComposedComparator(Comparator<Song> c1, Comparator<Song> c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public int compare(Song s1, Song s2) {
        int result = c1.compare(s1, s2);
        if (result == 0) {
            result = c2.compare(s1, s2);
        }
        return result;
    }
}
