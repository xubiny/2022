# Java와 JVM의 기초
## 1. 프로그래밍 언어
### 프로그래밍 언어는 고급언어와 저급언어로 구분된다.
- 고급 언어 : 컴퓨터가 바로 이해할 수 없으므로 컴파일 과정을 통해 컴퓨터가 이해할 수 있는 0과 1로 이루어진 기계어로 변환 후 사용 <br/><br/>
- 저급 언어 : 기계어에 가까운 언어로, 어셈블리언어가 대표적이다. 따라서, 사람이 쉽게 이해할 수 없어 배우기도 힘들다. <br/><br/>

<br/><br/>

일반적으로 프로그래밍 언어라고 하면 고급 언어를 말하며, 대표적으로 C나 Java가 모두 고급 언어에 속한다. <br/><br/>
이러한 언어들로 작성된 내용을 Source라고 부르며, 해당 코드는 Compiler를 통해 기계어로 변환된 후 컴퓨터에서 실행된다.

<br/><br/><br/><br/>

## 2. Java
- **이식성이 높은 언어** : 이식성이란 서로 다른 실행 환경을 가진 시스템 같이 프로그램을 실행시킬 수 있는 것을 말한다. Java는 운영체제에 종속적이지 않으며 Window, Linux 등 실행 가능하다. Java 언어로 개발된 프로그램은 소스 파일을 다시 수정하지 않아도, 자바 실행 환경 (JRE : Java Runtime Environment)이 설치되어 있는 모든 운영체제에서 실행이 가능하다. <br/><br/>
- **객체 지향 언어** : Java 하면 OOP(Object Oriented Programming)을 쉽게 생각할 것이다. 프로그램을 개발하는 기법으로 부품에 해당하는 객체를 만들고, 이것을 조립 및 연결하면서 개발하는 프로그래밍 기법을 OOP라 한다. 따라서 캡슐화, 상속, 다형성 기능을 완벽하게 지원한다. <br/><br/>
- **함수적 스타일 코딩을 지원** : 최근 들어 많이 부상하고 있는 함수형 스타일 코딩을 Java 또한 제공한다. Lambda Expressions을 Java8부터 지원하기 시작했으며, 각종 함수를 조합하여 코드를 간결하게 작성할 수 있다. <br/><br/>
- **메모리 자동 관리** : C나 C++ 개발을 하다 보면 생성된 객체는 개발자가 직접 제거를 해주는 코드를 작성해야 한다. Java는 이러한 과정 없이 GC(Garbage Collector)가 자동으로 메모리를 관리하며, 객체 생성 시 자동으로 메모리 영역을 할당하고 사용이 완료되면 자동으로 객체를 제거해준다. <br/><br/>

<br/><br/>

### Java는 주로 2가지 버전을 사용한다.
- **Java SE (Standard Edition)** : Java 프로그램들이 공통적으로 사용하는 JVM(Java Virtual Machine)을 비롯하여 Java 프로그램 개발에 필수적인 도구와 라이브러리 API를 제공한다. Java 개발 및 실행을 위해선 반드시 Java SE 구현체인 JDK(Java Development Kit)을 실행해야한다. <br/><br/>
- **Java EE (Enterprise Edition)** : 분산 환경에서 서버용 Application을 개발하기 위한 도구 및 라이브러리 API를 제공한다. 주로 회사에서는 EE버전을 사용하여 개발한다. 서버용 Application으로는 Servlet/JSP 및 EJB(Enterprise Java Bean) 등이 있다. <br/><br/>

<br/><br/>

### JDK vs JRE
- JDK는 프로그램 개발에 필요한 JVM, Java Library API, Complier 등의 개발 도구가 포함되어 있고, JRE에는 프로그램 실행에 필요한 JVM, Java Library API만 포함되어 있다. 따라서 Java프로그램을 개발하는것이 아닌, 실행만시킬 땐 JRE만 설치하면 된다. <br/><br/>
  - **JRE = JVM + Java Common Library** <br/><br/>
  - **JDK = JRE + Java Development Kit** <br/><br/>

<br/><br/><br/><br/>

## 3. 자바 가상 기계(JVM)
- Java가 운영체제에 종속적이지 않고 어느 환경에서나 실행이 가능하다. 이러한 기능을 제공해주는 것이 JVM이라 생각하면 된다. <br/><br/>
- 운영체제는 Java 프로그램을 바로 실행할 수 없다. JRE 또는 JDK를 설치하여 JDK가 있어야 Java를 실행시킬 수 있다. <br/><br/>
- Java 프로그램은 완전한 기계어가 아닌 중간 단계의 바이트 코드이기 때문에 이것을 해석하고 실행할 수 있는 가상의 운영체제가 필요하다. <br/><br/>
- 이것이 바로 JVM(Java Virtual Machine)이다. <br/><br/>
- 운영체제별로 프로그램을 실행하고 관리하는 방법이 다르기 때문에 각각의 운영체제별로 Java 프로그램을 개발하기 보다는 운영체제와 Java 프로그램을 중계하는 JVM을 두어 여러 운영체제 환경에서도 동일한 실행 결과가 나오도록 설계한 것이다. **따라서 개발자는 운영체제와 상관없이 Java 프로그램을 개발할 수 있다.** <br/><br/>

