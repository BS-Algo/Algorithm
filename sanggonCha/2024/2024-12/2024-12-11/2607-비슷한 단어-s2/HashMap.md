# HashMap의 특징
`HashMap`은 Java의 컬렉션 프레임워크에서 제공하는 자료구조로, 키(key)와 값(value) 쌍으로 데이터를 저장하는 해시 테이블 기반의 데이터 구조다ㅡ.
Python의 딕셔너리와 비슷한 역할을 한다

### 1. 키-값 쌍으로 데이터 저장
- 각 키는 유일하며, 중복된 키는 존재할 수 없다.
- 값은 중복될 수 있다

### 2. 빠른 데이터 접근
- 키를 통해 값을검색하는 시간 복잡도는 평균 `O(1)`이다.
- 해시 함수를 사용해 데이터를 저장하기 때문에 빠르게 접근할 수 있다

### 3. 순서를 보장하지 않는다
- 입력된 순서와 출력되는 순서는 다를 수 있다
- 만약 순서를 보장하고 싶다면 `LinkedHashMap`을 사용해야 한다

### 4. null 허용
- `null` 키는 하나만 허용하며, `null` 값은 여러 개 저장할 수 있다


# HashMap 사용법
### 1. 선언 및 초기화
```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
```

### 2. 데이터 추가 (`put`)
```java
map.put("apple", 3);
map.put("banana", 5);
map.put("cherry", 2);
```

### 3. 데이터 가져오기 (`get`)
```java
System.out.println(map.get("apple")); // 출력: 3
```
- 존재하지 않는 키를 `get`하면 `null`을 반환한다.

### 4. 키가 존재하는지 확인 (`containsKey`)
```java
if (map.containsKey("banana")) {
    System.out.println("Key 'banana' exists!");
}
```

### 5. 값이 존재하는지 확인 (`containsValue`)
```java
if (map.containsValue(5)) {
    System.out.println("Value 5 exists!");
}
```

### 6. 데이터 삭제(`remove`)
```java
map.remove("cherry");
```

### 7. 전체 데이터 순회 (`keySet` 또는 `entrySet`)
```java
// 키만 순회
for (String key : map.ketSet()) {
    System.out.println(key + ": " + map.get(key));
}

// 키-값 쌍으로 순회
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### 8. 크기 확인 (`size`)
```java
System.out.println(map.size()); // 출력: 3
```

### 9. 초기화 및 비우기 (`clear`)
```java
map.clear();
```

###  예제 코드
```java
import java.util.HashMap;
import java.util.Map;

public Static Main {
    public static void main(String[] args) throws IOException {
        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 데이터 추가
        map.put("Java", 85);
        map.put("Python", 90);
        map.put("C++", 80;);

        // 데이터 가져오기
        System.out.println("Java 점수: " + map.get("Java"));

        // 데이터 존재 여부 확인
        if (map.containsKey("Python")) {
            System.out.println("Python 점수가 있습니다.");
        }

        // 데이터 삭제
        map.remove("C++");

        // 전체 데이터 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

### 출력
```
Java 점수: 85
Python 점수가 있습니다.
Java: 85
Python: 90
```

### HashMap 주의사항
1. 키는 유일해야 한다.
    - 중복된 키로 `put`하면 기존 값이 덮어씌워진다
2. 동기화되지 않는다.
    - 멀티 스레드 환경에서 사용할 경우 `Collections.synchronizedMap`을 사용하거나 `ConcurrentHashMap`을 사용해야 한다.
3. 순서를 보장하지 않는다.
    - 입력된 순서대로 저장되지 않는다.
    - 순서가 중요한 경우 `LinkedHashMap`이나 `TreeMap`을 사용한다