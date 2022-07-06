# 1. Spring이란
- JAVA의 웹 프레임워크로 JAVA 언어를 기반으로 사용한다. <br/><br/>
- 애플리케이션 프레임워크는 애플리케이션 개발을 빠르고 효율적으로 할 수 있도록 애플리케이션의 바탕이 되는 틀과 공통 프로그래밍 모델, 기술 API를 제공해준다. <br/><br/>
- 스프링은 웹사이트 개발을 위한 백엔드 프레임워크이다. <br/><br/>

<br/><br/><br/><br/>

## 1.1.1. 프레임워크(FrameWork)
- 프로그램 설계에 있어 미리 구축되어있는 뼈대라고 이해하면 쉽다. <br/><br/>
- 프로세스를 구축하는데 있어 기본적인 뼈대를 제공해주어 높은 품질의 프로그램을 빠르게 개발할 수 있게된다. <br/><br/>
- 어떠한 목적을 달성하기 위해 복잡하게 얽혀 있는 문제를 해결하기 위한 구조이자 약속이며, 소프트웨어 개발에 있어서 하나의 뼈대 역할을 한다. <br/><br/>
- 더 간단히 말하자면 프레임워크는 자주 쓰일만한 기능들을 한데 모아놓은 유틸(클래스)들의 모음(집합)이라고 정의할 수 있다. <br/><br/>
- 설계의 기반이 되는 부분을 기술한 확장 가능한 기반 코드와 사용자가 이 코드를 자기 입맛대로 수정, 확장하는 데 필요한 라이브러리 이 두가지 요소가 통합되어 제공되는 형태이다. <br/><br/>
- 사용자가 이 기반 코드를 이용해 일정 수준 이상의 품질을 보장받는 코드를, 비교적 빠른 시간에 완성 및 유지 보수할 수 있는 환경을 제공해주는 솔루션이다. <br/><br/>
- 즉, 프레임워크는 기본적인 설계나 필요한 라이브러리는 알아서 제공해줄 것이니 개발자는 만들고 싶은 기능을 구현하는데 집중하라는 취지에서 만들어진 것이다. <br/><br/>
- 개발자가 구현하고자 하는 기능을 쉽게 제공해줄 수 있다는 점에서 프레임워크는 라이브러리와 비슷한 면이 있다. <br/><br/>

<br/><br/>

## 1.1.2. 프레임워크와 라이브러리의 차이점
- 라이브러리는 개발자가 프로그램을 짜다가 라이브러리가 필요한 순간에 인지하고 라이브러리를 직접 추가해야겠다는 생각이 들었을 때 가져다 쓰는 것이다. 라이브러리는 프로그램 기능 구현에만 도움을 줄 수 있다. <br/><br/>
- 하지만 프레임워크는 필요한 라이브러리와 기능 구현에 필요한 설계도 틀을 함께 제공해준다. <br/><br/>
- 설계도 틀이란 확장 가능한 기반코드, 재사용 가능한 형태의 협업화된 클래스와 같은 뜻이다. 사용자가 세세하게 신경쓰지 않아도 빠르게 기능을 확장하거나 유지보수할 수 있게 해주는 구조에 대한 가이드라인이라 할 수 있다. 즉, 기반이 되는 부모 클래스라고 생각하면 된다. <br/><br/>
- 개발자가 동일한 라이브러리를 쓰는 동일한 기능의 프로그램을 사용할 때, 프레임워크를 사용하면 클래스 관계 구조나 데이터를 처리하는 절차, 프로그램이 화면에 그려지는 방식 등 일부 틀을 함께 제공받을 수 있다. 즉, 프레임워크는 라이브러리 + 설계도가 함께 온다. <br/><br/>

<br/><br/>

## 1.1.3. 왜 필요한가?
### 무거운 기존 프레임워크 
- 수많은 웹서비스 기반 기업들이 등장하면서 안정된 품질, 그리고 빠른 개발속도를 가진 프로그램이 필요하게 된다. 그러나 그동안의 프레임워크는 너무 무겁고 내용이 방대했다. 무거운 프레임워크에서 벗어나 가볍고 강력한 프레임워크를 필요로 하게 된다. <br/><br/>

- 이러한 기업의 니즈에 맞춰 수많은 프레임워크들이 등장하게 되었고, 이때 경량 프레임워크인 스프링이 등장하게 된다. <br/><br/>