<br/>

바이트 코드는 모든 JVM에 동일한 실행 결과를 보장하지만, JVM은 운영체제에 종속적이다. **따라서 Java 프로그램을 운영체제가 이해하는 기계어로 번역해서 실행해야 하므로 JVM은 운영체제에 맞게 설치되어야 한다.** <br/><br/>

JVM은 JDK 또는 JRE를 설치하면 자동으로 설치되며, JDK와 JRE가 운영체제 별로 제공하니 운영체제에 맞게 설치하도록 하자. <br/><br/>

<br/>

- Eclipse에서 프로젝트 생성 후 Class 파일을 생성하면 .java 파일이 생성되는 것을 볼 수 있다. 이것을 소스파일이라고 하는데, Java는 이 소스 파일을 javac.exe(컴파일러)로 컴파일하면 확장자가 .class인 바이트 코드 파일이 생성된다. <br/><br/>
- 바이트 코드 파일은 JVM 구동 명령어인 java.exe에 의해 JVM에서 해석되고 해당 운영체제에 맞게 기계어로 번역된다.

<br/>

---

<br/><br/><br/><br/><br/><br/><br/><br/>

# 변수(Variable)
- 변수란 프로그램에 의해 이름을 할당받은 데이터를 저장할 수 있는 메모리 공간을 의미한다. <br/><br/>
- ex) 사람의 나이, 학생의 학년, 사원의 수 <br/><br/>

<br/>

## 변수 선언
- 변수 선언 방법은 변수에 맞는 자료형과 변수 이름으로 선언한다. <br/><br/>
<pre><code>int age; // 이때 int가 자료형, age가 변수이름</code></pre>

<br/><br/>

### 변수를 선언하는 두가지 방법
#### 1. 변수의 선언만 하는 방법
- 변수를 선언하여 메모리 공간만을 할당받고, 나중에 변수를 초기화하는 방법 <br/><br/>
<pre><code>package Variable;

public class VariableEx {
	public static void main(String[] args) {
		int age;
		age = 11;
    
		System.out.println(age);
	}
}
// 결과 : 11</code></pre>

<br/><br/>

#### 2. 변수 선언과 동시에 초기화하는 방법
- 변수 선언하여 메모리 공간을 할당받음과 동시에 변수를 초기화하는 방법 <br/><br/>
<pre><code>package Variable;

public class VariableEx {
	public static void main(String[] args) {
		int age = 11;
		
		System.out.println(age);
	}
}
// 결과 : 11</code></pre>

<br/><br/><br/><br/>

## 변수 명명 규칙
- 변수의 이름은 영문자(대소문자), 숫자를 사용함(단 숫자로 시작할 수 없다.)) <br/><br/>
- 변수의 이름은 특수문자 중에 ' _ ' 와 '$'만 사용할 수 있다. <br/><br/>
- 변수의 이름 사이에는 공백을 포함할 수 없다. <br/><br/>
- 변수의 이름으로 java에서 미리 정의한 키워드. 즉, 예약어는 사용할 수 없다. <br/><br/>
- 변수의 이름은 그 쓰임에 맞는 이름으로 명명하는 것이 가독성에 좋다. <br/><br/>

<br/><br/><br/><br/>

## 변수와 메모리
- 변수를 선언하는 것은 해당 자료형의 크기만큼의 메모리를 사용하겠다는 것이다. 변수는 기본적으로 메모리의 주소를 기억하는 역할을 한다. 여기서 메모리 주소란 물리적인 메모리 공간을 서로 구분하기 위해 사용되는 일종의 식별자이다. 즉, 메모리 주소란 메모리 공간에서의 정확한 위치를 식별하기 위한 고유 주소를 의미한다. <br/><br/>
- 변수를 참조할 때는 메모리의 주소를 참조하는 것이 아닌 해당 주소에 저장된 데이터를 참조하게 된다. 따라서 변수는 데이터가 저장된 메모리의 주소뿐만 아니라 저장된 데이터의 길이와 형태에 관한 정보도 같이 기억해야 한다. <br/><br/>
- 하나의 메모리 공간에는 8개의 비트로 이루어진 1바이트의 데이터가 저장된다. 따라서 메모리의 주소 또한 1바이트씩 증가되며, 낮은 주소부터 차례대로 데이터가 저장된다.

<br/>

---

<br/><br/><br/><br/><br/><br/><br/><br/>