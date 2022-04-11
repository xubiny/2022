# SQL 기본
## RDBMS
- 관계형 DBMS인 RDBMS(Relational DataBase Management System)는 데이터를 효율적으로 관리하기 위한 데이터베이스 관리 시스템, 즉 컴퓨터 프로그램이다.

<br/><br/>

## RDBMS 특징
### 데이터 중복 최소화
- 테이블에 데이터를 저장해 데이터의 중복 저장을 최소화함
### SQL을 이용한 처리
- SQL로 데이터를 손쉽게 처리함
### 트랜잭션 처리
- 트랜잭션 처리로 오류 발생 시 오류 데이터가 저장되지 않음
### 데이터 무결성 보장
- 데이터의 정확성을 보장함

<br/><br/>

## 데이터 관리 유형
### 데이터 저장 관점
- 필요한 데이터만 적재적소에 저장해 두는 것이 효율적이다.
### 데이터 조회 관점
- 원하는 데이터를 손쉽게 찾아볼 수 있어야 한다.
### 데이터 수정 관점
- 특정 데이터만 골라내 원하는 값으로 수정할 수 있어야 한다.
### 데이터 삭제 관점
- 원하는 데이터만 골라내 지울 수 있어야 한다.

<br/><br/>

## RDBMS의 종류
- 오라클, MySQL, SQL Server, PostgreSQL, DB2, MariaDB 등이 있다.

<br/><br/>

## RDBMS 관련 용어
### 테이블
- 우리가 흔히 말하는 표이다. 가로와 세로, 즉 열(컬럼)과 행(로우)으로 구성되어 있다.
### 컬럼
- 테이블을 구성하는 데이터의 속성이다. 이런 컬럼들이 모여 하나의 테이블을 구성한다.
### 로우
- 지정된 컬럼 데이터로 이루어진 하나의 묶음이다.

<br/><br/>

## RDBMS 단점
- 컬럼과 관련된 것인데, 테이블 생성 시 컬럼의 유형을 정의하면 나중에 변경할 때 문제 발생 소지가 많다는 점이다. 예를 들어 처음에는 회원정보와 관련된 데이터만 넣으려고 했는데, 주변 여건이 변하여 기존 컬럼을 삭제하거나 새로운 컬럼을 추가해야 하는 상황이 생길 수 있다. 물론 불가능한 일은 아니며 쉽게 해결할 수 있지만, 컬럼 변경으로 인해 기존에 이 테이블을 사용했던 프로그램을 모두 수정해야 한다는 번거로움이 생긴다.

<br/>

- 또한, 요즘처럼 SNS를 통해 다양하고 변화무쌍한 유형의 데이터가 만들어지는 환경에서 하나의 컬럼에 다양한 유형의 데이터를 넣을 수 없다는 비판도 있다. 실제로 이는 불가능하다. 이는 1970년대 소개된 RDBMS가 21세기도 십여 년이 훌쩍 넘은 현재의 여러 유형의 데이터까지 동적으로 처리하도록 설계되지 않았기 때문이다. 현재 SNS로 만들어지는 데이터는 NoSQL 개념의 DBMS가 처리하고 있다. DBMS를 사용하는 기업 입장에서는 추가 비용이 들겠지만, 이런 문제는 데이터의 유형, 쓰임새, 목적에 맞는 DBMS를 사용해 해결하는 것이 현재로서는 바람직하다.

<br/><br/>

## RDBMS의 가장 큰 특징인 관계
- 데이터 성격에 맞게 테이블을 여러 개로 분리하고, 분리한 테이블 간에 연결고리 역할을 하는 컬럼을 두어 이 컬럼을 이용해 관계를 맺는 것을 말한다.

<br/><br/>

## 데이터베이스 모델링
- 데이터 성격에 맞게 테이블을 여러 개 만들고 이들 간의 관계를 결정하는 것
- 모델링은 정답이 없으며 구축하려는 데이터베이스 시스템의 성격에 따라 달라진다. 또한, 별도의 모델링 이론도 학습해야 한다.

<br/><br/>

## 키(Key) 컬럼
- RDBMS에서는 데이터 무결성을 확보하고자 테이블에 반드시 하나의 키가 되는 컬럼을 두도록 권고하고 있다. 데이터 무결성은 한 마디로 데이터의 정확성을 보장해 올바른 데이터를 유지하는 것을 의미한다.

<br/>

### 기본 키(Primary Key)
- 테이블에서 특정 로우 데이터를 식별할 수 있는 값을 가진 컬럼
- 한 테이블 전체로 보면 기본 키 컬럼에는 유일한(unique)한 값이 들어간다.

<br/>

- 키는 특정 데이터를 수정하거나 삭제할 때 사용한다.

<br/>

- 한 테이블에서 유일한 식별자 역할을 하는 키는 테이블 간 관계를 맺을 때도 사용된다. 
- 즉, 한 테이블에서 유일하게 로우를 식별하는 키를 기본 키, 다른 테이블의 기본 키와 연결고리가 되는 키를 참조 키라고 한다.

<br/><br/>

## 트랜잭션 처리
- 트랜잭션은 거래라는 뜻이다.
- RDBMS에서 한 테이블에 있는 특정 데이터를 삭제한 후 연이어 새로운 데이터를 입력한다고 가정하자. 삭제하고 입력할 때 장애가 발생해 입력 작업만 이루어졌다면 제대로 처리된 것이 아니다. 그래서 최종 입력 작업이 완료되기 전에 오류가 발생하면 작업 전 상태로 되돌리고, 입력 작업이 정상적으로 끝난 후에 모든 변경 내용을 최종 적용한다.
- RDBMS에서 트랜잭션 처리는 원자성, 일관성, 고립성, 지속성 이렇게 네 가지 요소로 구성된다.

<br/><br/>

## MySQL의 데이터베이스 객체 구조
- MySQL 서버 -> 데이터베이스 또는 스키마 -> 테이블을 포함한 데이터베이스 객체 순으로 구성된다.

<br/><br/>

## SQL
- SQL(Structured Query Language, 구조적 질의 언어)은 배우기 쉽고 데이터 조작 작업도 쉽게 처리할 수 있다. 표준이 있어서 RDBMS 종류와 상관없이 사용할 수 있으나 제품별로 조금씩 다른 부분이 있다.
- SQL은 데이터베이스를 상대로 데이터를 조회, 입력, 수정, 삭제하기 위해 사용하는데, 이 모든 것이 질의에 속한다.

<br/>

- 또한, SQL은 집합적 언어이다. SQL의 상대는 데이터이고, 데이터는 테이블에 저장되어 있다. 테이블은 특정 목적과 성격에 맞는 데이터를 모아 놓은 데이터 저장소이다. SQL은 임의의 조건에 부합한다면 이를 충족하는 데이터 전체를 읽거나 삭제하거나 수정하거나 입력하는 기능을 수행한다. 즉, 데이터를 한 건씩 처리하는 게 아니라 조건에 맞는 데이터 전체를 한 번에 처리하기 때문에 SQL을 집합적 언어라고 한다.

<br/><br/>

## MariaDB
- MySQL과 자매관계인 RDBMS로, MySQL의 많은 기능을 그대로 사용할 수 있다.

<br/><br/>

## SQL의 종류
### DDL(데이터정의어)
- 데이터베이스 객체의 생성, 수정, 삭제 시 사용
    - CREATE : 객체 생성
    - ALTER : 객체 수정
    - DROP : 객체 삭제
    - TRUNCATE TABLE : 테이블의 데이터 전체 삭제
    - RENAME TABLE : 테이블 이름 변경

<br/>

### DML(데이터조작어)
- 데이터 조작 작업시 사용
    - SELECT : 데이터 조회
    - INSERT : 데이터 신규 입력
    - UPDATE : 데이터 수정
    - DELETE : 데이터 삭제

<br/>

### TCL(트랜잭션제어어)
- 트랜잭션 처리시 사용
    - COMMIT : 데이터 변경사항 적용
    - ROLLBACK : 데이터 변경사항 취소
    - START TRANSACTION : 트랜잭션 시작
    - SAVEPOINT : 명시적으로 트랜잭션 이름 부여
    - SET autocommit : 자동 커밋 모드 설정

<br/>

### DCL(데이터제어어)
- 특정 사용자에게 데이터나 각종 작업에 대한 권한 부여 및 회수시 사용
    - GRANT : 권한 부여
    - REVOKE : 권한 회수

<br/><br/>

