# 데이터 입력하고 결과 출력하기
## 출력 명령어
### print()
- 출력 명령어 <br/><br/>
### print(5)
- 5
- 숫자 출력<br/><br/>
### print('파이썬') 또는 print("파이썬")
- 파이썬
- 문자 출력<br/><br/>
### print(5 ** 2)
- 25
- 수식을 넣으면 연산 결과 출력

<br/><br/><br/><br/>

## 여러 요소 연결해서 출력하기
### print('문자' + '문자')
- 예 print('온라인' + '쇼핑') > 온라인쇼핑
- 2개의 문자를 공백 없이 이어서 출력<br/><br/>
### print('문자', '문자')
- print(숫자, 숫자)
- 예 print('온라인', '쇼핑') > 온라인 쇼핑
- 예 print(20, 20) > 20 20
- 공백을 포함해 2개의 요소를 이어서 출력<br/><br/>
### print('문자' * 숫자)
- 예 print('블링' * 2) > 블링블링
- 문자를 숫자 횟수만큼 출력

<br/><br/><br/><br/>

## 입력 명령어
### input()
- 입력칸만 생성
- 입력 명령어<br/><br/>
### input('입력 안내문')
- 입력 안내문을 출력 후 바로 입력 칸 생성
- 입력 안내문을 포함한 입력 명령어

<br/><br/><br/><br/>

## 명령어 실행 순서(제어구조)
### 명령어가 여러 줄일 때
- 위에서부터 아래로 실행<br/><br/>
### 명령어 안에 명령어가 있을 때
- 가장 안쪽 명령어부터 바깥쪽 명령어 순서로 실행

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 변수로 데이터 저장하기
## 변수
- 데이터를 저장하는 공간으로 저장된 데이터는 변경될 수 있다. 변수명은 저장된 데이터의 특징을 잘 살린 이름으로 짓는 것이 좋다.

<br/><br/><br/><br/>

## 변수 만들기
- a라는 이름의 변수를 만들고 10을 저장한다.
<pre><code># 변수명 = 값
a = 10</code></pre>

<br/><br/><br/><br/>

## 변수에 값을 연산하는 식을 넣을 수도 있다.
- result에 p * r ** 2를 연산한 값을 저장한다.
<pre><code># 변수명 = 연산식
result = p * r ** 2</code></pre>

<br/><br/><br/><br/>

## 변수 값을 연산해 같은 변수에 다시 넣을 경우 다음처럼 줄여 쓸 수 있다.
### a = a + b
- a += b
- a의 값에 b의 값을 더한 결괏값을 a에 다시 저장하기<br/><br/>
### a = a - b
- a -= b
- a의 값에 b의 값을 뺀 결괏값을 a에 다시 저장하기<br/><br/>
### a = a * b
- a *= b
- a의 값에 b의 값을 곱한 결괏값을 a에 다시 저장하기<br/><br/>
### a = a / b
- a /= b
- a의 값을 b의 값으로 나눈 결괏값을 a에 다시 저장하기

<br/><br/><br/><br/>

## 변수명과 문자
<pre><code>print(result)   # 변수 result에 들어 있는 값을 출력한다.
print('result') # 문자 result를 출력한다.</code></pre>

<br/><br/><br/><br/>

## 만들지 않은 변수를 사용하면 NameError가 발생한다.
<pre><code>naem = '유리'
print(name)</code></pre>
```
실행결과
NameError: name 'name' is not defined
```
- 첫째 줄에서 만든 변수명은 naem이므로 print() 에서 사용한 name 변수는 만들어지지 않은 상태다. 이처럼 변수가 만들어지지 않은 상태에서 사용하면 오류가 발생한다.

<br/><br/><br/><br/>

## 입력받은 값을 변수에 저장하기
<pre><code># 변수명 = input()
r = input('반지름은? ')</code></pre>
- 변수 r에 input()으로 입력받은 값을 저장한다.

<br/><br/><br/><br/>

## 변수는 마지막에 저장된 값만 기억하고, 이전에 저장한 값은 기억하지 못한다.

<pre><code>abc = 10
abc += 5
abc = 22
print(abc)</code></pre>
```
실행결과
22
```
- 변수 abc에 10이 가장 먼저 저장된다. 그다음 줄에서 abc += 5를 실행하면 10이 사라지고 대신 15가 저장된다. 마지막으로 abc = 22가 실행되면 15는 사라지고 최종적으로 22가 abc에 저장된다.

<br/><br/><br/><br/>

## 데이터 타입 - 변수가 가진 데이터의 유형이나 형태를 의미한다.
### 숫자형
- 정수형 > int
- 실수형 > float<br/><br/>
### 문자열
- str

