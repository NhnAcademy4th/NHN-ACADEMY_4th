package ex10_1;

import java.util.Objects;
import java.util.TreeMap;

public class PhoneDirectory {
    private TreeMap<String, String> directory;

    public PhoneDirectory() {
        directory = new TreeMap<>();
    }

    public void addPhone(String name, String number) {
        if (Objects.isNull(name) || Objects.isNull(number))
            throw new IllegalArgumentException("이름과 전화번호 모두 입력되어야 합니다.");
        if (!number.matches("\\d{3}-?\\d{4}-?\\d{4}"))
            throw new IllegalArgumentException("번호 형식이 잘못되었습니다.");
        directory.put(name, number);
    }

    public String find(String name) {
        String result = directory.get(name);
        if (Objects.isNull(result))
            throw new IllegalArgumentException("이름을 잘못 입력하였습니다.");
        return result;
    }

}
