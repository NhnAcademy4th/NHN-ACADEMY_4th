package course2.chapter7.ex7_1;

public class Main {
    public static void main(String[] args) {
        ArrayListGenerator generator = new ArrayListGenerator();
        int count = 3;
        int maxValue = 10;
        //try catch를 여기서 쓰는 것이 맞을까?
        //그렇다면 이것을 ArrayListGenerator에서 쓰는게 맞을까?
        try {
            generator.generate(count, maxValue);
            System.out.println(generator.getArrayList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
