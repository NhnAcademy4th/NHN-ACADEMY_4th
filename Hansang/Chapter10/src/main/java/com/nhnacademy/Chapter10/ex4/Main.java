package com.nhnacademy.Chapter10.ex4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int randomInt = (int) (Math.random() * 100) + 1;
            set.add(randomInt);
        }
        Collection<Integer> collections1 = new HashSet<>(set);
        Collection<Integer> collections2 = new HashSet<>(set);
        Collection<Integer> collections3 = new HashSet<>(set);
        Collection<Integer> collections4 = new HashSet<>(set);


        List<Integer> result;
        Predicate<Integer> predicate = (object) -> (object % 2 == 0);

        CollectionExercise.remove(collections1, predicate);
        System.out.println(collections1);

        CollectionExercise.retain(collections2, predicate);
        System.out.println(collections2);

        result = CollectionExercise.collect(collections3, predicate);
        for (int num : result) {
            System.out.println(num);
        }

        ArrayList<Integer> list = new ArrayList<>(collections4);
        int index = CollectionExercise.find(list, predicate);
        System.out.println(index);

    }
}
