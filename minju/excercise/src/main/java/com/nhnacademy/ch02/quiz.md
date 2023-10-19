Q1 . Briefly explain what is meant by the syntax and the semantics of a programming language. Give an example to illustrate the difference between a syntax error and a semantics error.</br>
A1 . syntax는 문법, semantics는 프로그래밍 언어의 의미이다.</br>
syntax error는 형식이 틀렸을 때, semantics error는 기대했던 값이 나오지 않을 때 생기는 오류이다.
while (5) {}는 syntax error, x - y를 x + y로 코드를 작성했을때 semantics 오류이다.

Q2. What does the computer do when it executes a variable declaration statement. Give an example.</br>
A2. 메모리 공간에 박스를 만들고 그 박스와 이름을 연결짓는다. 프로그래머는 변수 이름으로 메모리에 접근할 수 있다.

Q3. What is a type, as this term relates to programming?</br>
A3. type은 저장되는 값의 범위를 지정해준다.

Q4. One of the primitive types in Java is boolean. What is the boolean type? Where are boolean values used? What are its possible values?</br>
A4. true, false로 참과 거짓을 나타낸다. if나 while, for 등 boolean 타입이 필요한 곳에 사용할 수 있다.

Q5. Give the meaning of each of the following Java operators:</br>
A5.
a) ++ : 변수에 1을 더해준다.</br>
b) && : AND 연산자. 좌측과 우측이 true면 true, 좌측과 우측 둘 중에 하나가 false면 false를 반환한다.</br>
c) != : 좌측과 우측 값이 같지 않을 때 true를 반환한다.

Q6. Explain what is meant by an assignment statement, and give an example. What are assignment statements used for?</br>
A6. 값을 계산하고 변수에 값을 할당한다. 프로그램 실행동안 변수의 값을 변경하는데 사용된다.

Q7. What is meant by precedence of operators?</br>
A7. 연산자들의 계산 순서이다.

Q8. What is a literal?</br>
A8. 실제 데이터는 2진수로 이루어져 있다. 2진수 값을 나타내기 위해 프로그램에 입력할 수 있는 문자를 literal이라고 한다.

Q9. In Java, classes have two fundamentally different purposes. What are they?</br>
A9. class는 subroutine과 변수의 집합 역할을 할 수 있다. 그리고 객체를 설명하고 생성할 수 있다.

Q10. " x = TextIO.getDouble(); " 문과 " x = TextIO.getlnDouble(); " 문 사이의 차이점은 무엇입니까?</br>
A10. 두 명령문 모두 double 값을 읽어오는 것은 같지만 getlnDouble은 다음 carriage return까지 포함해서 값을 읽는다.

Q11. Explain why the value of the expression 2 + 3 + "test" is the string "5test" while the value of the expression "test" + 2 + 3 is the string "test23". What is the value of "test" + 2 * 3? </br>
A11. 2 + 3 + "test"는 integer끼리의 덧셈을 먼저 수행하고 integer와 스트링을 더하기 때문에 5test이고, "test" + 2 + 3은 string과 integer를 먼저 더하고 계산 결과값인 test2와 3을 더한다.</br>
string "test2*3"

Q12. Integrated Development Environments such as Eclipse often use syntax coloring, which assigns various colors to the characters in a program to reflect the syntax of the language. A student notices that Eclipse colors the word String differently from int, double, and boolean. The student asks why String should be a different color, since all these words are names of types. What's the answer to the student's question?</br>
A12. int, double, boolean은 primitive type이고 String은 reference type이기 때문이다.

Q13. What is the purpose of an import directive, such as import textio.TextIO or import java.util.Scanner?</br>
A13. textio나 java.util package 내에 정의되어 있기 때문에 메소드를 사용할 때 import를 해주어야 사용할 수 있다.

Q14. Write a complete program that asks the user to enter the number of "widgets" they want to buy and the cost per widget. The program should then output the total cost for all the widgets. Use System.out.printf to print the cost, with two digits after the decimal point. You do not need to include any comments in the program.</br>

A14.

```java
import java.util.Scanner;

public class widgets {</br>
static void main(String[] args) {
    int number;
    double perWidget;
    double totalCostWidget;

    Scanner scanner = new Scanner(System.in);

    System.out.print("위젯의 수를 입력하세요 : ");
    number = scanner.nextInt();

    System.out.println("위젯의 가격을 입력하세요 : ");
    perWidget = scanner.nextDouble();

    System.out.printf("가격은 %1.2f입니다.", number * perWidget);

    }

}
```
