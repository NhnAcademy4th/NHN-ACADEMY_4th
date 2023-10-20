package com.nhnacademy.ch07.ex07_3;

import java.util.Arrays;

// TODO:Type safety 고민해보기
// ? 1. 배열을 List로 변경해서 Type safety하게 하기
// ? 2. 배열을 받아서 Sorting 내부에서 list로 복사
// ?    - 문제 조건인 Arrays.sort() 시간을 올바르게 출력할 수 있는가?

public class Sorting<T extends Comparable<T>> {

    public double arraySortTime(T[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public double selectionSortTime(T[] array) {
        long startTime = System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public void selectionSort(T[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            T tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

}
