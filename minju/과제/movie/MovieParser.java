import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * parsingCSV
 */
public class MovieParser {

    private MovieParser() {
    }

    public static MovieList load(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            String line = br.readLine();
            line = br.readLine();
            MovieList list = new MovieList();
            while (!Objects.isNull(line)) {
                if (line.substring(line.length() - 3).equals("...")) {
                    line += br.readLine().split("                    See full summary&nbsp;&raquo;")[1];
                }
                List<String> information = parse(line);
                if (information.size() != 15) {
                    throw new IllegalArgumentException("데이터의 개수는 15개이어야 합니다.");
                }
                list.add(new Movie(information));
                line = br.readLine();
            }
            return list;
        }
    }

    public static List<String> parse(String line) {
        String[] tokens = line.split(",");
        List<String> information = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token);
            if (sb.toString().matches("^(?:\".*?\"|(?!\"|.*\"$).*)")) {
                information.add(preprocessing(sb.toString()));
                sb.setLength(0);
            }
        }
        return information;
    }

    public static String preprocessing(String line) {
        String result = line;
        if (result.isEmpty())
            return result;
        if (line.charAt(0) == '\"' && line.charAt(line.length() - 1) == '\"') {
            result = line.substring(1, line.length() - 1);
        }
        if (result.equals("NULL")) {
            return "";
        }
        return result;
    }

}