<br/><br/><br/><br/>

## 데이터 타입을 잘못 사용해 연산하면 TypeError가 발생한다.

<br/><br/><br/><br/>

## 데이터 타입을 바꾸려면 바꾸려는 데이터 타입으로 데이터를 감싼다.
### int(a) - a를 정수형으로 바꿔라
- x = 99.9
- x = int(x)
    - 값이 정수형으로 바뀌어 99를 저장한다.
- r = int(input())
  - 입력받은 데이터를 정수형으로 바꿔 r에 저장한다. 단, 숫자가 아닌 문자가 입력되면 ValueError가 발생한다.<br/><br/>
### float(a) - a를 실수형으로 바꿔라
- y = 99
- y = float(y)
    - 값이 실수형으로 바뀌어 y에 99.0을 저장한다.
- avg = '1.2'
- print(avg * 3)
- avg = float(avg)
- print(avg * 3)
    - avg 값은 현재 문자형이므로 처음에 1.21.21.2가 출력된다.
    - avg를 실수형으로 바꿔 avg에 다시 저장한다.
    - avg가 실수형이므로 3.6이 출력된다.<br/><br/>
### str(a) - a를 문자열로 바꿔라
- z = 4.5
- z = str(z)
- print('학점은 ' + z)
    - z를 문자열로 바꾼다.
    - 문자 + 문자이므로 ‘학점은 4.5’가 출력된다.

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 조건에 따라 해야 할 일이 다를 때: 조건문
## 제어구조 - 프로그램의 흐름이자 프로그램 안에서 명령어가 실행되는 순서
### 순차구조
- 위에서 아래의 순서로 실행되는 구조<br/><br/>
### 선택구조
- 조건 충족 여부에 따라 실행할 명령어가 달라지는 구조

<br/><br/><br/><br/>

## 조건문
- 조건 충족 여부에 따라 실행되는 내용이 다른 선택구조를 파이썬 코드로 표현한 것

<br/><br/><br/><br/>

## 조건문의 형식
### 조건이 하나일 때
<pre><code>if A:
    B</code></pre><br/><br/>
### 조건을 충족할 때와 충족하지 않을 때
<pre><code>if A:
    B
else:
    C</code></pre><br/><br/>
### 조건이 여러 개일 때
<pre><code>if A:
    B
elif C:
    D
    else:
    E</code></pre>

<br/><br/><br/><br/>

## 비교 연산자 - 두 값을 비교하는 연산자
### a > b - a가 b보다 큰가?
- a <= b
- a가 b보다 작거나 같은가?<br/><br/>
### a < b - a가 b보다 작은가?
- a == b
- a와 b는 같은가?<br/><br/>
### a >= b - a가 b보다 크거나 같은가?
- a != b
- a와 b는 다른가(=같지 않은가)?

<br/><br/><br/><br/>

## 여러 개의 조건을 동시에 판단하는 연산자
### A and B
- A도 충족하고 B도 충족한다면(A와 B를 동시에 충족한다면)<br/><br/>
### A or B
- A를 충족하거나 B를 충족한다면(A 또는 B 둘 중 하나라도 충족한다면)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 같은 일을 여러 번 반복해야 할 때: 반복문
## 제어구조의 종류
### 순차구조
- 위에서 아래의 순서로 실행되는 구조<br/><br/>
### 선택구조(조건문)
- 조건 충족 여부에 따라 실행할 명령어가 달라지는 구조<br/><br/>
### 반복구조(반복문)
- 특정 명령어를 지정된 범위 또는 조건 내에서 반복하는 구조

<br/><br/><br/><br/>

## 반복문의 실행원리
### for
```
for a in data:
    B
```
- a가 data 구간 안에 있는 값일 동안 B를 실행하라
<pre><code>for a in [1, 2, 3, 4, 5]:
    print('안녕하세요')</code></pre><br/><br/>
### while
```
while 조건:
    B
```
- 조건을 충족하는 동안 B를 실행하라
```
a = 1
while a <= 5:
    print('안녕하세요')
    a += 1
```

<br/><br/><br/><br/>

## 연속된 숫자 범위를 나타내는 range()
### range(시작 숫자, 종료 숫자)
- 시작 숫자부터 (종료 숫자 - 1) 사이의 연속된 숫자(1씩 증가)<br/><br/>
### range(종료 숫자)
- 0부터 (종료 숫자 - 1) 사이의 연속된 숫자(1씩 증가)<br/><br/>
### range(시작 숫자, 종료 숫자, 간격)
- 시작 숫자부터 (종료 숫자 - 1)까지 간격만큼 증가