![image](https://user-images.githubusercontent.com/61584142/160228525-4e7b6c6b-5ebe-4306-aa16-8e2ea18959c5.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 실습 환경 구축
## MySQL 설치 프로그램
### MySQL Server
- MySQL 서버프로그램
### MySQL Workbench
- SQL문을 작성하고 실행해 결과를 보는 프로그램
### Samples and Examples
- 예제 데이터베이스, 테이블 및 데이터

<br/><br/>

## 사용자 계정
- MySQL에 접속하려면 사용자 계정이 필요한데, MySQL 설치 시 관리자 계정인 root 계쩡이 자동으로 만들어진다. root 계정의 비밀번호는 MySQL을 설치할 때 설정해야 하며, 새로운 사용자를 추가할 수 있다.

<br/><br/>

## MySQL 접속 방법
- 명령 프롬프트에서 명령어를 입력해 접속하는 방법과 MySQL Workbench 프로그램으로 간단하게 접속하는 방법이 있다.

<br/><br/>

## MySQL Workbench
- MySQL에 접속해 SQL 문을 작성하고 그 실행결과를 한 화면으로 볼 수 있는 GUI 프로그램이다.

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 테이블 살펴보기
## 테이블(table)
- RDBMS에서 데이터를 저장하는 데 사용하는 객체로, 로우와 컬럼으로 구성되어 있다.

<br/><br/>

## 컬럼과 로우
- 테이블은 여러 개의 컬럼(column)으로 이뤄지는데, 컬럼은 데이터의 속성을 나타내고 컬럼 값들이 모여 하나의 로우(row)를 구성한다.

<br/><br/>

## 중복 데이터 저장 최소화
- 관리하려는 데이터의 성격에 따라 테이블을 만들고, 원하는 정보를 추출할 떄는 테이블을 연결해 데이터를 가져옴으로써 중복 데이터가 저장되는 것을 최소화할 수 있다.

<br/><br/>

## 테이블 정의
- 컬럼을 정의하는 것으로, 컬럼을 정의할 때는 컬럼명과 데이터 타입을 명시해야 한다.

<br/><br/>

## 데이터 타입
- 컬럼에 저장될 데이터의 유형으로, MySQL에서 제공하는 데이터 타입은 크게 문자형, 숫자형, 날짜형으로 나뉜다. 숫자형을 정의할 때 UNSIGNED 옵션을 붙이면 0과 0보다 큰 수만 입력할 수 있다. MySQL의 대표적인 데이터 타입은 다음과 같다.

<br/>

### 문자형
#### VARCHAR(n)
- 가변 길이, `n <= 65,535`

<br/>

### 숫자형
#### INT
- 정수, `-2,147,483,648~2,147,483,647 | Unsinged 0~4,294,967,295`

<br/>

### 숫자형
#### DECIMAL[(M,D)]
- 실수, `소수점 포함 최대 65자리 숫자`

<br/>

### 날짜형
#### DATETIME[fsp]
- 날짜와 시간, `1000-01-01 00:00:00.000000 ~ 9999-12-31 11:59:59.999999`

<br/><br/>

## 예제 테이블
- MySQL을 설치하면 sakila와 world 데이터베이스에 예제 테이블이 만들어진다. sys 데이터베이스에는 MySQL을 관리하는 용도의 데이터베이스 객체들이 들어 있다.

<br/><br/>

![image](https://user-images.githubusercontent.com/61584142/160229240-249fd8f4-4717-4699-b616-eb117866deb2.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터베이스와 테이블 생성하기
## 데이터베이스 생성
- MySQL에서 테이블을 비롯한 각종 데이터베이스 객체는 데이터베이스 안에 들어 있으며, DDL인 CREATE(CREATE DATABASE 또는 CREATE SCHEMA) 문으로 데이터베이스를 생성한다.

<br/><br/>

## 테이블 생성
- DDL인 CREATE(CREATE TABLE) 문으로 테이블을 생성한다.


<br/>

<pre><code>CREATE TABLE emp03 
(
   emp_id      NUMBER         NOT NULL,
   emp_name    VARCHAR2(100)  NOT NULL,
   gender      VARCHAR2(10)       NULL, 
   age         NUMBER             NULL,
   hire_date   DATE               NULL,
   etc         VARCHAR2(300)      NULL,
   PRIMARY KEY ( emp_id )
);</code></pre>

<br/><br/>

## 테이블 생성 시 주의사항
### 테이블명, 컬럼명
- 최대 64글자
- 같은 데이터베이스에서 유일한 이름 사용

<br/>

### 명명 규칙
- 0-9, 영문자, 한글, $, _ (언더스코어)
- 예약어 사용 불가
- Windows에서는 대소문자 구분 없음

<br/>

### 컬럼 개수
- 최대 4,096개까지 생성 가능

<br/>

### 컬럼명
- 한 테이블에서 같은 컬럼명 사용 불가

<br/><br/>

## 데이터 입력
- SQL, 특히 DML 문장 중에서 데이터 입력 기능을 하는 것은 INSERT문 뿐이다.

<br/>

<pre><code>INSERT INTO 테이블 명 ( column1, column2, column3, … )
VALUES ( 값1, 값2, … );</code></pre>
<pre><code>INSERT INTO emp03 ( emp_id, emp_name, gender, age, hire_date )
VALUES ( 1, '홍길동', '남성', 33, '2018-01-01' );

INSERT INTO emp03 ( emp_id, emp_name, gender, age, hire_date )
VALUES ( 2, ‘김유신’, ‘남성’, 44, ‘2018-01-01’ );

INSERT INTO emp03 ( emp_id, emp_name, gender, age, hire_date )
VALUES ( 3, ‘강감찬’, ‘남성’, 55, ‘2018-01-01’ );

INSERT INTO emp03 ( emp_id, emp_name, gender, age, hire_date )
VALUES ( 4, ‘신사임당’, ‘남성’, 45, ‘2018-01-01’ );</code></pre>

<br/>

<pre><code>SELECT *
FROM emp03;</code></pre>

<br/>

### COMMIT을 실행해 입력한 데이터 반영
<pre><code>COMMIT;</code></pre>

<br/><br/>

## 데이터 삭제
- DELETE 다음에 데이터를 삭제할 대상 테이블 명을 명시하고, 해당 테이블에서 어떤 데이터를 지울 것인지 WHERE 절에 명시한다.

<br/>

<pre><code>DELETE [FROM] 테이블 명
WHERE 조건</code></pre>
<pre><code>DELETE FROM emp03
WHERE emp_id = 4;</code></pre>
<pre><code>SELECT *
FROM emp03;</code></pre>

<br/>

### ROLLBACK 문을 실행해 DELETE 전 상태로 복귀
<pre><code>ROLLBACK;</code></pre>
<pre><code>SELECT *
FROM emp03;</code></pre>

<br/><br/>

## 테이블 삭제
- DDL인 DROP(DROP TABLE) 문으로 테이블을 삭제한다.

<br/><br/>

## NULL 처리
1. NULL은 컬럼의 제약조건으로, 데이터가 없음을 의미한다.
2. NULL을 명시하거나 생략하면 해당 컬럼에는 데이터를 입력해도 되고 입력하지 않아도 된다.
3. NOT NULL을 명시하면 해당 컬럼에는 반드시 데이터를 입력해야 하고, 입력하지 않으면 오류가 발생하며 입력 작업이 취소된다.

<br/><br/>

## 기본 키
1. 한 테이블에서 유일한 값이 입력될 컬럼을 기본 키로 생성할 수 있다.
2. 테이블 설계를 어떻게 하는가에 따라 기본 키는 한 개 이상의 컬럼으로 만들 수 있다.
3. 한 테이블에서 기본 키는 1개만 만들 수 있다.
4. 기본 키를 생성할 컬럼에는 NOT NULL 옵션을 적용한다.

<br/><br/>

## 기본 키 생성과 삭제, 수정
### 기본 키 생성 1
- 컬럼명 데이터 타입 NOT NULL PRIMARY KEY

<br/>

### 기본 키 생성 2
- PRIMARY KEY (컬럼1, 컬럼2, ...)
- CONSTRAINT 기본키명 PRIMARY KEY (컬럼1, 컬럼2, ...)

<br/>

### 기본 키 생성 3
- ALTER TABLE 테이블명
- ADD PRIMARY KEY (컬럼1, 컬럼2, ...);

<br/>

### 기본 키 삭제
- ALTER TABLE 테이블명
- DROP PRIMARY KEY;

<br/>

### 기본 키 수정(기본 키 삭제 후 재생성)
- ALTER TABLE 테이블명 DROP PRIMARY KEY;
- ALTER TABLE 테이블명 ADD PRIMARY KEY (컬럼1, 컬럼2, ...);

<br/><br/>

## 테이블 삭제
- 테이블을 삭제하면 테이블에 있는 데이터는 물론 기본 키를 포함해 테이블과 관련된 각종 제약조건도 모두 삭제된다.

<br/><br/>

![image](https://user-images.githubusercontent.com/61584142/160229554-50af6224-5571-4bb8-b28b-6559f3021412.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 조회하고 정렬하기
## subway_statistics 테이블 생성
<pre><code>CREATE TABLE subway_statistics (
     seq_id            NUMBER        NOT NULL,
     station_name      VARCHAR2(100)     NULL,
     boarding_date     DATE              NULL,
     gubun             VARCHAR2(10)      NULL,
     boarding_time     NUMBER            NULL,
     passenger_number  NUMBER            NULL,
     PRIMARY KEY ( seq_id )
);</code></pre>

<br/><br/>

## subway_statistics 테이블 데이터 입력 INSERT 문
<pre><code>INSERT INTO subway_statistics VALUES ( 1,‘서울역(150)’,‘2017-04-01’,‘승차’,7,654 );
INSERT INTO subway_statistics VALUES ( 2,‘서울역(150)’,‘2017-04-01’,‘하차’,7,1923 );
INSERT INTO subway_statistics VALUES ( 3,‘서울역(150)’,‘2017-04-02’,‘승차’,7,413 );
INSERT INTO subway_statistics VALUES ( 4,‘서울역(150)’,‘2017-04-02’,‘하차’,7,1119 );
INSERT INTO subway_statistics VALUES ( 5,‘서울역(150)’,‘2017-04-03’,‘승차’,7,2137 );</code></pre>

<br/><br/>

## 데이터 조회하기
1. 테이블에 있는 데이터를 조회할 때는 DML중 하나인 SELECT문을 사용한다.
2. SELECT 문은 SELECT, FROM, WHERE, ORDER BY, LIMIT 절로 구성된다.
3. SELECT 절에는 조회하려는 컬럼을 명시하는데, 조회하려는 컬럼이 여러 개일 때는 ,(콤마)로 구분하고, 모든 컬럼을 조회하려면 * (스타)를 명시한다.
4. FROM 절에는 조회하고자 하는 테이블명을 넣는다.

<br/>

<pre><code>SELECT column1, column2, …
FROM 테이블 명
WHERE 조건
ORDER BY 정렬 순서;</code></pre>

<br/>

### subway_statistics 테이블 조회
<pre><code>SELECT *
  FROM subway_statistics;</code></pre>

<br/>

### 특정 컬럼만 조회
<pre><code>SELECT seq_id
      ,station_name
      ,boarding_time
      ,passenger_number
 FROM subway_statistics;</code></pre>

<br/><br/>

## 조건에 맞는 데이터 조회하기
1. 테이블에서 특정 데이터만 선별해 조회하려면 WHERE 절을 기술한다. WHERE 다음에 적절한 조건을 기술하는데, 이를 조회 조건이라 한다.
2. 조회 조건은 주로 컬럼과 연산자, 비교 값으로 구성되고, 조회 조건을 만족하는 건만 조회된다.
3. 조회 조건을 만족한다는 것은 조건 결괏값이 참(TRUE)임을 의미한다.
4. 조회 조건에서 사용되는 비교 연산자는 해당 연산자의 좌우 값을 비교해 그 결과가 참(TRUE)인 건을 조회한다.
5. 조회 조건에서 자주 사용되는 비교 연산자로는 `=, <>(혹은 !=), <, <=, >, >=. BETWEEN...AND, IN, LIKE` 등이 있다.
6. WHERE 절에 여러 개의 조회 조건을 기술할 수 있는데, 각 조건은 논리 연산자인 AND나 OR로 연결한다.
7. 두 개의 조회 조건이 AND 연산자로 연결되면 두 조건을 모두 만족하는 데이터만 조회된다.
8. 두 개의 조회 조건이 OR 연산자로 연결되면 두 조건 중 하나라도 만족하는 데이터는 모두 조회된다.

<br/>

### 지하철역명이 '잠실(216)'인 건 조회
<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name = ‘잠실(216)’;</code></pre>
 
<br/>

### 잠실역에서 7시나 9시에 승하차한 건을 조회
<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name = '잠실(216)'
   AND boarding_time = 7
    OR boarding_time = 9;</code></pre>

<br/>

### 잠실역에서 7시나 9시에 승하차한 건을 조회하는 올바른 쿼리
<pre><code>SELECT *
  FROM subway_statistics
WHERE station_name = '잠실(216)'
  AND ( boarding_time = 7
        OR boarding_time = 9 );</code></pre>
 
<br/>

### LIKE 연산자 사용
<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name LIKE ‘잠실%’;</code></pre>
 
<br/>

### 선릉역에서 7시와 9시 승하차 건을 조회(Like, In)
<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name LIKE '선릉%'
   AND boarding_time IN (7, 9);</code></pre>
   
<br/>

### 선릉역에서 승하차 인원이 500 ~ 1000명인 건을 조회
```
SELECT *
  FROM subway_statistics
 WHERE station_name LIKE '선릉%'
   AND passenger_number >= 500
   AND passenger_number <= 1000;
```

<br/>

### BETWEEN 연산자 사용

<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name LIKE '선릉%'
   AND passenger_number BETWEEN 500 AND 1000;</code></pre>

<br/><br/>

## 데이터 정렬하기
1. 데이터를 정렬해 조회하려면 ORDER BY 절을 사용한다.
2. ORDER BY 다음에 정렬하려는 컬럼을 명시하면 해당 컬럼 값을 기준으로 오름차순 또는 내림차순으로 정렬된다.
3. 오름차순으로 정렬할 때는 컬럼명 다음에 ASC를 명시해도 되고 생략해도 된다.
4. 내림차순으로 정렬할 때는 컬럼명 다음에 DESC를 명시하며 생략할 수 없다.
5. ORDER BY 다음에 여러 개의 컬럼을 명시할 수 있는데, 명시한 순서대로 정렬된다.
6. ORDER BY 다음에 컬럼명이 아닌 숫자를 넣을 수도 있는데, 이 숫자는 SELECT 절에 기술한 컬럼의 순번을 뜻한다.
7. 만약 SELECT 절에 명시한 컬럼의 순번을 벗어난 숫자를 ORDER BY 절에 넣으면 오류가 발생한다.

<br/>

### 지하철역명으로 정렬

<pre><code>SELECT *
  FROM subway_statistics
 ORDER BY station_name;</code></pre>

<br/>

### 모든 컬럼 정렬

<pre><code>SELECT *
  FROM subway_statistics
 WHERE station_name LIKE '선릉%'
 ORDER BY 1, 2, 3, 4, 5, 6;</code></pre>

<br/><br/>

## 데이터 조회 개수 제한하기
1. 조회되는 데이터의 건수(로우 수)를 제한할 때는 LIMIT 절을 사용하고, LIMIT 다음에 명시한 숫자만큼만 조회된다.
2. ORDER BY 절과 LIMIT 절을 사용하면 ORDER BY 절에 기술한 컬럼 값을 기준으로 상위 또는 하위 몇 건만 조회할 수 있다.

<br/><br/>

## 전체 구문 형식
```
SELECT *
  FROM 테이블
 WHERE 조회 조건
 ORDER BY 칼럼1 [ASC|DESC], 칼럼2 [ASC|DESC]
 LIMIT n;
```

<br/><br/>

![AA](https://user-images.githubusercontent.com/61584142/160229860-eb9f85c5-58e5-44a3-b812-f66299ef224d.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 반복적인 계산을 편리하게: SQL 함수 사용하기
## SQL 함수
1. SQL 함수는 자주 사용되는 특정 연산을 수행하는 객체로, MySQL에서 제공하며 SQL 문장에서 사용할 수 있다.
2. SQL 함수는 매개변수를 입력받아 연산이나 계산을 수행하고 결괏값을 반환한다.

<br/><br/>

## 기본 SQL 함수
1. SQL 함수로는 문자형 숫자형, 날짜형, 형 변환, 흐름 제어 함수가 있다.
2. 함수의 매개변수와 반환값이 문자나 문자열인 함수들을 문자형 함수라고 한다.
3. 함수의 매개변수와 반환값이 숫자인 함수들을 숫자형 함수라고 한다.
4. 함수의 매개변수와 반환값이 날짜인 함수들을 날짜형 함수라고 한다.
5. 함수에 따라 문자형 함수에 속하지만, 숫자 값을 반환하는 것도 있고, 날짜형 함수지만 숫자나 문자 값을 반환하는 함수도 있다.

<br/>

### ROUND 함수
<pre><code>SELECT ROUND( 565.545, -1 ) first
      ,ROUND( 565.545, -2 ) second
      ,ROUND( 565.545, -3 ) third
  FROM DUAL;</code></pre>
  
<br/>

### SUBSTR 함수
<pre><code>SELECT SUBSTR( 'ABCDEFG', 1, 3 )   first
      ,SUBSTR( 'ABCDEFG', 0, 3 )   second
      ,SUBSTR( 'ABCDEFG', 1 )      third
      ,SUBSTR( 'ABCDEFG', -2 )     fourth
      ,SUBSTR( 'ABCDEFG', -2, 1 )  fifth
      ,SUBSTR( 'ABCDEFG', 2, -1 )  sixth
  FROM DUAL;</code></pre>

<br/>

### INSTR 함수
<pre><code>SELECT INSTR( 'ABABAB', 'A' )       first
      ,INSTR( 'ABABAB', 'A', 2 )    second
      ,INSTR( 'ABABAB', 'A', 2, 1 ) third
      ,INSTR( 'ABABAB', 'A', 2, 2 ) fourth
  FROM DUAL ;</code></pre>

<br/>

### TO_CHAR 함수 사용 예
<pre><code>SELECT TO_CHAR( SYSDATE, ‘YYYY-MM-DD HH24:MI:SS’ )
  FROM DUAL;</code></pre>

<br/>

### 명시적 형변환
<pre><code>INSERT INTO emp03 ( emp_id, emp_name, gender, age, hire_date )
VALUES ( 1, ‘홍길동’, ‘남성’, 33, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’) );</code></pre>

<br/><br/>

## 기타 함수
1. 형 변환 함수는 매개변수로 입력되는 값의 데이터 타입을 변환한 결과를 반환하는 함수로, CAST()와 CONVERT() 함수가 있다.
2. 흐름 제어 함수는 임의의 조건을 확인해 그 결과에 따라 각기 다른 값을 반환하는 함수로, IF, IFNULL(), NULLIF() 함수가 있다.
3. CASE 연산자는 함수는 아니지만, 특정 조건을 명시하고 그 조건을 확인해 원하는 값을 반환할 수 있으며, 두 가지 형태의 구문을 제공한다.
4. 함수는 연산 결과를 반환하므로 함수 자체가 다른 함수의 매개변수로 사용될 수 있다.

<br/>

### NULL 관련 함수
<pre><code>SELECT NVL( NULL, 'N/A' )
      ,NVL2( 1, 2, 3 ) 
      ,COALESCE( NULL, NULL, 5, 4, NULL )
      ,NULLIF( 'NULL', 'null' ) 
  FROM DUAL;</code></pre>

<br/>

### 검색형 CASE 표현식

<pre><code>SELECT emp_name
      ,age
      ,CASE WHEN age BETWEEN 0  AND 19 THEN ‘10대’
            WHEN age BETWEEN 20 AND 29 THEN ‘20대’
            WHEN age BETWEEN 30 AND 39 THEN ‘30대’
            WHEN age BETWEEN 40 AND 49 THEN ‘40대’
            WHEN age BETWEEN 50 AND 59 THEN ‘50대’
            ELSE ‘60대 이상’
       END ages
  FROM EMP03;</code></pre>

<br/><br/>

![SS](https://user-images.githubusercontent.com/61584142/160230228-2e011707-2363-4e6b-863f-9f9d48a00ce4.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 집계하기: 집계 쿼리
## 데이터 그룹화와 집계 함수
1. 집계 쿼리는 GROUP BY 절과 집계 함수로 구성된다.
2. GROUP BY 절은 WHERE 절과 ORDER BY 절 사이에 위치하며, GROUP BY 다음에 컬럼이나 표현식 또는 SELECT 절에 기술한 컬럼(표현식)의 순번을 명시할 수 있다.
3. GROUP BY 절에 기술한 컬럼(표현식)별로 데이터가 그룹화되며 해당 컬럼(표현식)이 반환하는 값 중 중복 값을 제외한 고윳값이 조회된다.
4. 집계 쿼리의 구성 요소는 아니지만, SELECT 절에 DISTINCT를 사용하면 DISTINCT 다음에 명시한 컬럼이나 표현식의 고윳값만 조회할 수 있다.
5. 집계 함수는 총 건수, 최댓값, 최솟값, 평균, 합계 등을 계산해 반환하는 함수로, COUNT(), MAX(), MIN(), AVG(), SUM() 등이 있다.
6. GROUP BY 절이나 집계 함수는 단독으로 사용할 수 있지만, 같이 사용해야 좀 더 의미있는 결과를 얻을 수 있다.
7. GROUP BY 절과 집계 함수를 같이 사용하면 GROUP BY 절에 명시한 항목별로 집계 함수를 사용해 집계한 결괏값이 조회된다.

<br/>

### GROUP BY 절
<pre><code>SELECT station_name
  FROM subway_statistics
 WHERE gubun = ‘승차’
 GROUP BY station_name
 ORDER BY station_name;</code></pre>
 
<br/>

### 집계 함수
<pre><code>SELECT COUNT(*) cnt 
      ,MIN(passenger_number) min_value
      ,MAX(passenger_number) max_value
      ,SUM(passenger_number) sum_value
      ,AVG(passenger_number) avg_value
FROM subway_statistics;</code></pre>

<br/>

### 지하철역별 승차 인원 통계
<pre><code>SELECT station_name
      ,COUNT(*) cnt 
      ,MIN(passenger_number) min_value
      ,MAX(passenger_number) max_value
      ,SUM(passenger_number) sum_value
      ,AVG(passenger_number) avg_value
  FROM subway_statistics
 WHERE gubun = '승차'
 GROUP BY station_name
 ORDER BY station_name;</code></pre>

<br/>

### 구로디지털단지역 시간별 승하차 인원 조회
<pre><code>SELECT station_name
      ,boarding_time
      ,gubun
      ,MIN(passenger_number) min_value
      ,MAX(passenger_number) max_value
      ,SUM(passenger_number) sum_value
  FROM subway_statistics
 WHERE station_name in ('구로디지털단지(232)')
 GROUP BY station_name, boarding_time, gubun
 ORDER BY station_name, boarding_time, gubun;</code></pre>

<br/>

### 승하차 인원이 많은 순서로 조회
<pre><code>SELECT station_name
      ,boarding_time
      ,gubun       
      ,MIN(passenger_number) min_value
      ,MAX(passenger_number) max_value
      ,SUM(passenger_number) sum_value
  FROM subway_statistics
 GROUP BY station_name, boarding_time, gubun
 ORDER BY 6 DESC;</code></pre>
 
<br/><br/>

## 총계 산출과 HAVING 절
1. GROUP BY 절에 WITH ROLLUP 구문을 사용하면 추가로 항목별 소계와 총계를 구할 수 있다.
2. WITH ROLLUP 구문으로 계산된 소계와 총계의 항목 값은 NULL로 조회된다.
3. 항목 값 자체에 NULL이 포함되며 WITH ROLLUP으로 계산된 소계나 총계의 항목값으로 나온 NULL과 구분하기 쉽지 않은데, 이떄는 GROUPING() 함수를 사용한다.
4. WITH ROLLUP 구문이 있는 집계 쿼리에서 SELECT 절에 사용한 GROUPING() 함수는 소계나 총계로 계산된 로우의 항목 값을 1로, 일반 항목 값을 0으로 반환한다.
5. 집계 함수의 결괏값을 기준으로 조회 조건을 줄 때는 WHERE 절이 아닌 HAVING 절에 기술해야 한다.
6. HAVING 절은 GROUP BY 절 다음에 위치하며 집계 함수나 GROUPING() 함수를 명시하면 해당 함수의 결괏값을 조건으로 줄 수 있다.

<br/>

### HAVING 절
<pre><code>SELECT station_name
      ,boarding_time
      ,gubun

      ,MIN(passenger_number) min_value
      ,MAX(passenger_number) max_value
      ,SUM(passenger_number) sum_value
  FROM subway_statistics
 GROUP BY station_name, boarding_time, gubun
 HAVING SUM(passenger_number) BETWEEN 15000 AND 16000
 ORDER BY 6 DESC;</code></pre>

<br/>

### DISTINCT 사용
<pre><code>SELECT DISTINCT station_name
  FROM subway_statistics
 WHERE gubun = '승차'
 ORDER BY 1;</code></pre>
 
<br/><br/>

![DS](https://user-images.githubusercontent.com/61584142/160230478-d4ed1e5e-106b-4f3d-a30f-bb73e7d13184.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 테이블끼리 관계 맺기: 조인
## 조인
1. 테이블을 연결해 데이터를 조회하는 것을 조인(join)이라고 한다.
2. 조인 테이블 각각에 같은 값을 가진 조인 컬럼이 있어야 조인할 수 있다.

<br/>

### emp_master 테이블 생성

<pre><code>CREATE TABLE emp_master
(
  emp_id     NUMBER        NOT NULL, – 사원번호
  emp_name   VARCHAR2(100) NOT NULL, – 사원 명
  gender     VARCHAR2(10),           – 성별
  age        NUMBER,                 – 나이
  hire_date  DATE,                   – 입사일자
  dept_id    NUMBER,                 – 부서아이디
  address_id NUMBER,                 – 주소아이디
  CONSTRAINT emp_master_pk PRIMARY KEY (emp_id)
);


CREATE TABLE dept_master (
  dept_id    NUMBER NOT NULL,         – 부서아이디
  dept_name  VARCHAR2(50),            – 부서 명
  use_yn     VARCHAR2(2) DEFAULT ‘Y’, – 사용여부
  dept_desc  VARCHAR2(100),           – 부서설명
  CONSTRAINT dept_master_pk PRIMARY KEY (dept_id)
);



CREATE TABLE address_master (
  address_id   NUMBER NOT NULL,       – 주소아이디
  city         VARCHAR2(100),         – 도시 명
  gu           VARCHAR2(50),          – 구 명
  address_name VARCHAR2(100),         – 나머지 주소
  CONSTRAINT address_master_pk PRIMARY KEY (address_id)
);</code></pre>

<br/>

### 데이터 입력
<pre><code>INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (1, ‘김유신’, ‘남성’, 56, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), 1, 1);

INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (2, ‘신사임당’, ‘여성’, 34, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), 1, 2);

INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (3, ‘홍길동’, ‘남성’, 45, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), 3, 2);

INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (4, ‘강감찬’, ‘남성’, 23, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), 2, 3);

INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (5, ‘세종대왕’, ‘남성’, 45, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), 4, 4);

