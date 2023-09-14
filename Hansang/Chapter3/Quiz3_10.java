package Chapter3;

public class Quiz3_10 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        int result;

        try{
            result = Integer.valueOf(s1) + Integer.valueOf(s2);
        }catch (Exception e){
            throw new NumberFormatException("Can not change String to Integer!");
        }

    }
}
