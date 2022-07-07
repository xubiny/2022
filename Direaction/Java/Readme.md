# JDK 설치, 환경변수 설정, 이클립스 설치
## 1. Oracle 사이트에서 JDK 다운로드
- jdk-18_windows-x64.msi

<br/>

### 1-1. cmd > java -version
java version "18.0.1.1" 2022-04-22 <br/>
Java(TM) SE Runtime Environment (build 18.0.1.1+2-6) <br/>
Java HotSpot(TM) 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)

<br/><br/><br/><br/>

## 2. 환경변수 설정
- 제어판 > 시스템 및 보안 > 시스템 > 고급시스템 설정 > 환경변수

<br/>

### 2-1. 시스템 변수
JAVA_HOME 생성 <br/>
C:\Program Files\Java\jdk-18.0.1.1

<br/>

### 2-2. Path
시스템 변수 > Path 선택 > 편집 > 새로만들기 <br/>
%JAVA_HOME%\bin 입력 > '위로 이동' 버튼을 눌러 맨 위로 이동

<br/>

### 2-3. cmd > javac -version
javac 18.0.1.1

<br/><br/><br/><br/>

## 3. 이클립스(Eclipse) 설치
- https://www.eclipse.org/
- Eclopse IDE for Enterprise Java Developers 다운
- 경로 > C:\Dev\java-works

---

<br/><br/><br/><br/><br/><br/><br/><br/>

# Spring 설치

## 1. Eclipse에 Spring Plug-in 설치
- Help > Eclipse MarketPlace
- Spring Tool Suite
- Spring3 선택 (이전 버전 고려) > Spring Tool 3 (Standalone Edition) 3.9.14.RELEASE
- 위의 과정 실패 > Spring4 선택

<br/>

### Spring3 vs Spring4
a. Spring4에서는 @Controller + @ResponseBody의 조합인 @RestController를 도입했다. 따라서 @RestController를 사용할 때 @ResponseBody를 사용할 필요가 없다. <br/>
* Eclipse에 Spring Plug-in 설치를 하게 되면 무거워서 속도가 느릴 수 있음

<br/>

## 2. 상단바에 Spring 확인

---

<br/><br/><br/><br/><br/><br/><br/><br/>

# Tomcat 설치 및 이클립스 기본 설정 세팅

## 1. Tomcat 9 설치
- https://tomcat.apache.org/
- apache-tomcat-9.0.64
- zip 풀기

<br/>

## 2. Tomcat 이클립스 연동
- eclipse > Window > Preferences > Server에서 Runtime Environment에서 Add > Tomcat 버전 선택 > Browse 버튼을 눌러 앞서 압축해제한 Tomcat의 경로 지정

<br/>

## 3. UTF-8 설정
- 간혹 문자 인코딩 방식으로 인해 에러가 발생하기 때문에 문자 인코딩 방식을 모두 UTF-8로 설정해준다.
- Window > Preference > 검색창에 'encoding' 검색
- 검색되어 나오는 카테고리들의 문자열 인코딩 방식을 UTF-8로 변경

<br/>

## 4. Lombok 라이브러리 설치
- https://projectlombok.org/download
- lombok.jar 파일을 실행하고 IDE의 위치를 못찾으면 Specify location을 눌러 경로 지정 > eclipse.exe 위치로 설정 > install

<br/>

## 5. Lombok 확인
- eclipse.exe 하단에 lombok이 추가된 것을 확인할 수 있다.

---

<br/><br/><br/><br/><br/><br/><br/><br/>

# MySQL 설치

## 1. MySQL 설치하기
- https://dev.mysql.com/downloads/
- MySQL Installer for Windows
- 용량이 더 큰 파일로 다운 > 용량이 작은 첫 번째는 웹설치용

<br/>

## 2. MySQL Installer 실행
- 전부 설치
- pw : zhrmsptskdls2022@

---

<br/><br/><br/><br/><br/><br/><br/><br/>

# 스프링부트 프로젝트 생성 및 실행

## 1. 스프링 프로젝트 생성
- New > Spring Starter Project 선택
- Java Version은 8로 맞춘다.
- 스프링부트 버전 선택 및 필요한 의존성 패키지를 추가할 수 있다.
- 필요한 의존성 패키지는 검색하여 추가
- Spring Boot DevTools, Lombok, MyBatis Framework, MySQL Driver, Spring Security, Spring Web, Spring Web Services

<br/>

## 2. root path, Port 및 DataSource 설정
- Spring Boot에서는 application.properties에서 root path와 Port를 설정한다.

<br/>

### Web ContextRootPath and PortNumber Settings
<pre><code>server.servlet.context-path=/home
server.port=8080</code></pre>

<br/>

#### application.properties에 'datasource'를 키워드로 하면 작성할 내용들이 뜬다. (Ctrl+Space)

<br/>

### Data Source
<pre><code>spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=mysql://localhost:3306/
spring.datasource.username=root
spring.datasource.password=</code></pre>

<br/>

## 3. 의존성 추가
- 필요한 의존성이 있다면 https://mvnrepository.com/ 에서 찾아 추가한다.
- 스프링부트에서는 별도의 JSP 컴파일을 지원하지 않으므로 pom.xml에서 dependencies 태그 안에 추가한다. (스프링부트에서는 JSP보다는 Thymeleaf를 쓸 것을 권장한다.)

<br/>

### JSP를 사용하기 위해서는 jstl과 jasper를 의존성에 추가해야 한다.
<pre><code><dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<scope>provided</scope>
</dependency>

<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
</dependency></code></pre>

- JSP에 찾아 들어갈 수 있도록 application.properties에 prefix와 suffix 경로를 설정해준다.

<br/>

### JSP
<pre><code>spring.mvc.view.prefix=/WEB-INF/jsp
spring.mvc.view.suffix=.jsp</code></pre>

<br/>

## 4. 프로젝트 실행
- Run As에서 Spring Boot App을 눌러 실행