INSERT INTO dept_master ( dept_id, dept_name )
VALUES (1, ‘회계팀’);

INSERT INTO dept_master ( dept_id, dept_name )
VALUES (2, ‘경영팀’);

INSERT INTO dept_master ( dept_id, dept_name )
VALUES (3, ‘전산팀’);

INSERT INTO dept_master ( dept_id, dept_name )
VALUES (4, ‘마케팅팀’);

INSERT INTO address_master ( address_id, city, gu, address_name )
VALUES (1, ‘서울특별시’, ‘중구’, ‘새문안로 12’);

INSERT INTO address_master ( address_id, city, gu, address_name )
VALUES (2, ‘서울특별시’, ‘서대문구’, ‘연희로 15길’);

INSERT INTO address_master ( address_id, city, gu, address_name )
VALUES (3, ‘서울특별시’, ‘영등포구’, ‘여의대로 99’);

INSERT INTO address_master ( address_id, city, gu, address_name )
VALUES (4, ‘서울특별시’, ‘강남구’, ‘테헤란로 33’);

COMMIT;</code></pre>

<br/>

### DEFAULT 값 입력 확인
<pre><code>SELECT *
  FROM dept_master;</code></pre>

<br/><br/>

## 내부 조인
1. 조인 테이블에서 조인 컬럼의 값이 같은 건을 조회하는 것을 내부 조인(inner join)이라고 한다.
2. 조인 테이블에서 조인 컬럼의 이름을 동일하게 만드는 것이 일반적이나 반드시 같을 필요는 없다. 하지만 값은 같아야 한다.
3. 내부 조인은 INNER JOIN 구문을 사용하고 ON 절에 조인 조건을 명시하는데, 이때 INNER는 생략할 수 있다.
4. 내부 조인할 때, INNER JOIN 구문을 사용하는 대신에 FROM 절에 조인 테이블들을 콤마로 구분해 명시하고 조인 조건은 WHERE 절에 기술할 수도 있다.

