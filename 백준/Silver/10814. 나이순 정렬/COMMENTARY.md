### 백준 10814 나이순 정렬

**우선순위큐, 정렬을 이용한 문제**

나이순으로 회원들을 정렬, 나이가 같으면 먼저 가입한 사람이 앞에 오도록 정렬한다. 나는 우선순위큐 최소힙을 이용하여 문제를 해결했다. Comparable인터페이스를 구현하여 compareTo를 오버라이딩하여 최소힙에 나이, 이름, 순서로 구성된 Student 클래스 노드를 삽입하면 된다. 

여기서 가장 중요한 점은 compareTo를 오버라이딩하는 것이였다.  삽입 연산은 upheap연산이기 때문에 우선순위를 잘 맞추는 것이 중요하였다. 

정답 코드

```java
public int compareTo(Student s) {
        if (this.age < s.age) 
                return -1;
        else if (this.age > s.age) 
                return 1;
        else if (this.age == s.age) 
                return this.order < s.order ? -1 : 1;
                                                                    
        return 0;
}
```

처음에는 아래와 같은 코드로 작성했다.

```java
        if(this.age<s.age)
                return -2;  
        else if(this.age==s.age){
                if(this.order<s.order)
                        return -1;
                else
                        return 0;
        }
        else
                return 1;
```

예제의 경우에는 문제가 없었는데 통과되지 못하였다. upheap연산 과정에서 우선순위에서 문제가 생긴 것 같다. 아무래도 compareTo에 대해 잘못 이해하고 있어서 별다른 생각없이 코드를 작성한게 발목을 잡았다.
