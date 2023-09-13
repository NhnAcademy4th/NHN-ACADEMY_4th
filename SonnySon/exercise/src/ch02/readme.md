## Quiz on Chapter2
##### Sonnyson
### Question 1 :

Briefly explain what is mean by the syntax and the semantics of a programming language. Give an example to illustrate the difference between a syntax error and a semantics error.

---

#### Answer :

Syntax(Form) : 문법
Semantic : 문법이 형식을 맞췄을 때, 그 문법이 하는 일

    public class Errors{
        public static void main(String[] args){
            System.out.println("Error")
            int a = 50;
            int b = 50;

            int sum = a * b; // this is multiple
        }
    }

여기서 print문에 ;을 붙이지 않은것은 Syntax Error,
아래 sum 은 문법적으로는 맞지만, 그 기능에 있어서 더하기 기능을 제대로 수행하지 못한다. 이것은 문법적 오류가 없기 때문에 컴파일오류가 나지 않아서, 디버그를 통해 잡아야한다.

### Question 2 :

What does the computer do when it executes a variable declaration statement. Give an example.

---

#### Answer :

    int pencil;

이런식으로 변수를 선언(declartion)하게 되면 선언을 하는 순간 컴퓨터는 메모리에 <b>pencil이라는 이름의 주소를 가진</b> 4byte의 빈 공간 하나를 확보하게 된다. 4byte라는 값은 Integer 라는 <b>식별자</b>(identifier)를 통해 설정한다.

메모리에 Data를 '대입'할때에는

    pencil = 3;

와 같은 방법으로 대입할수 있다. = 은 같다라는 의미가 아닌 pencil이라는 주소에 3이라는 Integer 타입의 값을 넣는다는 의미가 된다.

---

### Question 3 :

What is a type, as this term relates to programming?

#### Answer :

타입을 정의 한다는 말은 인코딩과 디코딩 방식을 어떤식으로 할건지를 선언하는 것이다 타입은 다른말로 식별자(identifier) 라고 한다. 첫번째로 메모리에서 차지할 공간의 크기를 알기 위해서이다. 이 data가 어느정도의 메모리가 필요한지 알아야 데이터를 아낄수 있기 때문이다.
두번째는 타입에 따라 이진코드를 해석하는 방법이 다르기 때문이다.

### Question 4 :

One of the primitive types in Java is boolean. What is the boolean type? Where are boolean values used? What are its possible values?

#### Answer :

대수형 (boolean) 타입은 true or false 값만 가질수 있는 \* 진리값 형태의 자료형이다. 단순히 true와 false 는 조건문이 필요한 경우에 사용 가능한데, 단순히 그냥 if(1)이런식으로 하면 되는것이 아니냐는 의문을 가질수도 있다. 하지만 int 값은 4byte를 사용해야하고, boolean 형태는 1bit 만 사용해도 해결 가능하지만, java의 최소단위는 byte이므로 3byte 를 아낄수 있다.

- 진리값 : 어느 명제의 내용이 참인지 거짓인지 나타내는 값

### Question 5:

Give the meaning of each of the following Java operators:

    a)    ++
    b)    &&
    c)    !=

a) ++의 의미는 단순히 1을 더한다는 의미가 있다. 사용방법은

    int a = 1;
    System.out.println(a++);
    System.out.println(++a);

처럼 사용할수 있지만 기호를 변수 앞, 뒤에 붙이냐에 따라 의미가 다르게 해석된다. 전자의 경우 변수를 호출 한 이후에 +1이 되는것이고, 후자의 경우 먼저 +1을 한후 출력이 된다

> output : 2, 2

b) && 는 비교 연산자로서 같은가? 라는 뜻이다. a && b 의 의미는 a 와 b를 비교하여 같으면 true, 틀리면 false 를 출력한다.

c) != 는 비교 연산자로서 같지 않냐 라는 의미이다. &&와 반대의 의미이다.

### Question 6:

Explain what is meant by an assignment statement, and give an example. What are assignment statements used for?

