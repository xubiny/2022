# Collection
- Collection의 주요 인터페이스 - List, Set, Map <br/><br/>
  - List : 순서 O, 데이터중복 O <br/><br/>
  - Set : 순서 X, 데이터중복 X <br/><br/>
  - Map : Key&Value 저장, Key중복 X, Value중복 O <br/><br/>

<br/>

### 1. 일괄된 API
- Collection의 일관된 API를 사용하여 Collection 밑에 있는 모든 클래스(ArrayList, Vector, LinkedList 등) Collection에서 상속받아 통일된 메서드를 사용하게 된다. <br/><br/>

### 2. 프로그래밍 노력 감소
- 객체 지향 프로그래밍의 추상화의 기본 개념이 성공적으로 구현되어있다. <br/><br/>

### 3. 프로그램 속도 및 품질 향상
- 유용한 데이터 구조 및 알고리즘은 성능을 향상시킬 수 있다. Collection을 사용하여 최상의 구현을 생각할 필요없이 간단하게 Collection API를 사용하여 구현을 하면 된다. <br/><br/>

- java.util.Collection

<br/><br/>

## Set
- 순서를 유지하지 않는 데이터의 집합으로 데이터의 중복을 허용하지 않는다. <br/><br/>

<br/>

### HashSet
- 가장 빠른 임의 접근 속도 <br/><br/>
- 순서를 예측할 수 없음 <br/><br/>

<br/>

### TreeSet
- 정렬방법을 지정할 수 있음 <br/><br/>

<br/><br/>

## List
- 순서가 있는 데이터의 집합으로 데이터의 중복을 허용한다. <br/><br/>
- 데이터를 순서에 맞게 일렬로 구성하는데, 인덱스가 부여되기 때문에 인덱스로 검색할 수 있다. <br/><br/>
- Set과는 다르게 중복을 허용한다.<br/><br/>

<br/>

### List 인터페이스를 구현한 클래스
- ArrayList <br/><br/>
- AttributeList <br/><br/>
- CopyOnWriteArrayList <br/><br/>
- LinkedList <br/><br/>
- RoleList <br/><br/>
- RoleUnresolvedList <br/><br/>
- Stack <br/><br/>
- Vector <br/><br/>

<br/>

### LinkedList
- 양방향 포인터 구조로 데이터의 삽입, 삭제가 빈번할 경우 데이터의 위치정보만 수정하면 되기에 유용 <br/><br/>
- 스택, 큐, 양방향 큐 등을 만들기 위한 용도로 쓰임 <br/><br/>

<br/>

### Vector
- 과거에 대용량 처리를 위해 사용했으며, 내부에서 자동으로 동기화처리가 일어나 비교적 성능이 좋지 않고 무거워 잘 쓰이지 않음 <br/><br/>

<br/>

### ArrayList
- 단방향 포인터 구조로 각 데이터에 대한 인덱스를 가지고 있어 조회 기능에 성능이 뛰어남 <br/><br/>
- ArrayList는 resizable-array이다. 즉, 저장 용량이 자동으로 늘어난다. 기본 생성자로 ArrayList를 생성하면 10개의 객체 저장 용량을 갖는다. 처음부터 용량을 크게 잡을 수 있다. <br/><br/>

<pre><code>List myList = new ArrayList(100);
myList.add("Eddy.Kim");
String name = (String)list.get(0);</code></pre>

<br/>

- ArrayList는 Object 타입으로 변환되어 저장되기 때문에, 모든 종류의 객체를 저장할 수 있다. 하지만, 저장 및 조회할 때 Object로 변환해야 하므로 성능이 좋지는 않다. 이런 단점을 보완하는 것이 바로 제네릭이다. <br/><br/>

```
List<String> myList = new ArrayList<String>();
myList.add("Eddy.Kim");
String name = list.get(0);
```

<br/>

## Queue
- List와 유사 <br/><br/>

<br/>

### LinkedList

<br/>

### PiriorityQueue

<br/><br/>

## Map
- Collection 인터페이스를 상속받고 있지는 않지만 Collection으로 분류된다. <br/>
- 키(key), 값(value)의 쌍으로 이루어진 데이터의 집합으로, 순서는 유지되지 않으며 키(key)의 중복을 허용하지 않으나 값(value)의 중복은 허용한다. <br/>

<br/>

#### java.util.Map

<br/><br/>

### Hashtable
- HashMap보다는 느리지만 동기화 지원 <br/>
- null 불가<br/>

<br/>

### HashMap	
- 중복과 순서가 허용되지 않으며 null값이 올 수 있다. <br/>

<br/>

### TreeMap	
- 정렬된 순서대로 카(Key)와 값(Value)을 저장하여 검색이 빠름 <br/>

<br/>







