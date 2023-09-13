package Chapter3;

import java.util.ArrayList;

public class ex3_7_V2 {
    public static int checkBirthday(int[] used){
        int falsecounter = 0;
        for(int i = 0; i < 365; i++){
            if(used[i] == 0){
                falsecounter++;
            }
        }
        return falsecounter;
    }
    public static void ex3_7_3(){
        ArrayList<Integer> list = new ArrayList<>();
        int[] used;
        int count;
        final int dayXmonth = 365;

        list.add(null);

        used = new int[dayXmonth];
        count = 0;

        while (true) {

            int birthday;
            birthday = (int)(Math.random()*dayXmonth);
            count++;
            used[birthday]++;

            if ( used[birthday] == 3 && (list.get(0) == null)){
                    list.set(0, count);
            }

            if(count == dayXmonth){
                list.add(checkBirthday(used));
            }


            if (checkBirthday(used) == 0) {
                break;
            }
        }

        System.out.println("같은 생일을 가진 3명을 찾기까지 "
                + list.get(0) + " 시도함.");

        System.out.println("365일중 "
                + (dayXmonth - list.get(1)) + " 일은 누군가의 생일임");


        System.out.println("365일이 모두 누군가의 생일이기 위해선 "
                + count + " 명을 찾아야함");
    }
    /*
    재사용성을 높이기 위해서 할만한 방법
    while 문의 구성은 동일하나 while문이 break되기 위한 조건이 모두 다르다.
    해당 조건이 다르기때문에 while 문을 재사용하기 어렵다.
    내가 생각한 방법 -> 하나의 while 문에 if 문을 모두 사용한다. 그리고 if 문 각각 결과값을 찾으면 int 값을 저장한다.
    이후 모두 해당 값을 찾았다면 저장한 int 값을 각자 리턴한다.
    예외처리를 잘 해볼 수 있도록 좀더 노력해 봅시다.
     */
    public static void main(String[] args) {

        ex3_7_3();
    }
}