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

    public List<Movie> getMovie(String title) {
        List<Movie> result = new ArrayList<>();
        for (int i = bisection(title); i < list.size(); i++) {
            if (!list.get(i).getTitle().equals(title))
                break;
            result.add(list.get(i));
        }
        if (result.isEmpty()) {
            throw new IllegalArgumentException("찾는 영화가 없습니다.");
        }
        return result;
    }

    public int bisection(String title) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            int value = list.get(mid).getTitle().compareTo(title);
            if (value >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
