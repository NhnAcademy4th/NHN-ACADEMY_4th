package com.nhnacademy.ch10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class ex10_4 {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        for (T item : coll) {
            if (pred.test(item)) {
                coll.remove(item);
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        for (T item : coll) {
            if (!pred.test(item)) {
                coll.remove(item);
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        for (T item : coll) {
            if (pred.test(item))
                list.add(item);
        }
        return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.test(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
