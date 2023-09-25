package ch08.ex8_3;

enum enumRome {
    I(1), V(5), X(10), L(50), C(100), D(50), M(1000);

    final int value;

    enumRome(int i) {
        this.value = i;
    }
}

public class RomeNumber {

    private String romeNumber;
    private int decimalNumber;

    public RomeNumber(String romeNumber){
        if(romeNumber.isEmpty()){
            throw new NumberFormatException("문자열이 비어있음");
        }
        romeNumber = romeNumber.toUpperCase();
        this.decimalNumber = transRome2Decimal(romeNumber);
        this.romeNumber = romeNumber;
    }

    public RomeNumber(int decimalNumber){
        // precondition 조건 2 :  10진수 범위
        if(decimalNumber <= 0 || decimalNumber >= 4000){
            throw new NumberFormatException("숫자 범위는 1 ~ 3999 입니다.");
        }
        this.romeNumber = transDecimal2Rome(decimalNumber);
        this.decimalNumber = decimalNumber;
    }


    private int transRome2Decimal(String romeNumber) {
        int i = romeNumber.length() - 1;

        int previous = 0;
        int result = 0;

        while (i >= 0) {
            char c = romeNumber.charAt(i);
            int currentValue;

            try{
                currentValue = enumRome.valueOf(String.valueOf(c)).value;
            }catch(IllegalArgumentException e){
                throw new NumberFormatException("로마어 문법이 아닙니다." + romeNumber);
            }

            if (currentValue < previous)
                result -= currentValue;
            else
                result += currentValue;

            previous = currentValue;
            i--;
        }

        return result;
    }

    private String transDecimal2Rome(int decimalNumber) {
        String answer = new String();

        // Thousand
        int thousands = decimalNumber - (decimalNumber % 1000);
        for(int i = 0; i < thousands / 1000 ; ++i)
            answer += "M";

        // Hundred
        decimalNumber %= 1000;
        answer += toStr(decimalNumber, 100, "C", "D", "M");

        // Ten
        decimalNumber %= 100;
        answer += toStr(decimalNumber, 10, "X", "L", "C");

        // Digit
        decimalNumber %= 10;
        answer += toStr(decimalNumber, 1, "I", "V", "X");

        return answer;
    }

    public String toStr(int number, int offset,
                        String unit,
                        String unitFive,
                        String unitNine)
    {
        String ret = new String();
        number = number / offset;
        if(number < 5){
            if(number == 4){
                ret = unit + unitFive;
            } else{
                for(int i = 0; i < number; ++i){
                    ret += unit;
                }
            }
        } else{
            if(number == 9){
                ret += unit + unitNine;
            } else{
                ret = unitFive;
                for(int i = 5; i < number; ++i){
                    ret += unit;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString(){
        return this.romeNumber;
    }

    public int toInt(){
        return this.decimalNumber;
    }

}