<br/>

### 부서정보 내부 조인
<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
      ,dept_master b
 WHERE a.dept_id = b.dept_id
 ORDER BY a.emp_id;</code></pre>

<br/>

### ANSI 구문으로 작성한 내부 조인
<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
 INNER JOIN dept_master b
    ON a.dept_id = b.dept_id
 ORDER BY a.emp_id;</code></pre>

<br/>

### 내부 조인에서 남성만 조회
<pre><code>--기본 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
      ,dept_master b
 WHERE a.dept_id = b.dept_id
   AND a.gender = '남성'
 ORDER BY a.emp_id;
 
--ANSI 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
 INNER JOIN dept_master b
    ON a.dept_id = b.dept_id
 WHERE a.gender = '남성'
 ORDER BY a.emp_id;</code></pre>

<br/>

### 주소정보 테이블 조인
<pre><code>--기본 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, 
       b.dept_id, b.dept_name, b.use_yn,
       c.address_id, c.city, c.gu, c.address_name
  FROM emp_master a
      ,dept_master b
      ,address_master c
 WHERE a.dept_id    = b.dept_id
   AND a.address_id = c.address_id
   AND a.gender     = '남성'
 ORDER BY a.emp_id;
 
--ANSI 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, 
       b.dept_id, b.dept_name, b.use_yn,
       c.address_id, c.city, c.gu, c.address_name
  FROM emp_master a
 INNER JOIN dept_master b
    ON a.dept_id = b.dept_id
 INNER JOIN address_master c
    ON a.address_id = c.address_id
 WHERE a.gender = '남성'
 ORDER BY a.emp_id;</code></pre>
 
