# 2020/01/15

### 1) 
백준에서 Java 문제를 풀 경우, class는 Main으로 바꾸어 제출하기

파일 명명법 : boj_문제번호.java  

---
  

### 2)


```java
// java 입력 받기

    import java.util.Scanner;

    public class boj_1000 {
        	public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int a = scanner.nextInt();
		    int b = scanner.nextInt();
		    scanner.close();
		
		    System.out.println(a+b);
            }
    }

```

scanner.nextInt() = int값 리턴

scanner.close() = 꼭 스캐너 사용 종료 해주기

__https://mine-it-record.tistory.com/103__ (참고★)


---

# 2020/01/16

### 1) 
```java
// java 한 줄에 여러(아래 예시는 3개) 항목 입력 받기

    import java.util.Scanner;

    public class boj_1000 {
        	public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int lst[] = new int[3];
		    
		    for (int i=0; i<3; i++){
		    	lst[i] = scanner.nextInt();
		    }
		}
        }

```
