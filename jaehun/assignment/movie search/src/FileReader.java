import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private Scanner reader;

    public FileReader(String filePath) throws FileNotFoundException{
        reader = new Scanner(new File(filePath));
    }

    public List<String> getFile() {
        List<String> lines = new ArrayList<>();
        reader.nextLine();
        while (reader.hasNext()) {
            StringBuilder line = new StringBuilder(reader.nextLine());
            if (line.substring(line.length() - 3, line.length()).equals("...")) {
                line.append(reader.nextLine());
            }
            lines.add(line.toString());
        }
        reader.close();
        return lines;
    }
}
