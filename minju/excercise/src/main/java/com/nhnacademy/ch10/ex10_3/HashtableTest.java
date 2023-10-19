package com.nhnacademy.ch10.ex10_3;

public class HashtableTest {

    private static final String[] TEST_KEYS = {"1", "2", "3", "3"};
    private static final String[] TEST_VALUES = {"apple", "grape", "grape", "kiwi"};

    public static void main(String[] args) {
        test(20);
    }

    private static void test(int testSize) {
        StringHashtable table = new StringHashtable(testSize);

        System.out.println("Test put() : ");
        for (int i = 0; i < TEST_KEYS.length; i++) {
            try {
                table.put(TEST_KEYS[i], TEST_VALUES[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        System.out.println("Test get() : ");
        for (String key : TEST_KEYS) {
            System.out.print(key + " " + table.get(key) + " ");
        }
        System.out.println();
        try {
            table.get("test");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Test Remove() : ");
        for (String key : TEST_KEYS) {
            try {
                table.remove(key);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Remaining Size : " + table.size());
    }
}