<br/>

### 전체 구조를 다루는 프레임워크
- 기존의 프레임워크는 특정 부분에 한정해 기능을 제공하고, 전체적인 로직은 개발자에게 맡기는 방식이었다. 하지만 스프링은 특정 부분에 한정되지 않고, 백엔드 프로세스 구축 전 단계를 지원한다. <br/><br/>
- 일반적으로 웹 개발에 사용되지만, 기본적으로 구조를 다루는 프레임워크이다. <br/><br/>

<br/>

### 다양한 프레임워크와의 호환성
- 스프링은 다른 프레임워크(ex. 데이터베이스 프레임워크 MyBatis)와의 호환성이 높아 기본 스프링 프레임워크를 유지하면서, 다른 프레임워크를 혼용하여 사용할 수 있다. 다양한 방식으로 프로세스 개발이 가능해진다. <br/><br/>

<br/><br/><br/><br/>

# 1.2 스프링의 특징
## 의존성 주입 (DI : Dependency Injection)
- 프로그래밍에서 구성요소 간의 소스코드 내부가 아닌 외부의 설정파일을 통해 정의되는 방식이다. <br/><br/>
- 코드 재사용율을 높여 소스코드를 다양한 곳에 사용할 수 있으며 모듈간의 결합도도 낮출 수 있다. <br/><br/>
- 쉽게 말하자면 게임 캐릭터라는 하나의 객체가 존재하는데, 그 객체를 더 잘 이용하기 위해서 무기, 방패 등 아이템을 가져와 결합시키는 것이다. 이 객체는 무기와 방패를 자유자재로 부착, 탈부착하면서 적절한 상황에 필요한 기능을 해낼 수 있다. <br/><br/>

<br/>

## POJO 방식
- Plain Old Java Object의 약자, 말그대로 기존의 일반적인 java 코드를 이용해서 프로그래밍이 가능하다. <br/><br/>
- 기존의 프레임워크(Java EE)의 방식에선 미리 설계되어있는 인터페이스나 클래스를 상속받아 무거운 객체들을 만들어야만 했는데, 그럴 필요가 없이 일반적인 java 코드로만으로도 객체를 구성할 수 있게 된다. <br/><br/>
- 따라서 더 유연한 프로그래밍이 가능해지며 가볍고 생산성이 높아진다. <br/><br/>
- 즉, getter/setter를 가진 단순한 자바 오브젝트를 말한다. <br/><br/>

<br/>

## 관점지향 프로그래밍 (AOP)
- 로깅, 트랜잭션, 보안 등 여러 모듈에서 공통적으로 사용하는 기능을 분리하여 관리할 수 있다. <br/><br/>
- 각각의 클래스가 있다고 가정하자. 각 클래스들은 서로 코드와 기능들이 중복되는 부분이 많다. 코드가 중복될 경우 실용성과 가독성 및 개발 속도에 좋지 않다. 중복된 코드를 최대한 배제하는 방법은 중복되는 기능들을 전부 빼놓은 뒤 그 기능이 필요할 때만 호출하여 쓰면 훨씬 효율성이 좋다. <br/><br/>
- 즉, AOP는 여러 객체에 공통으로 적용할 수 있는 기능을 구분함으로써 재사용성을 높여주는 프로그래밍 기법이다. <br/><br/>

<br/>

## 제어 반전 (IoC : Inversion of Control)
- 기존의 프로그래밍 방식에선 라이브러리를 호출하여 코드에 포함시켜 프로그램을 실행시켰다. 하지만 스프링에서는 지원하는 형식에 맞게 프로그램을 작성하면 프레임워크에서 사용자가 작성한 코드를 호출해서 사용하는 방식으로 제어의 권한이 역전된 모습을 보여준다. <br/><br/>
- 인스턴스(객체)의 생성부터 소멸까지 객체 생명주기 관리를 개발자가 하는게 아닌 스피링(컨테이너)가 대신 해주는 것을 말한다. <br/><br/>
- 프로젝트의 규모가 커질수록 객체와 자원을 이용하는 방법이 더 복잡해지고 어디서 코드가 꼬일지 모르는 것을 Spring의 IoC가 자동으로 관리해준다. <br/><br/>
- 즉, 제어권이 개발자가 아닌 IoC에게 있으며 IoC가 개발자의 코드를 호출하여 그 코드로 생명주기를 제어하는 것이다. <br/><br/>

