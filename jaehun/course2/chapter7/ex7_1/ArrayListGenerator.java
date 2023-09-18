package course2.chapter7.ex7_1;

import java.util.ArrayList;

public class ArrayListGenerator {
    private ArrayList<Integer> arrayList;

    public void generate(int count, int maxValue) {
        if (count > maxValue) {
            throw new IllegalArgumentException("최대값보다 많은 개수를 요소로 추가할 수는 없습니다.");
        }

        arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            addNum(maxValue);
        }
    }

    public void addNum(int maxValue) {
        while (true) {
            int value = (int) (Math.random() * maxValue) + 1;
            if (!arrayList.contains(value)) {
                arrayList.add(value);
                break;
            }
        }
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

}
