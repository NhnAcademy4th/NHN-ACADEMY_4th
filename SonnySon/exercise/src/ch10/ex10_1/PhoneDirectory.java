package ch10.ex10_1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TreeMap;

/**
 * A PhoneDirectory holds a list of names with a phone number for
 * each name.  It is possible to find the number associated with
 * a given name, and to specify the phone number for a given name.
 */
public class PhoneDirectory {
    TreeMap<String,String> phoneEntry = new TreeMap<>();
    public String getNumber( String name ) {
        if(!phoneEntry.containsKey(name))
            throw new NoSuchElementException("없는 이름입니다.");
        return phoneEntry.get(name);
    }

    public void putNumber( String name, String number ) {
        if (Objects.equals(name,"") || Objects.equals(number, ""))
            throw new IllegalArgumentException("name and number cannot be null");
        phoneEntry.put(name,number);
    }

} // end class PhoneDirectory