<br/><br/><br/><br/>

# 1.3. 스프링 프로젝트 구조
## src/main/java
- 자바코드를 넣을 수 있는 곳으로 java 파일이 모여있는 저장소이다. 앞으로 만들 java 파일은 이곳에서 생성할 수 있다. <br/><br/>

<br/>

## src/main/resources
- xml 문서를 만들 수 있는 곳이다. 스프링 설정 파일이나 쿼리가 저장될 저장소이다. <br/><br/>

<br/>

## src/test/...
- test 관련 폴더이다. TDD(Test Driven Development) 방법론이나 테스트 코드를 따로 작성하는 곳이다. <br/><br/>

<br/>

## src/main/webapp
- 메이븐을 사용할 때, 메이븐의 기본 폴더이다. webapp 폴더 밑에 모든 jsp 및 js 등의 파일을 생성할 수 있다. <br/><br/>

<br/>

- appServlet에 있는 servlet-context.xml 및 root-context.xml은 Servlet 설정 파일이다. <br/><br/>
- 그 밑에 views 폴더는 jsp 문서를 생성할 수 있다. <br/><br/>
- 다음 아래에 있는 web.xml에서는 서블릿의 설정을 할 수 있다. <br/><br/>

<br/>

## target 폴더
- 빌드 결과를 출력하는 저장소이다. <br/><br/>

<br/>

## pom.xml
- 라이브러리들을 관리할 수 있는 문서이다. <br/><br/>

<br/><br/><br/><br/>

---

<br/><br/><br/><br/>

# 2. 웹 개발과 Rest API
# 스프링을 이용한 3가지 웹 동작 방식
## 2.1 정적 콘텐츠 방식
<pre><code>@GetMapping("hello")
public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
}</code></pre>

<br/><br/>

![image](https://user-images.githubusercontent.com/61584142/177341094-d97139e3-d87a-4050-bc2e-d71bd2c10240.png)

<br/>

- 정적 콘텐츠 방식은 파일을 별도의 가공 없이 브라우저로 보내주는 방식이다. 공식 문서를 보면 어떤 파일을 찾아서 전달하는지 나와있다. <br/><br/>
- index.html을 통해 controller로 이동하게 되면 viewResolver가 리턴 값으로 화면에 해당하는 파일을 찾는다. 스프링 부트 템플릿 엔진은 viewName 맵핑을 지원하기 때문에 파일명이 일치하면 바로 브라우저에 전달한다. <br/><br/>

<br/><br/>

## 2.2 MVC와 템플릿 엔진 방식
- MVC : Model, View, Controller
<pre><code>@GetMapping("hello-mvc")
public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
}</code></pre>

<br/><br/>

- Controller에서 사용되는 주요 메서드 annotation <br/><br/>
- @GetMapping : Controller에서 url을 매칭한다. <br/><br/>
- @RequestParam() : 파라미터로 값을 받을 때 사용한다. <br/><br/>

<pre><code>public String helloMvc(@RequestParam("name") String name) </code></pre>

<br/>

- 위와 같이 @RequestParam()으로 Controller 파라미터가 있다면, 요청 url 뒤에 ?name= 문자열이 파라미터로 붙어야 Controller에서 맵핑을 한다.

<br/>

