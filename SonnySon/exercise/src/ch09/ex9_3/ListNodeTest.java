package ch09.ex9_3;

public class ListNodeTest {
    public static void main(String[] args) {
        CustomList<String> data = new CustomList<>();

        data.insert("사자");
        data.insert("호랑이");
        data.insert("코끼리");
        data.insert("하마");
        data.insert("얼룩말");

        data.showList();
        data.showReversedList();
    }
}