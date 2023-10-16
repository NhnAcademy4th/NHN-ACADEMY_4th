package ex10_1;

/**
 * ex10_1
 */
public class ex10_1 {

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.addPhone("김철수", "010-1234-3456");
        directory.addPhone("김동구", "12312341234");

        System.out.println(directory.find("김철수"));
        try {
            directory.addPhone(null, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            directory.addPhone("김민수", "ㄹㄷㅇㄴㅁㄹㄷㅁ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}