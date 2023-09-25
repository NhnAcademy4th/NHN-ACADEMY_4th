package com.nhnacademy.Chapter7;

import static com.nhnacademy.Chapter7.ex7_1.randomInt;
import static com.nhnacademy.Chapter7.resource.Inputshell.setIntValue;
import static com.nhnacademy.Chapter7.resource.TimedComputation.*;

import java.util.Arrays;
import org.apache.commons.lang3.RandomStringUtils;

public class ex7_3 {

    private static void sortTester(int[] test){
        int[] duplicateTest = Arrays.copyOf(test, test.length);

        selectionSortTimer(duplicateTest);
        sortTimer(test);
    }

    private static void sortTester(String[] test){
        String[] duplicateTest = Arrays.copyOf(test, test.length);

        selectionSortTimer(duplicateTest);
        sortTimer(test);

    }


    private static void codeActivater(){
        int endNumber = setIntValue("Enter end number >>");
        int MAX = setIntValue("Enter Max number >>");

        int[] IntTest = new int[endNumber];
        String[] strTest = new String[endNumber];

        loopPerformer(endNumber, IntTest, MAX);
        loopPerformer(endNumber, strTest, MAX);

        sortTester(IntTest);
        sortTester(strTest);
    }

    private static void loopPerformer(int endNumber, String[] test, int MAX) {
        for(int i = 0; i < endNumber; i++){
            test[i] = randomStr(MAX);
        }
    }

    private static String randomStr(int max) {
        String randomString = RandomStringUtils.randomAlphabetic(randomInt(max));

        return randomString;
    }

    private static void loopPerformer(int endNumber, int[] test, int MAX) {
        for(int i = 0; i < endNumber; i++){
            test[i] = randomInt(MAX);
        }
    }

    public static void main(String[] args) {
        codeActivater();
    }
}
