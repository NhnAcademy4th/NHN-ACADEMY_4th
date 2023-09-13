import textio.TextIO;

public class ex3_5 {
    public static void main(String[] args) {

        try {
            TextIO.readFile("sales.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            System.exit(1);
        }

        int pass = 0;
        double totalSale = 0;

        while (!(TextIO.eof())) {
            char character;
            do {
                character = TextIO.getChar();
            } while (character != ':');

            try {
                double sale = Double.valueOf(TextIO.getln());
                totalSale += sale;
            } catch (Exception e) {
                pass++;
            }

        }
        System.out.println(totalSale);

    }
}