![image](https://user-images.githubusercontent.com/61584142/177341818-91a92fb8-6bf0-408f-941b-0721ffe79844.png)

<br/>

- Controller : url 요청이 들어오면 내장 톰캣서버가 해당 Controller를 찾아 보내준다. <br/><br/>
- Model : Controller는 url에 일치하는 메서드를 찾아 실행한다. return을 이용해 필요한 데이터를 담은 model을 전달한다. <br/><br/>
- View : viewResolver가 템플릿 엔진을 이용해 return과 이름이 일치하는 view 파일을 찾아 브라우저에 보여준다. <br/><br/>

<br/><br/>

## 2.3 API 방식
- 정적 콘텐츠 방식이 아니라면 2가지(MVC/API)만 기억하면 된다. <br/><br/>
- MVC가 별도의 View 영역이 존재하고, html 파일을 조작하여 브라우저에게 전달하는 방식이라면, API는 브라우저에 데이터만 보내주고 화면을 만드는 건 브라우저가 담당하는 방식이다.

<pre><code>@GetMapping("hello-mvc")
@ResponseBody
public String helloString(@RequestParam("name") String name) {
    return "hello" + name;
}</code></pre>

<br/><br/>

### API 방식의 주요 annotation
- @ResponseBody : html이 아닌 http의 통신 프로토콜이 header와 body로 나눠지는데, body에 이 내용을 직접 넣겠다는 의미다. <br/><br/>
- 리턴되는 데이터가 클라이언트에게 그대로 전달된다. <br/><br/>
- View가 별도로 존재하지 않는다. 데이터가 그대로 전달된다. <br/><br/>

<br/>

### 만약 객체를 보내야 할 경우 어떻게 해야 할까?
- api 방식에서는 return 타입으로 객체를 보내면 기본적으로 json 객체가 브라우저에 전달된다. <br/><br/>
- json은 key:value 구조로 이루어진 문자열 데이터 포맷이다. 

<pre><code>@GetMapping("hello-api")
@ResponseBody
public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;

}

static class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}</code></pre>

<br/><br/>

### 2.3.1 API 방식의 동작 원리
- API는 HTTP의 body 영역에 문자 내용을 직접 반환한다. 화면을 별도로 만들지 않기 때문에 viewResolver 대신에 httpMessageConverter가 동작한다. 해당 기능은 스프링 부트에서 자동으로 제공한다. httpMessageConverter는 리턴 타입이 문자열일 경우 StringHttpMessageConverter 객체를 사용하고, 리턴 타입이 객체일 경우 MappingJackson2HttpMessageConverter을 사용한다. <br/><br/>
- jackson은 스프링이 객체를 json으로 바꿔주는데 사용하는 디폴트 라이브러리다. <br/><br/>
- 만약 클라이언트의 HTTP Accept 헤더에 특정한 반환 타입이 명시되어 있을 경우, 스프링은 controller의 리턴 타입 정보를 참고하여 자동으로 적합한 타입을 결정한다. 그리고 타입에 해당하는 HttpMessageConverter가 선택되어, 데이터를 변환 후 전달한다. <br/><br/>

<br/><br/>

## 2.4 스프링 MVC로 REST API 사용하기
- 소프트웨어는 대체되어도 수년간 쌓인 데이터는 대체할 수 없다. <br/><br/>
- SOAP 동작과 프로세싱에 집중 <br/><br/>
- REST 관심은 데이터 처리 <br/><br/>
- 스프링 3.0부터 REST 작업에 대한 최고 수준의 지원을 제공하고 3.1, 3.2, 4.0에도 계속 되었다. <br/><br/>

<br/><br/>

### 2.4.1 휴식(REST)을 취하다 (Getting REST)
- SOAP - 많은 애플리케이션에게 부담 <br/><br/>
- REST - 더 간편한 대안 제공 <br/><br/>

<br/><br/>

### 2.4.1.1 REST의 기본 개념
- REST는 "Representational State Transfer"의 약어로 하나의 URI는 하나의 고유한 리소스(Resource)를 대표하도록 설계된다는 개념이다. <br/><br/>
- 스마트폰과 태블릿 등 서버에 접근하는 디바이스의 종류가 다양해지고 있기에 디바이스의 종류에 상관없이 공통으로 데이터를 처리할 수 있도록 하는 방식을 REST라고 한다. <br/><br/>
- 우리는 지금까지 게시판을 구현하면서 컨트롤러에서 서비스를 호출하고, 필요한 결과를 화면(View)으로 전달한 다음, HTML을 리턴하는 형태로 진행해 왔다. <br/><br/>
- REST API는 사용자가 어떠한 요청을 했을 때 화면(HTML)을 리턴하지 않고, 사용자가 필요로 하는 결과(데이터)만을 리턴해주는 방식이다. <br/><br/>

<br/><br/>

### 2.4.1.2 REST 구성
- 쉽게 말해 REST API는 자원(Resource) = URI, 행위(Verb) = HTTP METHOD, 표현(Representations) 으로 이루어져 있다. <br/><br/>

<br/><br/>

### 2.4.1.3 REST의 특징
#### 1) Uniform (유니폼 인터페이스)
- Uniform Interface는 URI로 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍처 스타일을 말한다. <br/><br/>

<br/>

