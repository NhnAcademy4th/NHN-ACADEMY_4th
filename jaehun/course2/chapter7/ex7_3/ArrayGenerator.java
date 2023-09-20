package course2.chapter7.ex7_3;

public class ArrayGenerator {

    static int maxIntArrayLength = 10000;
    static int maxIntValue = 100;
    static int maxStringArrayLength = 10000;
    static int maxStringLength = 30;

    public static int[] generateIntArray() {
        int randomLength = generateRandomNumber(maxIntArrayLength);
        int[] array = new int[randomLength];
        for (int i = 0; i < randomLength; i++) {
            array[i] = generateRandomNumber(maxIntValue);
        }
        return array;
    }

    public static String[] generateStringArray() {
        int randomLength = generateRandomNumber(maxStringArrayLength);
        String[] array = new String[randomLength];
        for (int i = 0; i < randomLength; i++) {
            array[i] = generateRandomString();
        }
        return array;
    }

    private static String generateRandomString() {
        String randomString = "";
        int randomLength = generateRandomNumber(maxStringLength);
        for (int i = 0; i < randomLength; i++) {
            char randomAlphabet = (char) generateRandomNumber(97, 122);
            randomString += randomAlphabet;
        }
        return randomString;
    }

    private static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue)) + minValue;
    }

    private static int generateRandomNumber(int maxValue) {
        return (int) (Math.random() * (maxValue)) + 1;
    }
}
