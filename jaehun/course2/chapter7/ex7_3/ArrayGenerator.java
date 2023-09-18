package course2.chapter7.ex7_3;

public class ArrayGenerator {

    int maxIntArrayLength = 10000;
    int maxIntValue = 100;
    int maxStringArrayLength = 10000;

    int maxStringLength = 30;

    public int[] generateIntArray() {
        int randomLength = generateRandomNumber(maxIntArrayLength);
        int[] array = new int[randomLength];
        for (int i = 0; i < randomLength; i++) {
            array[i] = generateRandomNumber(maxIntValue);
        }
        return array;
    }

    public String[] generateStringArray() {
        int randomLength = generateRandomNumber(maxStringArrayLength);
        String[] array = new String[randomLength];
        for (int i = 0; i < randomLength; i++) {
            array[i] = generateRandomString();
        }
        return array;
    }

    public String generateRandomString() {
        String randomString = "";
        int randomLength = generateRandomNumber(maxStringLength);
        for (int i = 0; i < randomLength; i++) {
            char randomAlphabet = (char) generateRandomNumber(97, 122);
            randomString += randomAlphabet;
        }
        return randomString;
    }

    public int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue)) + minValue;
    }

    public int generateRandomNumber(int maxValue) {
        return (int) (Math.random() * (maxValue)) + 1;
    }
}