#### 2) Stateless (무상태성)
- REST는 무상태성 성격을 가진다. 다시 말해 작업을 위한 상태정보를 따로 저장하고 관리하지 않는다. 세션 정보나 쿠키정보를 별도로 저장하고 관리하지 않기 때문에 API 서버는 들어오는 요청만을 단순히 처리하면 된다. 때문에 서비스의 자유도가 높아지고 서버에서 불필요한 정보를 관리하지 않음으로써 구현이 단순해진다. <br/><br/>

<br/>

#### 3) Cacheable (캐시 가능)
- REST의 가장 큰 특징 중 하나는 HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용이 가능하다. 따라서 HTTP가 가진 캐싱 기능이 적용 가능하다. HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능하다. <br/><br/>

<br/>

#### 4) Self-descriptiveness (자체 표현 구조)
- REST의 또 다른 큰 특징 중 하나는 REST API 메시지만 보고도 이를 쉽게 이해 할 수 있는 자체 표현 구조로 되어 있다는 것이다. <br/><br/>

<br/>

#### 5) Client - Server 구조
- REST 서버는 API 제공, 클라이언트는 사용자 인증이나 컨텍스트(세션, 로그인 정보)등을 직접 관리하는 구조로 각각의 역할이 확실히 구분되기 때문에 클라이언트와 서버에서 개발해야 할 내용이 명확해지고 서로간 의존성이 줄어들게 된다. <br/><br/>

<br/>

#### 6) 계층형 구조
- REST 서버는 다중 계층으로 구성될 수 있으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 한다. <br/><br/>

<br/><br/>

### 2.4.1.4 REST API 디자인 가이드
- URI는 정보의 자원을 표현해야 한다. <br/><br/>
- 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현한다. <br/><br/>

<br/><br/>

#### 2.4.1.4.1 REST API 중심 규칙
##### 1) URI는 정보의 자원을 표현해야 한다. (리소스명은 동사보다는 명사를 사용)
<pre><code>GET /members/delete/1</code></pre>

<br/>

- 위와 같은 방식은 REST를 제대로 적용하지 않은 URI이다. URI는 자원을 표현하는데 중점을 두어야 한다. delete와 같은 행위에 대한 표현이 들어가서는 안된다. <br/><br/>

<br/>

##### 2) 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE 등)로 표현
- 위의 잘못 된 URI를 HTTP Method를 통해 수정해 보면 아래와 같이 수정할 수 있다.
<pre><code>DELETE /members/1</code></pre>

<br/>

- 회원정보를 가져올 때는 GET, 회원 추가 시의 행위를 표현하고자 할 때는 POST METHOD를 사용하여 표현한다.

<br/>

##### 회원정보를 가져오는 URI
<pre><code>GET /members/show/1     (x)
GET /members/1          (o)</code></pre>

<br/>

##### 회원을 추가할 때
<pre><code>GET /members/insert/2 (x)  - GET 메서드는 리소스 생성에 적합하지 않다.
POST /members/2       (o)</code></pre>

<br/><br/>

### [참고]HTTP METHOD의 알맞은 역할
- POST, GET, PUT, DELETE 이 4가지의 Method를 가지고 CRUD를 할 수 있다. <br/><br/>