<br/><br/><br/><br/>

## 라이브러리 사용하기
### 라이브러리
- 특정 기능과 관련된 명령어를 한 데 묶어 놓은 명령어 모음<br/><br/>
### 라이브러리를 포함하는 방법
- import 라이브러리명
- 예시 import random<br/><br/>
### 라이브러리에 속한 명령어 사용법
- 라이브러리명.명령어()

<br/><br/><br/><br/>

## random 라이브러리의 명령어
### random.random()
- 0부터 1 사이의 무작위 실수<br/><br/>
### random.randrange(시작 숫자, 종료 숫자)
- 시작 숫자부터 (종료 숫자 - 1) 사이의 무작위 정수<br/><br/>
### random.randrange(시작 숫자, 종료 숫자, 간격)
- 시작 숫자부터 (종료 숫자 - 1) 사이에서 간격만큼 떨어진 정수 중 무작위<br/><br/>
### random.randint(시작 숫자, 종료 숫자)
- 시작 숫자부터 종료 숫자(종료 숫자 포함) 사이의 무작위 정수

<br/><br/><br/><br/>

## break
- 반복문을 멈추는 명령어로, break가 실행될 조건을 조건문으로 만들 수 있다.
<pre><code>for i in data: # 반복문을 실행하다가
    if 조건:   # 조건이 충족되면
        break  # 반복문을 멈춘다</code></pre>

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 여러 데이터를 한 번에 묶어 표현하기: 리스트
## 리스트
- 여러 요소를 묶어 표현한 데이터 타입으로, 각 요소가 숫자 인덱스와 대응된다. 인덱스는 0부터 시작하는 점에 유의한다.
<pre><code>리스트명 = [요소1, 요소2, ...]</code></pre>

<br/><br/><br/><br/>

## 리스트에 사용할 수 있는 명령어
### 리스트 길이 구하기
<pre><code>len(리스트명)</code></pre><br/><br/>
### 리스트에 데이터 추가하기
<pre><code>리스트명.append(데이터)</code></pre><br/><br/>
### 리스트의 데이터 삭제하기
<pre><code>리스트명.remove(데이터)</code></pre>
<pre><code>del 리스트명[인덱스]</code></pre><br/><br/>
### 리스트 슬라이싱하기
<pre><code>리스트명[시작 인덱스:종료 인덱스]</code></pre>
- (시작 인덱스부터 종료 인덱스 - 1까지 슬라이싱)
<pre><code>리스트명[:종료 인덱스]</code></pre>
- (처음부터 종료 인덱스 - 1까지 슬라이싱)
<pre><code>리스트명[시작 인덱스:]</code></pre>
- (시작 인덱스부터 끝까지 슬라이싱)<br/><br/>
### 리스트 정렬하기
<pre><code>리스트명.sort()</code></pre>
- (reverse=True 옵션을 사용하면 내림차순 정렬, 옵션을 사용하지 않으면 오름차순 정렬이 기본값)

<br/><br/><br/><br/>

## 문자열 슬라이싱하기
### 인덱스를 사용한 문자열 슬라이싱
<pre><code>변수[시작 인덱스:종료 인덱스]</code></pre>
<pre><code>변수[:종료 인덱스]</code></pre>
- (처음부터 종료 인덱스 - 1까지 슬라이싱)
<pre><code>변수[시작 인덱스:]</code></pre>
- (시작 인덱스부터 끝까지 슬라이싱)<br/><br/>
### split()을 사용한 문자열 나누기
<pre><code>변수.split(기준 문자)</code></pre>
- (기준 문자를 설정하지 않으면 공백을 기준으로 자동 분리)

<br/><br/><br/><br/>

## 이차원 리스트
- 리스트 안에 리스트가 있는 리스트다. 행 인덱스와 열 인덱스가 있으며, 행 인덱스를 먼저 쓰고 열 인덱스를 뒤에 쓴다.

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 문자 기준으로 데이터 묶기: 딕셔너리
## 딕셔너리
- 키(key)와 값(value)이 한 쌍으로 대응되는 데이터 타입
<pre><code>딕셔너리명 = {키 : 값, 키 : 값, ...}</code></pre>

<br/><br/>

## 데이터 변경, 추가, 삭제하기
### 값 변경하기
- 키가 딕셔너리에 이미 존재하면 대응되는 값이 변경된다.
<pre><code>딕셔너리명[키] = 값</code></pre><br/><br/>
### 키-값 추가하기
- 키가 딕셔너리에 없으면 새로운 키-값이 추가된다.
<pre><code>딕셔너리명[키] = 값</code></pre><br/><br/>
### 키-값 삭제하기
- 키와 해당 키에 대응되는 값을 삭제한다.
<pre><code>del 딕셔너리명[키]</code></pre>

