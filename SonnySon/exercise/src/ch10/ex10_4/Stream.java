package ch10.ex10_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Stream {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred){
        Iterator<T> iterator = coll.iterator();
        while(iterator.hasNext()){
            T next = iterator.next();
            if(pred.test(next)) iterator.remove();
        }
    }
    public static <T> void retain(Collection<T> coll, Predicate<T> pred){
        Iterator<T> iterator = coll.iterator();
        while(iterator.hasNext()){
            T next = iterator.next();
            if(!pred.test(next)) iterator.remove();
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred){
        List<T> list = new ArrayList<>();

        Iterator<T> iterator = coll.iterator();
        while(iterator.hasNext()){
            T next = iterator.next();
            if(pred.test(next)) list.add(next);
        }
        return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred){
        Iterator<T> iterator = list.iterator();
        int index = 0;
        while(iterator.hasNext()){
            T next = iterator.next();
            if(pred.test(next)) return index;
            index++;
        }
        return -1;
    }
    // Return the index of the first item in list
    // for which the predicate is true, if any.
    // If there is no such item, return -1.

}
