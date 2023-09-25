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
                information.add(sb.toString());
                sb.setLength(0);
            }
        }
        return information;
    }

}