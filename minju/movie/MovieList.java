import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MovieList {
    private List<Movie> list;

    public MovieList() {
        list = new ArrayList<>();
    }

    public void add(Movie value) {
        list.add(value);
        Collections.sort(list);
    }

    public Movie getMovie(String title) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int value = list.get(mid).getTitle().compareTo(title);
            if (value == 0)
                return list.get(mid);
            else if (value > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new IllegalArgumentException("찾는 영화가 없습니다.");
    }
}