<br/><br/><br/><br/>

## 딕셔너리 명령어
### 딕셔너리의 키만 보여 주는 명령어
<pre><code>딕셔너리명.keys()</code></pre><br/><br/>
### 딕셔너리의 값만 보여 주는 명령어
<pre><code>딕셔너리명.values()</code></pre><br/><br/>
### 딕셔너리의 키-값 쌍을 보여 주는 명령어
<pre><code>딕셔너리명.items()</code></pre>

<br/><br/><br/><br/>

## 딕셔너리 정렬하기
### 키
- 오름차순
<pre><code>sorted(딕셔너리명.keys())</code></pre>
<pre><code>sorted(딕셔너리명)</code></pre>
- 내림차순
<pre><code>sorted(딕셔너리명.keys(), reverse=True)</code></pre>
<pre><code>sorted(딕셔너리명, reverse=True)</code></pre><br/><br/>
### 값
- 오름차순
<pre><code>sorted(딕셔너리명.values())</code></pre>
- 내림차순
<pre><code>sorted(딕셔너리명.values(), reverse=True)</code></pre><br/><br/>
### 키-값(키)
- 오름차순
<pre><code>sorted(딕셔너리명.items())</code></pre>
<pre><code>sorted(딕셔너리명.items(), key=operator.itemgetter(0))</code></pre>
- 내림차순
<pre><code>sorted(딕셔너리명.items(), reverse=True)</code></pre>
<pre><code>sorted(딕셔너리명.items(), key=operator.itemgetter(0), reverse=True)</code></pre><br/><br/>
### 키-값(값)
- 오름차순
<pre><code>sorted(딕셔너리명.items(), key=operator.itemgetter(1))</code></pre>
- 내림차순
<pre><code>sorted(딕셔너리명.items(), key=operator.itemgetter(1), reverse=True</code></pre>

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 그래프로 데이터 시각화하기
## 그래프 그리기
<pre><code>import matplotlib.pyplot as plt

plt.rc('font', family='글꼴 이름')
plt.title('그래프 제목')
# 그래프 형태에 따라 알맞은 명령어 넣기
plt.show()</code></pre>

<br/><br/>

## 그래프 유형별 그리기 명령어
### 꺾은선 그래프
<pre><code>plt.plot([x축 리스트], [y축 리스트])</code></pre><br/><br/>
### 막대그래프
<pre><code>plt.bar([x축 리스트], [y축 리스트])</code></pre><br/><br/>
### 가로형 막대그래프
<pre><code>plt.barh([x축 리스트], [y축 리스트])</code></pre><br/><br/>
### 히스토그램
<pre><code>plt.hist([리스트], bins=구간 개수)</code></pre>
- x축, y축을 구분하지 않고 하나의 리스트만 넣는다.<br/><br/>
### 원그래프
<pre><code>plt.pie([리스트])</code></pre>
- x축, y축을 구분하지 않고 하나의 리스트만 넣는다.<br/><br/>
### 산점도
<pre><code>plt.scatter([x축 리스트], [y축 리스트])</code></pre><br/><br/>
### 상자 수염 그림
<pre><code>plt.boxplot([리스트])</code></pre>
- x축, y축을 구분하지 않고 하나의 리스트만 넣는다.
- 상자 수염 그림을 겹쳐 그릴 때는 이차원 리스트로 넣는다.

<br/><br/><br/><br/>

## 그래프 그리기 명령어에 추가 가능한 옵션
### 그래프 색상(그래프 공통)
<pre><code>color='색상 이름'</code></pre>
- 그래프의 색 설정하기
<pre><code>alpha=투명도</code></pre>
- 그래프의 투명도 설정하기<br/><br/>
### 라벨과 범례(그래프 공통)
<pre><code>label='라벨'</code></pre>
- 라벨 표시하기
- 사용 가능한 그래프: 꺾은선 그래프, 막대그래프, 산점도
<pre><code>labels=[라벨]</code></pre>
- 사용 가능한 그래프: 원그래프, 수염 상자 그림<br/><br/>
### 히스토그램
<pre><code>bins=구간 개수</code></pre>
- 히스토그램의 구간 개수 설정하기<br/><br/>
### 원그래프
<pre><code>autopct='%1.1%%'</code></pre>
- 영역별 비율 자동 표시하기<br/><br/>
### 산점도
<pre><code>cmap='컬러맵 이름'</code></pre>
- 컬러맵 적용하기
<pre><code>c='컬러맵을 적용할 데이터'</code></pre>
- 컬러맵을 적용할 데이터 지정하기
<pre><code>s='점의 크기'</code></pre>
- 점의 크기 설정하기

<br/><br/><br/><br/>

## 기타 명령어
### 그래프 크기
<pre><code>plt.figure(dpi=해상도)</code></pre>
- 그래프 크기를 해상도로 설정하기
<pre><code>plt.figure(figsize=가로, 세로)</code></pre>
- 그래프 크기를 인치 단위의 가로, 세로 길이로 설정하기<br/><br/>
### 범례
<pre><code>plt.legend()</code></pre>
- 범례 표시하기<br/><br/>
### 축 이름
<pre><code>plt.xlabel()</code></pre>
- x축 이름 붙이기
<pre><code>plt.ylabel()</code></pre>
- y축 이름 붙이기<br/><br/>
### 눈금 라벨
<pre><code>plt.xticks()</code></pre>
- x축 눈금 라벨 설정하기
<pre><code>plt.yticks()</code></pre>
- y축 눈금 라벨 설정하기<br/><br/>
### 컬러바
<pre><code>plt.colorbar()</code></pre>
- 산점도에 컬러바 표시하기

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터 분석 기초
## 파일 읽어 들이기
<pre><code>import csv               # csv 라이브러리 포함하기

f = open('파일명.csv')   # 파일 열기
data = csv.reader(f)     # 파일 읽기
next(data)               # 표의 헤더 제거하기
data = list(data)        # 리스트로 변환하기</code></pre>

<br/><br/><br/><br/>

## 인코딩 옵션 추가하기
- 파일을 읽을 때 오류가 발생하면 open()에서 encoding 옵션을 추가한다.
<pre><code># encoding 옵션으로 사용할 수 있는 값: utf8, cp949, euc-kr
f = open('파일명.csv' encoding = 'utf8')</code></pre>

<br/><br/><br/><br/>

## 데이터 타입 변환하기
- CSV 파일에서 읽어 들인 데이터는 모두 문자로 인식되므로 연산이 필요하면 int()나 float()로 감싸서 숫자형으로 변환해야 한다.

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 프로젝트 로드맵 그리기
- 프로젝트 목표를 수립하는 단계 → 프로그램을 구현하는 단계 → 프로그램 결과를 분석하는 단계
- 목표 수립 → 구현 → 결과 분석

<br/><br/><br/><br/>

## 프로젝트 목표 수립
- 프로젝트 목표는 프로젝트를 통해 얻고자 하는 결과가 무엇인지를 명확하게 드러내야 한다.
- 프로젝트의 목표를 달성하려면 목표를 실현하기 위한 수단인 하위 목표가 필요하다. 하위 목표는 구체적일수록 좋다.
- 프로젝트 목표 수립 단계에서 목표 수립과 데이터 선정은 순서가 바뀔 수도 있다. 데이터를 먼저 수집하고, 수집된 데이터를 바탕으로 목표를 수립할 수도 있다.

<br/><br/><br/><br/>

## 프로젝트 구현
- 목표를 실제 동작하는 프로그램으로 만드는 단계. 
- 목표 수립 단계에서 프로젝트 목표를 세워도 막상 프로그래밍에 들어가면 머리가 뒤죽박죽 정리되지 않는 경우가 종종 있다. 이러한 상황을 줄이기 위해 코드를 작성하기 전에 알고리즘을 작성한다.
- 우리가 수립한 각각의 하위 목표를 달성할 수 있는 (그래서 프로젝트 목표를 달성해 문제를 해결할 수 있는) 절차를 정리해야 한다. 하위 목표는 프로젝트 목표를 실현하기 위한 수단으로 하위 목표 각각을 알고리즘으로 작성해야 한다.<br/><br/>
### 알고리즘
- 어떤 문제를 해결하기 위해 필요한 절차를 순서대로 표현한 것이다. 알고리즘은 문제, 해결, 절차라는 3가지 키워드만 기억하면 된다. 이 3가지 키워드로 알고리즘을 설명할 수 있다.<br/><br/>

<br/><br/><br/><br/>

## 결과 분석
- 프로그램을 실행해 어떤 결과가 나오면 이 결과를 분석하고 정리해 목표를 달성하는 단계이다.

<br/><br/><br/><br/>

![image](https://user-images.githubusercontent.com/61584142/161433873-cad4a808-e83c-47e6-a3ed-099c691f1866.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 위치 정보 시각화하기: folium
## folium 설치
<pre><code>!pip install folium</code></pre>

<br/><br/><br/><br/>

## folium 지도 만들고 나타내기
<pre><code>지도이름 = folium.Map([위도, 경도], zoom_start=지도비율)
지도이름</code></pre>

<br/><br/><br/><br/>

## folium 마커 만들고 추가하기
<pre><code>folium.Marker([위도, 경도]).add_to(지도이름)</code></pre>

<br/><br/><br/><br/>

## 마커에 추가할 수 있는 옵션
### 툴팁표현
<pre><code>tooltip='표현할 텍스트'</code></pre><br/><br/>
### 팝업표현
<pre><code>popup='표현할 텍스트'</code></pre><br/><br/>
### 아이콘
<pre><code>icon = folium.Icon(color='아이콘 색상', icon='아이콘 모양')</code></pre>
- fontawesome의 아이콘 활용 시 `prefix='fa'` 추가

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 명령어 직접 만들어 사용하기: 사용자 정의 함수
## 사용자 정의 함수 정의하기
<pre><code>def 함수명(매개변수1, 매개변수2):
    함수 내용
    return 반환값</code></pre>

<br/><br/><br/><br/>

## 사용자 정의 함수 호출하기
<pre><code>함수명(매개변수1 = 인자1, 매개변수2 = 인자2)
# 또는
함수명(인자1, 인자2)</code></pre>
- 사용자 정의 함수를 호출할 때는 매개변수에 직접 인자를 대입하거나 매개변수를 생략하고 인자로만 호출하는 두 가지 방법을 사용할 수 있다. 매개변수를 생략하고 인자만 전달하는 경우, 함수를 정의할 때 설정한 매개변수의 순서대로 인자가 차례대로 대입된다.

<br/><br/><br/><br/>

## 사용자 정의 함수의 매개변수에 기본값 설정하기
<pre><code>def 함수명(매개변수1 = 기본값1, 매개변수2 = 기본값2):
    함수 내용
    return 반환값</code></pre>

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 데이터와 함수를 한 단위로 묶어 재사용하기: 클래스와 객체
## 클래스 정의하기
<pre><code>class 클래스명:
    속성1               # 클래스 속성
    속성2               # 클래스 속성
    def __init__(self): # 생성자: 객체 생성과 동시에 실행되는 메서드
        self.속성1      # 인스턴스 속성
        self.속성2      # 인스턴스 속성
    def 메서드(self):</code></pre>

<br/><br/><br/><br/>

## 객체 생성하기
<pre><code>객체명 = 클래스명()</code></pre>

<br/><br/><br/><br/>

## 객체의 속성 사용하기
<pre><code>객체명.속성</code></pre>

<br/><br/><br/><br/>

## 객체에서 메서드 호출하기
- 클래스에 정의된 메서드는 객체명.메서드()로 호출한다. 호출 시 첫 번째 인자로 호출한 객체를 넘긴다. 따라서 클래스에서 메서드를 정의할 때는 첫 번째 매개변수로 self를 항상 넣어야 한다.
<pre><code>객체명.메서드()</code></pre>

<br/><br/><br/><br/>

## 고객계좌 클래스와 은행 클래스를 정의해 금융 거래 프로그램
- 고객계좌 클래스(Customer_account)는 고객이름과 잔고를 속성으로 가지며, 메서드는 없다.
- 은행 클래스(Bank)는 3개의 메서드가 있다. 계좌에 입금하는 deposit(), 계좌에서 출금하는 withdrawal(), 한 계좌에서 다른 계좌로 이체하는 send_money()다.
- 은행 클래스의 각 메서드는 고객계좌 객체와 거래금액을 인자로 전달받아 고객계좌 객체의 거래금액만큼 잔고를 수정한다.
<pre><code># 계좌 클래스
class Customer_account:
    def __init__(self, name, bal):
        self.name = name
        self.balance = bal    # 통장 잔고
        print(self.name, '고객님! 계좌를 개설했습니다. 잔고는', self.balance, '원')

# 은행 클래스
class Bank:
    # 입금 거래, customer에 customer_account 객체 전달
    def deposit(self, customer, amount):
        customer.balance += amount # (가)
        print(customer.name, '고객님', amount, '원 입금')
        print('입금 후 잔고는', customer.balance, '원')

    # 출금 거래, customer에 customer_account 객체 전달
    def withdrawal(self, customer, amount):
        customer.balance -= amount # (나)
        print(customer.name, '고객님', amount, '원 출금')
        print('출금 후 잔고는', customer.balance, '원')

    # 계좌이체 거래, sender와 reciever에 customer_account 객체 전달
    def send_money(self, sender, reciever, amount):
        sender.balance -= amount
        reciever.balance += amount # (다)
        print(sender.name, '고객님이', reciever.name, '고객님께', amount, '원 송금')
        print('이체 후 잔고는', sender.name, sender.balance, '원', reciever.name, reciever.balance, '원')</code></pre>
<pre><code>ryan = Customer_account('라이언', 50000)
prodo = Customer_account('프로도', 100000)
bank_a = Bank()

# 라이언이 15,000원 출금
bank_a.withdrawal(ryan, 15000)

# 프로도가 20,000원 입금
bank_a.deposit(prodo, 20000)

# 프로도가 라이언에게 25,000원 계좌이체
bank_a.send_money(prodo, ryan, 25000)</code></pre>

```
라이언 고객님! 계좌를 개설했습니다. 잔고는 50000 원 
프로도 고객님! 계좌를 개설했습니다. 잔고는 100000 원 
라이언 고객님 15000 원 출금 
출금 후 잔고는 35000 원 
프로도 고객님 20000 원 입금 
입금 후 잔고는 120000 원 
프로도 고객님이 라이언 고객님께 25000 원 송금
이체 후 잔고는 프로도 95000 원, 라이언 60000 원
```

<br/><br/><br/><br/>

## 은행이 거래할 때마다 수수료를 받는다. 다음 조건을 바탕으로 Bank 클래스 정의를 수정하자.
- Bank 클래스에 새로운 인스턴스 속성 commission을 추가하고, 객체 생성 시 commission은 0이 되도록 수정한다.
- 거래 시에는 고객이 입력한 금액(전달된 금액)에서 수수료를 차감한 금액이 최종 거래금액이 된다.
- 거래 시 발생하는 수수료는 은행 객체의 commission에 더한다.
- 입금 거래와 출금 거래는 수수료가 500원이다.
- 계좌이체 거래는 수수료가 800원이다.
<pre><code>class bank:
    def __init__(self):
        self.commission = 0

    def deposit(self, customer, amount):
        self.commission += 500
        customer.balance += (amount - 500)
        print(customer.name, '고객님', amount - 500, '원 입금')
        print('수수료 500원 차감 후 입금')
        print('입금 후 잔고는', customer.balance, '원')

    def withdrawal(self, customer, amount):
        self.commission += 500
        customer.balance -= (amount - 500)
        print(customer.name, '고객님', amount - 500, '원 출금')
        print('수수료 500원 차감 후 출금')
        print('출금 후 잔고는', customer.balance, '원')

    def send_money(self, sender, reciever, amount):
        self.commission += 800
        sender.balance -= (amount - 800)
        reciever.balance += (amount - 800)
        print(sender.name, '고객님이', reciever.name, '고객님께', amount - 800, '원 송금')
        print('수수료 800원 차감 후 송금')
        print('이체 후 잔고는', sender.name, sender.balance, '원', reciever.name, reciever.balance, '원')</code></pre>
        
<pre><code>ryan = Customer_account('라이언', 50000)
prodo = Customer_account('프로도', 100000)
bank_a = bank()

# 라이언이 10,000원 입금
bank_a.deposit(ryan, 10000)

# 프로도가 라이언에게 25,000원 계좌이체
bank_a.send_money(prodo, ryan, 25000)

# 라이언이 30,000원 출금
bank_a.withdrawal(ryan, 30000)

print('은행의 수수료 수입은', bank_a.commission, '원')</code></pre>

```
라이언 고객님! 계좌를 개설했습니다. 잔고는 50000 원 
프로도 고객님! 계좌를 개설했습니다. 잔고는 100000 원 
라이언 고객님 9500 원 입금 
수수료 500원 차감 후 입금 
입금 후 잔고는 59500 원 
프로도 고객님이 라이언 고객님께 24200 원 송금 
수수료 800원 차감 후 송금 
이체 후 잔고는 프로도 75800 라이언 83700 
라이언 고객님 29500 원 출금 
수수료 500원 차감 후 출금 
출금 후 잔고는 54200 원
은행의 수수료 수입은 1800 원
```

---

<br/><br/><br/><br/><br/><br/><br/><br/>

---

# 프로그램 화면 구성하기: tkinter
## tkinter 창 나타내기
<pre><code>from tkinter import *

root = Tk()
# ----- 프로그램 화면 부분 -----
root.mainloop()</code></pre>

<br/><br/><br/><br/>

## tkinter 창 설정하기
### 창의 제목 설정
<pre><code>root.title('창의 제목')</code></pre><br/><br/>
### 창의 크기 설정
<pre><code>root.geometry('가로 크기x세로 크기')</code></pre><br/><br/>
### 창이 나타나는 위치 설정
<pre><code>root.geometry('가로 크기x세로 크기+가로 위치+세로 위치')</code></pre><br/><br/>
### 창 크기 변경가능 여부 설정
<pre><code>root.resizable(너비변경여부, 높이변경여부)</code></pre>
- 변경할 수 있다면 True, 변경할 수 없다면 False

<br/><br/><br/><br/>

## 위젯
### 1) 위젯 만들기
<pre><code># 텍스트 레이블 객체 생성하기
레이블명 = Label(레이블위치, text='텍스트')
# 이미지 레이블 객체 생성하기
이미지명 = PhotoImage(file='이미지 파일')
레이블명 = Label(레이블위치, image=이미지저장변수)
# 버튼 객체 생성
버튼명 = Button(버튼위치, text='버튼에 나타낼 텍스트')
# 엔트리 객체 생성
엔트리명 = Entry(입력칸위치)
    # 콤보박스 객체 생성 
    from tkinter.ttk import * 
    콤보박스명 = Combobox(콤보박스위치, values='콤보박스에 나타낼 값(리스트)') 
    # 정보제공 메시지박스 띄우기 
    from tkinter.messagebox import * 
    showinfo(title='메시지 창 제목', message='나타낼 메시지') 
    # 오류 메시지박스 띄우기 
    from tkinter.messagebox import * 
    showerror(title='메시지 창 제목', message='나타낼 메시지')</code></pre><br/><br/>
### 2) 위젯에 공통으로 적용할 수 있는 옵션
#### 위젯 너비 설정
<pre><code>width=너비</code></pre><br/><br/>
#### 위젯 높이 설정
<pre><code>height=높이</code></pre><br/><br/>
#### 위젯 내 텍스트 또는 이미지 정렬
<pre><code>anchor=정렬방식</code></pre>
- center, e, w, s, n, se, sw, ne, nw<br/><br/>
#### 테두리 설정
<pre><code>relief=테두리모양</code></pre>
- flat, groove, raised, ridge, solid, sunken<br/><br/>
#### 테두리 두께 설정
<pre><code>borderwidth=테두리두께</code></pre>

<br/><br/>

### 3) 위젯에 추가로 적용할 수 있는 옵션과 명령어
#### 버튼
- 이벤트 설정 옵션
<pre><code>command=함수명</code></pre><br/><br/>
#### 콤보박스
- 콤보박스에 보여 줄 값 설정
<pre><code>콤보박스명.current(숫자)</code></pre>
- 콤보박스에 새로운 값 설정
<pre><code>콤보박스명['values'] = 리스트</code></pre>

<br/><br/><br/><br/>

## 위젯 배치하기
### 절대위치
#### place()
<pre><code>위젯명.place(x=x좌표, y=y좌표)</code></pre>
- 좌표를 숫자로 직접 입력<br/><br/>
### 상대위치
#### pack()
<pre><code>위젯명.pack()</code></pre>
- 위젯 간 상대위치 사용
- 위치 설정 옵션 side
#### grid()
<pre><code>위젯명.grid(row=행, column=열)</code></pre>
- 격자를 활용한 상대위치 사용

<br/><br/><br/><br/>

## tkinter를 활용한 퀴즈 프로그램
<pre><code>from tkinter import *

sayhello = ['안녕하세요', 'hello', '니하오', '봉쥬르']
idx = 0

# ----- 프로그램 기능 부분 ----------
def plus():
    global idx
    idx = (idx + 1) % 4
    hello_txt.set(sayhello[idx])

def minus():
    global idx
    idx = (idx - 1) % 4
    hello_txt.set(sayhello[idx])

# ----- 프로그램 화면 부분 -----
root = Tk()
root.geometry('250x100')

btn_minus = Button(root, text='<--', command=minus, width=5)
btn_minus.grid(row=0, column=0)

hello_txt = StringVar()
hello_lbl = Label(root, textvariable=hello_txt, width=20)
hello_lbl.grid(row=0, column=1)
btn_plus = Button(root, text='-->', command=plus, width=5)
btn_plus.grid(row=0, column=2)

root.mainloop()

# ----- 제출 버튼과 연결되는 이벤트 -----
def summit():
    correct = 0   # 정답을 맞힌 문제 개수를 저장하는 변수

    if combo1.get() == 'O':
        correct += 1
    if combo2.get() == 'X':
        correct += 1
    if combo3.get() == 'O':
        correct += 1
    # 최종 결과 안내문 만들기
    report = str(correct) + '문제 맞혔습니다.'
    result.set(report)</code></pre>