<br/><br/>

## 외부 조인
1. 외부 조인(outer join)은 테이블 간에 조인 조건을 만족하는 건은 물론이고 만족하지 않는 건도 조회한다.
2. 외부 조인은 LEFT 조인과 RIGHT 조인이 있다.
3. LEFT 조인은 LEFT OUTER JOIN 구문을 사용하고 조인 조건은 ON 절에 기술하며, OUTER는 생략할 수 있다.
4. LEFT 조인은 조인 구문의 왼쪽, 즉 FROM 절에 기술한 테이블의 조인 조건을 만족하지 않는 건까지 조회한다.
5. RIGHT 조인은 RIGHT OUTER JOIN 구문을 사용하고 조인 조건은 ON 절에 기술하며, OUTER는 생략할 수 있다.
6. RIGHT 조인은 조인 구문의 오른쪽, 즉 RIGHT OUTER JOIN 절에 기술한 테이블의 조인 조건을 만족하지 않는 건까지 조회한다.

<br/>

### 사원정보 테이블 데이터 추가 INSERT 문

<pre><code>INSERT INTO emp_master ( emp_id, emp_name, gender, age, hire_date, dept_id, address_id )
VALUES (6, ‘왕건’, ‘남성’, 35, TO_DATE(‘2018-01-01’, ‘YYYY-MM-DD’), NULL, 4);

COMMIT;</code></pre>

<br/>

### 오라클 기본 구문으로 작성한 외부 조인
<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
      ,dept_master b
 WHERE a.dept_id = b.dept_id (+)
 ORDER BY a.emp_id;</code></pre>
 
<br/>

### ANSI 구문으로 작성한 외부 조인

<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
  LEFT JOIN dept_master b
    ON a.dept_id = b.dept_id
 ORDER BY a.emp_id;</code></pre>

<br/>

### 부서정보 테이블에 데이터 추가 INSERT 문
<pre><code>INSERT INTO dept_master ( dept_id, dept_name )
VALUES (5, ‘IT팀’);

COMMIT;</code></pre>

<br/>

### 부서정보 테이블 기준 외부 조인
<pre><code>--오라클 기본 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
      ,dept_master b
 WHERE a.dept_id(+) = b.dept_id
 ORDER BY a.emp_id;
 
--ANSI 구문
SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
 RIGHT JOIN dept_master b
    ON a.dept_id = b.dept_id
 ORDER BY a.emp_id;</code></pre>

<br/>

### FULL OUTER JOIN

<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
  FULL OUTER JOIN dept_master b
    ON a.dept_id = b.dept_id
 ORDER BY a.emp_id;</code></pre>
 
<br/><br/>

## 기타 조인
1. 자연 조인은 NATURAL 구문을 사용하고 조인 조건을 기술하지 않으므로 조인 테이블에 이름과 데이터 타입이 같은 컬럼이 존재해야 한다.
2. 자연 조인 구문으로 내부 조인이나 외부 조인을 할 수 있다.
3. 카티션 곱은 조인 조건이 없는 조인으로, 조인 테이블의 모든 조합으로 데이터를 조회한다.

<br/>

### 카티션 곱
<pre><code>SELECT a.emp_id, a.emp_name, a.gender, a.age, a.dept_id,
       b.dept_id, b.dept_name, b.use_yn
  FROM emp_master a
      ,dept_master b
 ORDER BY a.emp_id;</code></pre>

<br/><br/>

## 세미 조인
- 메인쿼리에서 사용된 테이블과 서브쿼리 결과를 조인하는 것이다.

<br/>

### EXISTS 연산자를 사용한 세미 조인
<pre><code>SELECT *
  FROM dept_master a

 WHERE EXISTS ( SELECT 1
                  FROM emp_master b
                 WHERE b.age BETWEEN 40 AND 49
                   AND a.dept_id = b.dept_id
              );</code></pre>

<br/><br/>

## 안티 조인
- 세미 조인과 형식은 같은데 NOT 연산자가 들어간다는 점이 다르다. 
- NOT에 반대라는 의미가 있으므로 안티(anti) 조인이란 이름이 붙은 것이다. 

<br/>

### NOT 연산자를 사용한 안티 조인
<pre><code>SELECT *
  FROM dept_master a      
 WHERE a.dept_id NOT IN ( SELECT b.dept_id
                            FROM emp_master b
                           WHERE b.age BETWEEN 40 AND 49
                        );</code></pre>
                        
<br/>

### NOT EXISTS를 사용한 안티 조인
<pre><code>SELECT *
  FROM dept_master a      
 WHERE NOT EXISTS ( SELECT 1
                      FROM emp_master b
                     WHERE b.age BETWEEN 40 AND 49
                       AND a.dept_id = b.dept_id
                   );</code></pre>

<br/><br/>

## UNION 절
1. UNION 절을 사용하면 연결된 SELECT 문의 결과 집합을 합쳐 조회할 수 있다.
2. UNION DISTINCT 절을 사용하면 SELECT 절에 기술한 컬럼을 기준으로 중복 값을 제외하고 조회하며, DISTINCT는 생략할 수 있다.
3. UNION ALL 절을 사용하면 SELECT 절에 기술한 컬럼을 기준으로 중복 값을 포함한 모든 데이터를 조회한다.
4. UNION 절을 사용하면 일반적으로 ORDER BY와 LIMIT 절은 마지막 SELECT 문에 기술하고, 최종 결과 집합에 대해 정렬을 수행한다.
5. 개별 SELECT 문에 ORDER BY와 LIMIT 절을 사용하려면 해당 SELECT 문을 소괄호로 묶어야 한다.

<br/>

### emp08 테이블 생성
<pre><code>CREATE TABLE emp08
(
  emp_id2    NUMBER        NOT NULL,
  emp_name2  VARCHAR2(100) NOT NULL,
  gender     VARCHAR2(10),
  age        NUMBER,
  hire_date  DATE,
  etc        VARCHAR2(300),
  CONSTRAINT emp08_pk PRIMARY KEY (emp_id2)
);</code></pre>

<br/>

### emp08 테이블 데이터 입력
<pre><code>INSERT INTO emp08 ( emp_id2, emp_name2, gender, age, hire_date )
VALUES (1, '선덕여왕', '여성', 23, TO_DATE('2018-02-01', 'YYYY-MM-DD'));

INSERT INTO emp08 ( emp_id2, emp_name2, gender, age, hire_date )
VALUES (2, '허난설헌', '여성', 33, TO_DATE('2018-02-01', 'YYYY-MM-DD'));

INSERT INTO emp08 ( emp_id2, emp_name2, gender, age, hire_date )
VALUES (3, '김만덕', '여성', 43, TO_DATE('2018-02-01', 'YYYY-MM-DD'));

