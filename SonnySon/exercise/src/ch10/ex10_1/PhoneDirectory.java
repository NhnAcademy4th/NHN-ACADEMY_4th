package ch10.ex10_1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TreeMap;

public class PhoneDirectory {
    TreeMap<String,String> phoneEntry = new TreeMap<>();
    public String getNumber( String name ) {
        if(!phoneEntry.containsKey(name))
            throw new IllegalArgumentException("없는 이름입니다.");
        return phoneEntry.get(name);
    }

    public void putNumber( String name, String number ) {
        if (Objects.equals(name,"") || Objects.equals(number, ""))
            throw new IllegalArgumentException("name and number cannot be empty");
        phoneEntry.put(name,number);
    }

} // end class PhoneDirectory
