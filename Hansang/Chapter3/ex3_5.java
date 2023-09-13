package Chapter3;
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
            //예외사항이 발생할 가능성이 있음
            //가능하면 textIO 사용하지 말기바람...
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