![image](https://user-images.githubusercontent.com/61584142/177568622-71e387e2-9d85-4b5d-9641-fdb825ebdd51.png)

<br/>

- 다음과 같은 식으로 URI는 자원을 표현하는 데에 집중하고 행위에 대한 정의는 HTTP METHOD를 통해 하는 것이 REST한 API를 설계하는 중심 규칙이다. <br/><br/>

<br/>

#### 2.4.4.2 URI 설계 시 주의할 점
##### 1) 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용
<pre><code>http://restapi.example.com/houses/apartments
http://restapi.example.com/animals/mammals/whales</code></pre>

<br/><br/>

##### 2) URI 마지막 문자로 슬래시(/)를 포함하지 않는다.
- URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 한다. REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 슬래시(/)를 사용하지 않는다. <br/><br/>
<pre><code>http://restapi.example.com/houses/apartments/ (X)
http://restapi.example.com/houses/apartments  (0)</code></pre>

<br/><br/>

##### 3) 하이픈(-)은 URI 가독성을 높이는데 사용
- URI를 쉽게 읽고 해석하기 위해, 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높일 수 있다. <br/><br/>

<br/>

##### 4) 밑줄( _ )은 URI에 사용하지 않는다.
- 글꼴에 따라 다르긴 하지만 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 한다. 이런 문제를 피하기 위해 밑줄 대신 하이픈(-)을 사용하는 것이 좋다.(가독성) <br/><br/>

<br/>

##### 5) URI 경로에는 소문자가 적합하다.
- URI 경로에 대문자 사용은 피하도록 해야 한다. 대소문자에 따라 다른 리소스로 인식하게 되기 때문이다. RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정하기 때문이다. <br/><br/>
<pre><code>RFC 3986 is the URI (Unified Resource Identifier) Syntax document</code></pre>

<br/><br/>

##### 6) 파일 확장자는 URI에 포함시키지 않는다.
<pre><code>http://restapi.example.com/members/soccer/345/photo.jpg (X)</code></pre>

<br/>

- REST API에서는 메시지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다. Accept header를 사용하도록 한다. <br/><br/>
<pre><code>GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg</code></pre>

<br/><br/>

## 2.4.4.3 리소스 간의 관계를 표현하는 방법
- REST 리소스 간에는 연관 관계가 있을 수 있고, 이런 경우 다음과 같은 표현방법으로 사용한다.
<pre><code>/리소스명/리소스 ID/관계가 있는 다른 리소스명

ex)    GET : /users/{userid}/devices (일반적으로 소유 ‘has’의 관계를 표현할 때)</code></pre>

<br/>

- 만약에 관계명이 복잡하다면 이를 서브 리소스에 명시적으로 표현하는 방법이 있다. 예를 들어 사용자가 ‘좋아하는’ 디바이스 목록을 표현해야 할 경우 다음과 같은 형태로 사용될 수 있다. <br/>
<pre><code>GET : /users/{userid}/likes/devices (관계명이 애매하거나 구체적 표현이 필요할 때)</code></pre>

<br/><br/>

## 2.4.4.4 자원을 표현하는 Colllection과 Document
- Collection과 Document에 대해 알면 URI 설계가 한 층 더 쉬워진다. DOCUMENT는 단순히 문서로 이해해도 되고, 한 객체라고 이해해도 된다. 컬렉션은 문서들의 집합, 객체들의 집합이라고 생각하시면 이해하시는데 좀더 편하다. 컬렉션과 도큐먼트는 모두 리소스라고 표현할 수 있으며 URI에 표현된다. <br/><br/>
<pre><code>http:// restapi.example.com/sports/soccer</code></pre>

<br/>

- 위 URI를 보면 sports라는 컬렉션과 soccer라는 도큐먼트로 표현되고 있다고 생각하면 된다. <br/><br/>
<pre><code>http:// restapi.example.com/sports/soccer/players/13</code></pre>

<br/>

- sports, players 컬렉션과 soccer, 13(13번인 선수)를 의미하는 도큐먼트로 URI가 이루어지게 된다. 여기서 중요한 점은 컬렉션은 복수로 사용하고 있다는 점이다. 좀 더 직관적인 REST API를 위해서는 컬렉션과 도큐먼트를 사용할 때 단수 복수도 지켜준다면 좀 더 이해하기 쉬운 URI를 설계할 수 있다. <br/><br/>

<br/><br/>

## 2.4.5 HTTP 응답 상태 코드
- 잘 설계된 REST API는 URI만 잘 설계된 것이 아닌 그 리소스에 대한 응답을 잘 내어주는 것까지 포함되어야 한다. 정확한 응답의 상태코드만으로도 많은 정보를 전달할 수 있기 때문에 응답의 상태코드 값을 명확히 돌려주는 것은 생각보다 중요한 일이 될 수도 있다. 혹시 200이나 4XX관련 특정 코드 정도만 사용하고 있다면 처리 상태에 대한 좀 더 명확한 상태코드 값을 사용하는 것을 권장한다. <br/><br/>

<br/>

![image](https://user-images.githubusercontent.com/61584142/177570506-21eb6f33-728a-4bfe-bbfa-dacdd70965cd.png)

<br/><br/><br/><br/>

---

<br/><br/><br/><br/>





3. Spring Boot
4. CURD API 만들어보기 (with lombok)
5. Mybatis - Database 연동, 리팩토링
6. Exception Handling

