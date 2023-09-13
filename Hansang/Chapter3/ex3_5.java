package Chapter3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import textio.TextIO;

public class ex3_5 {
    public static void main(String[] args) {
        TextIO.readFile("./src/main/java/Chapter3/sales.dat");

        double totalSales = 0;
        int noDatacount =0;
        int c =1;
        while(!TextIO.eof()) {
            String[] tempstr = TextIO.getln().split(": ");

            if(!Objects.equals(tempstr[c], "no report received")){
                totalSales+= Double.parseDouble(tempstr[c]);
            }else{
                noDatacount++;
            }
        }


        System.out.printf("total sales is : %1.2f", totalSales);
        System.out.println();
        System.out.println(noDatacount + " city need more data" );


    }
}