INSERT INTO emp08 ( emp_id2, emp_name2, gender, age, hire_date )
VALUES (4, '장희빈', '여성', 35, TO_DATE('2018-02-01', 'YYYY-MM-DD'));

INSERT INTO emp08 ( emp_id2, emp_name2, gender, age, hire_date )
VALUES (5, '신사임당', '여성', 45, TO_DATE('2018-02-01', 'YYYY-MM-DD'));

COMMIT;</code></pre>

<br/>

### UNION ALL 연산자
<pre><code>SELECT emp_id, emp_name, gender, age
  FROM emp03
 UNION ALL 
SELECT emp_id2, emp_name2, gender, age
  FROM emp08;</code></pre>

<br/>

### 집합 연산자를 사용한 쿼리에서 데이터 정렬
<pre><code>SELECT emp_id, emp_name, gender, age
  FROM emp03
 UNION ALL
SELECT emp_id2, emp_name2, gender, age
  FROM emp08
 ORDER BY emp_id DESC;</code></pre>
 
<br/>

### 중복 데이터에 대한 UNION ALL 사용
<pre><code>SELECT emp_name
  FROM emp03
 UNION ALL
SELECT emp_name2
  FROM emp08
 ORDER BY 1;</code></pre>
 
<br/>

### 중복 데이터에 대한 UNION 사용
<pre><code>SELECT emp_name
  FROM emp03
 UNION
SELECT emp_name2
  FROM emp08
 ORDER BY 1;</code></pre>

<br/>

### 값이 다른 컬럼에 대한 UNION 사용
<pre><code>SELECT emp_name, gender, age
  FROM emp03
 UNION
SELECT emp_name2, gender, age 
  FROM emp08
 ORDER BY 1;</code></pre>

<br/>

### INTERSECT 연산자

<pre><code>SELECT emp_name
  FROM emp03
INTERSECT
SELECT emp_name2
  FROM emp08
 ORDER BY 1;</code></pre>

<br/>

### 공통 요소가 없을 때 INTERSECT 사용

<pre><code>SELECT emp_name, gender, age
  FROM emp03
INTERSECT
SELECT emp_name2, gender, age 
  FROM emp08
 ORDER BY 1;</code></pre>

<br/>

### MINUS 연산자 예제1
<pre><code>SELECT emp_name
  FROM emp03
 MINUS
SELECT emp_name2
  FROM emp08
 ORDER BY 1;</code></pre>

<br/>

### MINUS 연산자 예제2
<pre><code>SELECT emp_name2
  FROM emp08
 MINUS
SELECT emp_name
  FROM emp03
 ORDER BY 1;</code></pre>

<br/><br/>