#### Answer :

assignment statement 란 왼쪽 변수에 오른쪽 변수를 할당한다는 의미이다.

    a = 3+63;

을 하게 되면 a에는 3과 63을 더하여 할당하게 되며, 이를 assignment state라 한다.

### Question 7:

What is meant by precedence of operators?

#### Answer :

두개 이상의 연산자가 있을 때 무엇을 더 먼저 연산할지를 나타낸다. +와 *가 같은 식에 있으면 *를 먼저 연산 한다.
다른 예로

    int a = (a + b) * c;

의 경우 +를 먼저 연산한다.

### Question 8:

What is a literal?

#### Answer :

자바에서 리터럴이란 boolean, numeric, character, String, 등등을 나타내는 방법이다.

    int a = 0; // 0
    int b = 0123 // 8진수 표현 방법
    int c = 0x80 // 16진수 표현 방법
    boolean d = true
    String e = "string"
    char f = 'c';

### Question 9:

In Java, classes have two fundamentally different purposes. What are they?

클래스의 목적 한가지는 다양한 자료형과 기능을 가진 객체를 생성하는데 있다. / 하나는 모르겠음

### Question 10:

What is the difference between the statement "x = TextIO.getDouble();" and the statement "x = TextIO.getlnDouble();"

#### Answer :

    TextIO.getDouble //   \0,\n 둘다 종료 조건
    TextIO.getlnDouble() // \n 만 종료조건

### Question 11:

Explain why the value of the expression 2 + 3 + "test" is the string "5test" while the value of the expression "test" + 2 + 3 is the string "test23". What is the value of "test" + 2 \* 3 ?

#### Answer :

2와 3은 integer 타입이라 앞에서 먼저 더하기 연산이 되지만 (precedence operator에 의해) String과 int형의 연산의 경우 integer type이 자동으로 String 전환된다.

### Question 12:

Integrated Development Environments such as Eclipse often use syntax coloring, which assigns various colors to the characters in a program to reflect the syntax of the language. A student notices that Eclipse colors the word String differently from int, double, and boolean. The student asks why String should be a different color, since all these words are names of types. What's the answer to the student's question?

#### Answer :

byte,short,int,long,float,double,char,boolean은 Primitive Type(원시형)이라 불린다. 자바의 기본적이 자료형으로 Stack 영역에 저장된다.

    int a = 5;

생성방법은 와 같이 객체로 선언하지 않는다.

String은 다르다, String은 ""을 통해 생성도 가능하고, new를 통해서도 생성 가능하다.

    String a = "Hello";  // heap영역 String Constant Pool 에 저장
    String a = new String("Hello"); // heap 메모리에 저장

String ConstantPool에 저장한값 ("") 은 같은 String 값인 경우 같은 주소를 가르킨다. 하지만 값을 변경하는 경우 값을 변경하는 것이 아닌 다른 값을 만들고 그것을 가리킨다. 따라서 같은값을 가르키던 값은 변하지 않는다. String 이라는 것은 immutable한 객체,불변하는 객체 이기 때문에 관리가 가능하다.

### Question 13:

What is the purpose of an import directive, such as import textio.TextIO or import java.util.Scanner?

#### Answer :

textio 라는 모듈 안에 TextIO클래스를 여기서도 사용 가능하게 하겠다는 의미이다. 클래스 안에 메서드를 사용하기 위해서는 TextIO.method명 (static인 경우) 로 사용 가능하다.

### Question 14:

Write a complete program that asks the user to enter the number of "widgets" they want to buy and the cost per widget. The program should then output the total cost for all the widgets. Use System.out.printf to print the cost, with two digits after the decimal point. You do not need to include any comments in the program.

#### Answer :

    package ch03;

    import java.util.Scanner;

    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Widget Amount: ");
        int widget = sc.nextInt();
        System.out.print("Widget Price: ");
        int price = sc.nextInt();

        System.out.printf("%1.2f", (double) widget * price);
    }

}