![CX](https://user-images.githubusercontent.com/61584142/160230698-2a6e8a89-608a-4a36-80b4-d25677cd547f.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 쿼리 안의 또 다른 쿼리: 서브쿼리
## 서브쿼리
1. 서브쿼리는 한 쿼리 안에 있는 또 다른 독립적 SELECT 문장을 가리킨다.
2. 서브쿼리는 반드시 소괄호로 둘러싸야 한다.
3. 원하는 데이터를 조회할 때, 한 단계가 아닌 두 단계 이상의 연산이 필요하면 서브쿼리를 사용한다.
4. 서브쿼리는 메인쿼리의 어디에 위치하는지와 메인쿼리와의 연관성 유무로 유형을 구분한다.

<br/>

### 서브쿼리를 조인으로 변경
<pre><code>SELECT a.emp_id
      ,a.emp_name
      ,a.gender
      ,a.age
      ,a.dept_id
      ,b.dept_name
 FROM emp_master a
     ,dept_master b
WHERE a.dept_id = b.dept_id(+);</code></pre>

<br/>

### 단일 행을 반환하는 중첩 서브쿼리

<pre><code>SELECT *
  FROM dept_master a

 WHERE a.dept_id = ( SELECT b.dept_id
                       FROM emp_master b
                      WHERE b.emp_name = ‘세종대왕‘
);</code></pre>

<br/>

### 다중 행을 반환하는 중첩 서브쿼리
<pre><code>SELECT *
  FROM dept_master a
 WHERE a.dept_id IN ( SELECT b.dept_id
                        FROM emp_master b
                       WHERE b.age BETWEEN 40 AND 49
                    );</code></pre>

<br/>

### 다중 컬럼, 다중 행을 반환하는 중첩 서브쿼리
<pre><code>SELECT *
  FROM emp_master a
 WHERE ( a.gender, a.age) IN ( SELECT b.gender, b.age
                                  FROM emp_master b
                                      ,address_master c
                                 WHERE b.address_id = c.address_id
                                   AND c.gu IN ('중구', '서대문구')
                              );</code></pre>

<br/><br/>

## 스칼라 서브쿼리와 파생 테이블
1. 스칼라 서브쿼리는 메인쿼리의 SELECT 절에 위치한 서브쿼리로, 하나의 컬럼이나 표현식 역할을 한다.
2. 스칼라 서브쿼리는 반드시 단일 로우, 단일 값을 반환해야 하며, 메인 쿼리와 조인할 수 있다.
3. 파생 테이블은 메인쿼리의 FROM 절에 위치한 서브쿼리로, 하나의 테이블 역할을 한다.
4. 파생 테이블의 서브쿼리는 여러 개의 로우, 여러 컬럼 값을 반환할 수 있다.
5. 파생 테이블에는 반드시 별칭을 붙여야 하고, 메인쿼리의 테이블과 조인할 수 있다. 일반적으로 조인 조건은 메인쿼리의 WHERE 절에 기술한다.
6. 파생 테이블은 원래 서브쿼리 안에서 메인쿼리의 테이블을 참조할 수 없지만, MySQL 8.0.14 버전부터 LATERAL 키워드가 추가되어 서브쿼리 안에서 메인쿼리 테이블을 참조할 수 있다. 따라서 조인 조건을 서브쿼리 안에 기술할 수 있다.

<br/>

### 스칼라 서브쿼리

<pre><code>SELECT a.emp_id
      ,a.emp_name
      ,a.gender
      ,a.age
      ,a.dept_id
      ,( SELECT b.dept_name
           FROM dept_master b
          WHERE a.dept_id = b.dept_id ) dept_name
FROM emp_master a;</code></pre>

<br/><br/>

## 인라인 뷰
- 스칼라 서브쿼리와는 다르게 여러 개의 컬럼이나 표현식, 여러 개의 로우를 반환할 수 있다.
<pre><code>SELECT a.dept_id
      ,a.dept_name
      ,k.emp_id
      ,k.emp_name
      ,k.address
  FROM dept_master a
      ,( SELECT b.emp_id
               ,b.emp_name
               ,c.city || c.gu || c.address_name AS address
               ,b.dept_id
           FROM emp_master b
               ,address_master c
          WHERE b.address_id = c.address_id
       ) k
 WHERE a.use_yn = ‘Y’
   AND a.dept_id = k.dept_id
 ORDER BY 1, 3;</code></pre>

<br/><br/>

## WHERE 절의 서브쿼리
1. 메인쿼리의 WHERE 절에도 서브쿼리를 사용할 수 있으며, MySQL에서 이러한 서브쿼리를 지칭하는 공식 명칭은 없지만, 편의상 조건 서브쿼리라고 한다.
2. 조건 서브쿼리는 WHERE 절의 필터 조건에서 비교 값으로도 사용된다.
3. WHERE 절의 서브쿼리는 비교 연산자와 ANY, SOME, ALL, IN, EXISTS 연산자와 함께 사용된다.
4. 비교 연산자만 사용할 때 조건 서브쿼리는 단일 값을 반환해야 한다.
5. 조건 서브쿼리가 반환하는 건이 여러 개이면 ANY, SOME, ALL 연산자를 비교 연산자와 함께 사용할 수 있다.
6. ANY와 SOME 연산자를 사용할 때 조건 서브쿼리가 반환하는 여러 건의 값과 비교해 어느 하나라도 조건에 맞으면 해당 데이터가 조회된다.
7. ALL 연산자를 사용할 때 조건 서브쿼리가 반환하는 여러 건의 값 전체와 비교해 조건에 맞으면 해당 데이터가 조회된다.
8. IN, EXISTS 연산자는 비교 연산자 없이 단독으로 사용한다.
9. IN 연산자를 사용하면 메인쿼리의 비교 컬럼 값이 조건 서브쿼리가 반환하는 값에 포함되는 건을 모두 조회한다.
10. EXISTS 연산자를 사용하면 메인쿼리의 데이터 중 조건 서브쿼리와의 조인 조건에 부합하는 데이터를 조회하는데, 이때 조인 조건은 서브쿼리 안에 기술한다.
11. IN과 EXISTS 연산자 앞에 NOT을 명시하면 포함되지 않는 건과 존재하지 않는 건만 추출할 수 있다.
12. 조건 서브쿼리와 EXISTS 연산자를 사용한 조인을 세미조인, NOT EXISTS 연산자를 사용한 조인을 안티조인이라고 한다.

<br/><br/>

### 문자열 결합 연산자 사용

<pre><code>SELECT 'A' || 'B'
  FROM dual;</code></pre>

<br/><br/>

![ZX](https://user-images.githubusercontent.com/61584142/160230967-11d21cab-e500-47bf-8315-486e3816422c.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 입력/수정/삭제하고 트랜잭션 처리하기
## 데이터 입력하기
1. 테이블에 신규로 데이터를 입력할 때는 INSERT 문을 사용한다.
2. INSERT 문에는 기본형 INSERT, 기본형을 변형한 INSERT, SELECT 문과 결합한 INSERT 문이 있다.
3. 기본형 INSERT 문은 INSERT 문을 한 번 실행할 때 하나의 로우가 입력된다.
4. INSERT 문을 작성할 때는 테이블에 입력할 컬럼과 값의 개수, 순서, 데이터 타입을 모두 맞춰야 한다.
5. INSERT 문에 컬럼을 명시하지 않으면 해당 테이블의 전체 컬럼에 데이터를 입력한다는 뜻이며, 테이블을 정의할 때 명시한 컬럼 순서대로 입력할 값을 명시해야 한다.
6. 데이터를 입력할 때 NOT NULL 컬럼에는 반드시 값을 입력해야 한다.
7. 기본 키 컬럼에 중복 값을 입력하면 오류가 발생해 INSERT 작업이 취소된다.
8. 변형 INSERT 문은 INSERT 문을 한 번 실행할 때 여러 건의 데이터를 한 번에 입력할 수 있다. 이때 VALUES 절에 여러 개의 입력 값을 괄호로 묶어 입력한다.
9. SELECT 문이 결합된 INSERT 문은 SELECT 문이 반환하는 결과 집합이 테이블에 입력되고, 반환된 결과 집합의 건수에 따라 한 번에 여러 건을 입력할 수 있다.

<br/><br/>

## 데이터 수정하기
1. 테이블에 저장된 데이터를 수정할 때는 UPDATE 문을 사용하는데, 단일 테이블 또는 한 번에 여러 개의 테이블의 데이터를 수정할 수 있다.
2. 단일 테이블 UPDATE 문은 한 번에 한 테이블의 데이터를 수정한다. 수정할 컬럼과 그 값은 SET 절에, 조건에 맞는 데이터만 수정할 때는 WHERE 절에 해당 조건을 기술한다.
3. ORDER BY와 LIMIT 절로 수정되는 건의 순서를 제어할 수 있는데, 단일 테이블 UPDATE 문에서만 사용할 수 있다.
4. 다중 테이블 UPDATE 문은 한 번에 2개 이상의 테이블에서 데이터를 수정할 수 있다.
5. UPDATE 다음에 2개 테이블을 명시하면 두 테이블의 특정 컬럼 값을 모두 수정할 수도 있고, 한 테이블의 컬럼 값을 다른 한 테이블의 컬럼 값을 이용해 수정할 수도 있다.
6. INSERT ... ON DUPLICATE KEY UPDATE 문을 사용하면 테이블에 신규로 데이터를 입력함과 동시에 이미 테이블에 저장된 기존 컬럼 값을 수정할 수 있다. 특히 신규 데이터를 입력할 때 기본 키 값에 중복 값을 입력하는 경우, 이 문장을 사용하면 입력이 아닌 ON DUPLICATE KEY UPDATE 다음에 명시한 컬럼의 값이 수정된다.

<br/><br/>

## 데이터 삭제하기
1. 데이터를 삭제할 때는 DELETE 문을 사용하는데, DELETE 문도 단일 테이블 또는 한 번에 여러 개의 테이블의 데이터를 삭제할 수 있다.
2. 단일 테이블 DELETE 문은 WHERE 절에 조건을 명시해 삭제될 데이터를 걸러낼 수 있고, ORDER BY와 LIMIT 절로 삭제되는 건의 순서를 제어할 수 있다.
3. 다중 테이블 DELETE 문은 한 번에 2개 이상의 테이블 데이터를 삭제할 수 있으며 WHERE 절로 삭제되는 건을 제어한다.
4. ORDER BY와 LIMIT 절은 단일 테이블 DELETE 문에서만 사용할 수 있다.

<br/><br/>

## 트랜잭션 처리하기
1. MySQL은 기본으로 자동커밋 모드가 활성화되어 있어서 INSERT, UPDATE, DELETE 문을 실행하면 바로 테이블에 데이터가 반영되며, 세션별로 자동커밋 모드를 비활성화할 수 있다.
2. START TRANSACTION 문으로 트랜잭션 처리를 수동으로 할 수 있다. START TRANSACTION 문 이후 사용된 여러 개의 INSERT, UPDATE, DELETE 문이 하나의 트랜잭션이 되며 COMMIT이나 ROLLBACK 문을 만나면 해당 트랜잭션은 종료된다.
3. 하나의 트랜잭션 안에서 SAEPOINT 문으로 여러 개의 트랜잭션 지점을 설정할 수 있으며 ROLLBACK TO SAVEPOINT 문을 사용하면 특정 지점 이후의 데이터 조작을 취소할 수 있다.

<br/><br/>

![XX](https://user-images.githubusercontent.com/61584142/160231347-ae49a173-7426-46f6-a566-b565613918f6.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 분석에 유용한 분석 쿼리 사용하기
## CTE
1. CTE는 WITH으로 시작되는 SELECT 문으로, 서브쿼리를 먼저 정의하고 메인쿼리가 맨 끝에 위치한다.
2. CTE는 파생 테이블과 달리 하나의 서브쿼리 안에서 다른 서브쿼리를 참조할 수 있다.
3. CTE는 서브쿼리를 먼저 정의하고 메인쿼리를 작성하므로 쿼리를 작성하기가 쉽다.
4. CTE를 사용하면 재귀 쿼리를 만들 수 있는데, 서브쿼리에서 자신을 참조하는 순환 구조로 작동한다.
5. 계층형 쿼리를 작성할 때는 CTE를 사용한 재귀 쿼리를 작성하면 된다.

<br/><br/>

## 윈도우 함수
1. 윈도우는 로우의 그룹으로, OVER 절에 정의하며 PARTITION BY와 ORDER BY 절이 이에 속한다.
2. 집계 쿼리에서도 GROUP BY 절로 로우의 그룹을 지정할 수 있지만 그룹화하는 컬럼 값에 따라 로우 수가 줄어든다. 하지만 윈도우를 사용하면 로우 수를 유지하면서도 집계 값을 계산할 수 있다.
3. OVER 절은 PARTITION BY와 ORDER BY 절로 구성되는데, PARTITION BY는 로우의 그룹인 파티션을 지정하고 ORDER BY 절은 로우의 순서를 지정한다.
4. OVER 절과 함께 집계 함수나 윈도우 함수를 사용할 수 있다.
5. 윈도우 함수로는 ROW_NUMBER(), RANK(), DENSE_RANK(), PERCENT_RANK(), LAG(), LEAD(), NTILE(), FIRST_VALUE(), LAST_VALUE(), NTH_VALUE() 등이 있다.
6. 윈도우를 정의할 때 프레임 절을 추가해 하나의 파티션에 대한 하위 그룹을 추가로 지정할 수 있다
7. 윈도우 함수인 FIRST_VALUE(), LAST_VALUE(), NTH_VALUE()는 프레임 절과 함께 사용할 수 있고, 나머지 윈도우 함수는 프레임 절과 관계없이 값을 반환한다.
8. 윈도우의 별칭을 지정하면 집계 함수나 윈도우 함수의 OVER 절에서 별칭을 사용할 수 있다.

<br/><br/>

## 뷰
1. 뷰는 테이블과 유사한 독립적인 데이터베이스 객체지만 실제 데이터를 저장하지 않는다.
2. 자주 사용되는 복잡한 쿼리를 뷰로 만들면 편리하게 사용할 수 있다.

<br/><br/>

![ZX](https://user-images.githubusercontent.com/61584142/160231625-afd4b6b8-f1c7-444b-8c23-fc6d1da2a6e8.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 분석하기
1. 일반적인 데이터 분석 과정은 데이터 수집 → 데이터 정제 → 데이터 분석의 3단계로 나눌 수 있다.
2. 데이터 정제 작업은 데이터 수집과 입력 과정에서 발생한 오류로 생긴 정확하지 않은 데이터를 걸러 내는 작업을 말한다. 이 과정을 거쳐야 데이터를 좀 더 정확하게 분석할 수 있다.
3. 데이터 분석에는 SQL 기능 중 조인, 집계 쿼리, 서브쿼리, 윈도우 함수가 자주 사용된다.

<br/><br/>

## 나눔로또 분석
- 데이터는 나눔로또 홈페이지에서 엑셀 형태 다운

<br/>

### lotto_master 테이블 생성
<pre><code>CREATE TABLE lotto_master (
  seq_no       NUMBER NOT NULL, – 로또회차
  draw_date    DATE,            – 추첨일
  num1         NUMBER,          – 당첨번호1
  num2         NUMBER,          – 당첨번호2
  num3         NUMBER,          – 당첨번호3
  num4         NUMBER,          – 당첨번호4
  num5         NUMBER,          – 당첨번호5
  num6         NUMBER,          – 당첨번호6
  bonus        NUMBER           – 보너스번호
 );

ALTER TABLE lotto_master
ADD CONSTRAINTS lotto_master_pk PRIMARY KEY (seq_no);</code></pre>

<br/>

### lotto_detail 테이블 생성
<pre><code>CREATE TABLE lotto_detail (
    seq_no         NUMBER NOT NULL,  -- 로또회차
    rank_no        NUMBER NOT NULL,  -- 등수
    win_person_no  NUMBER,           -- 당첨자 수
    win_money      NUMBER            -- 1인당 당첨금액
 );
 
ALTER TABLE lotto_detail
ADD CONSTRAINTS lotto_detail_pk PRIMARY KEY (seq_no, rank_no);</code></pre>

<br/>

### 중복된 로또 번호 존재 여부 조회 1
<pre><code>SELECT num1, num2, num3, num4, num5, num6, COUNT(*)
  FROM lotto_master
 GROUP BY num1, num2, num3, num4, num5, num6;</code></pre>

<br/>

### 중복된 로또 번호 존재 여부 조회 2
<pre><code>SELECT num1, num2, num3, num4, num5, num6, COUNT(*)
  FROM lotto_master
 GROUP BY num1, num2, num3, num4, num5, num6
 HAVING COUNT(*) > 1;</code></pre>

<br/>

### num1 컬럼 값의 당첨 건수 조회
<pre><code>SELECT NUM1 lotto_num, COUNT(*) CNT
  FROM lotto_master
 GROUP BY NUM1
 ORDER BY 2 DESC;</code></pre>

<br/>

### 가장 많은 당첨번호 조회
<pre><code>SELECT lotto_num, SUM(cnt) AS cnt
  FROM ( SELECT num1 lotto_num, COUNT() cnt
           FROM lotto_master
          GROUP BY num1
          UNION ALL
         SELECT num2 lotto_num, COUNT() cnt
           FROM lotto_master
          GROUP BY num2
         UNION ALL
         SELECT num3 lotto_num, COUNT() cnt
           FROM lotto_master
          GROUP BY num3
         UNION ALL
         SELECT num4 lotto_num, COUNT() cnt
           FROM lotto_master
          GROUP BY num4
         UNION ALL
         SELECT num5 lotto_num, COUNT() cnt
           FROM lotto_master

          GROUP BY num5
          UNION ALL
         SELECT num6 lotto_num, COUNT() cnt
           FROM lotto_master

          GROUP BY num6
       )
 GROUP BY lotto_num
 ORDER BY 2 DESC;</code></pre>
 
<br/>

### 최대 당첨금과 당첨번호 조회
<pre><code>SELECT a.seq_no
      ,a.draw_date
      ,b.win_person_no
      ,b.win_money
      ,a.num1 ,a.num2 ,a.num3
      ,a.num4 ,a.num5 ,a.num6 ,a.bonus
  FROM lotto_master a
      ,lotto_detail b
 WHERE a.seq_no = b.seq_no
   AND b.rank_no = 1
 ORDER BY b.win_money DESC;</code></pre>
 
<br/><br/>

## 교통사고 분석
- 1980년부터 2016년까지 자동차, 선박, 지하철, 철도, 항공기별 전체 사고 건수와 사망자 수 데이터
- 국가교통DB(www.ktdb.go.kr)

<br/>

### traffic_accident 테이블 생성
<pre><code>CREATE TABLE traffic_accident (
    year              NUMBER       NOT NULL,  – 연도
    trans_type        VARCHAR2(30) NOT NULL,  – 교통수단
    total_acct_num    NUMBER,                 – 사고 건수
    death_person_num  NUMBER                  – 사망자 수

);

ALTER TABLE traffic_accident
ADD CONSTRAINTS traffic_accident_pk PRIMARY KEY (year, trans_type);</code></pre>

<br/>

### 연대, 교통수단별 사고, 사망 건수 조회
<pre><code>SELECT CASE WHEN year BETWEEN 1980 AND 1989 THEN '1980년대'
            WHEN year BETWEEN 1990 AND 1999 THEN '1990년대'
            WHEN year BETWEEN 2000 AND 2009 THEN '2000년대'
            WHEN year BETWEEN 2010 AND 2019 THEN '2010년대'
       END AS YEARS
      ,trans_type
      ,SUM(total_acct_num)   AS 사고건수
      ,SUM(death_person_num) AS 사망자수
FROM traffic_accident
WHERE 1=1
GROUP BY CASE WHEN year BETWEEN 1980 AND 1989 THEN '1980년대'
              WHEN year BETWEEN 1990 AND 1999 THEN '1990년대'
              WHEN year BETWEEN 2000 AND 2009 THEN '2000년대'
              WHEN year BETWEEN 2010 AND 2019 THEN '2010년대'
         END, trans_type
ORDER BY 1, 2;</code></pre>

<br/>

### 교통수단별 사고 건수 연대별 추이
<pre><code>SELECT trans_type
      ,SUM(CASE WHEN year BETWEEN 1980 AND 1989 THEN total_acct_num ELSE 0 END) "1980년대"
      ,SUM(CASE WHEN year BETWEEN 1990 AND 1999 THEN total_acct_num ELSE 0 END) "1990년대"
      ,SUM(CASE WHEN year BETWEEN 2000 AND 2009 THEN total_acct_num ELSE 0 END) "2000년대"
      ,SUM(CASE WHEN year BETWEEN 2010 AND 2019 THEN total_acct_num ELSE 0 END) "2010년대"
FROM traffic_accident
WHERE 1=1
GROUP BY trans_type
ORDER BY trans_type;</code></pre>

<br/>

### 교통수단별 사망자 수 연도별 추이
<pre><code>SELECT a.*
 FROM traffic_accident a
     ,( SELECT trans_type
              ,MAX(death_person_num) death_per
          FROM traffic_accident
         GROUP BY trans_type
      ) B
WHERE a.trans_type       = b.trans_type
  AND a.death_person_num = b.death_per;</code></pre>

<br/><br/>

## 서울시 미세먼지 분석
- 2017년 1월부터 2018년 3월까지의 서울시 미세먼지 데이터
- 에어코리아(http://www.airkorea.or.kr)

<br/>

### fine_dust 테이블 생성

<pre><code>CREATE TABLE fine_dust (
    gu_name           VARCHAR2(50) NOT NULL,  – 구 명
    mea_station       VARCHAR2(30) NOT NULL,  – 측정소
    mea_date          DATE         NOT NULL,  – 측정일자
    pm10              NUMBER,                 – 미세먼지 농도
    pm25              NUMBER                  – 초미세먼지 농도
);

ALTER TABLE fine_dust
ADD CONSTRAINTS fine_dust_pk PRIMARY KEY (gu_name, mea_station, mea_date);</code></pre>

<br/>

### fine_dust_standard 테이블 생성
<pre><code>CREATE TABLE fine_dust_standard (
    org_name          VARCHAR2(50) NOT NULL,  -- 기관명
    std_name          VARCHAR2(30) NOT NULL,  -- 미세먼지 기준(좋음, 
                                                 보통, 나쁨, 매우나쁨)
    pm10_start        NUMBER,                 -- 미세먼지 농도(시작 값)
    pm10_end          NUMBER,                 -- 미세먼지 농도(끝 값)
    pm25_start        NUMBER,                 -- 초미세먼지 농도(시작 값)
    pm25_end          NUMBER                  -- 초미세먼지 농도(끝 값) 
);

ALTER TABLE fine_dust_standard
ADD CONSTRAINTS fine_dust_standard_pk PRIMARY KEY (org_name, std_name);</code></pre>

<br/>

### 월간 미세먼지의 최소, 최대, 평균값
<pre><code>SELECT TO_CHAR(a.mea_date, 'YYYY-MM') months
       ,ROUND(MIN(a.pm10),0) pm10_min
       ,ROUND(MAX(a.pm10),0) pm10_max
       ,ROUND(AVG(a.pm10),0) pm10_avg
       ,ROUND(MIN(a.pm25),0) pm25_min
       ,ROUND(MAX(a.pm25),0) pm25_max
       ,ROUND(AVG(a.pm25),0) pm25_avg
  FROM fine_dust a
 WHERE pm10 > 0
   AND pm25 > 0
 GROUP BY  TO_CHAR(mea_date, 'YYYY-MM')
 ORDER BY 1;</code></pre>

<br/>

### 월평균 미세먼지 상태
<pre><code>SELECT a.months
      ,a.pm10_avg
      ,( SELECT b.std_name
           FROM fine_dust_standard b
          WHERE b.org_name = ‘WHO’
            AND a.pm10_avg BETWEEN b.pm10_start
                               AND b.pm10_end
       ) “미세먼지 상태”
      ,a.pm25_avg
      ,( SELECT b.std_name
           FROM fine_dust_standard b
          WHERE b.org_name = ‘WHO’
            AND a.pm25_avg BETWEEN b.pm25_start
                               AND b.pm25_end
       ) “초미세먼지 상태”

FROM ( – 월평균 미세먼지 농도 서브쿼리
       SELECT TO_CHAR(a.mea_date, ‘YYYY-MM’) months
             ,ROUND(AVG(a.pm10),0) pm10_avg
             ,ROUND(AVG(a.pm25),0) pm25_avg
        FROM fine_dust a
       WHERE a.pm10 > 0
         AND a.pm25 > 0
       GROUP BY TO_CHAR(mea_date, ‘YYYY-MM’)

) a
ORDER BY 1;</code></pre>

<br/><br/>

![VV](https://user-images.githubusercontent.com/61584142/160231752-1ea57a4d-69f0-493a-91dd-91e4a8bab68e.png)
