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

---

# 2020/01/16

### 1) 
```java
// 2020/01/15의 1번 항목은 리스트에 값을 받아오지만, 오늘은 다른 방법을 알았다!
// 굳이 리스트에 입력안해도 됐었다.....
// 입력 2개를 받아보기!

    import java.util.Scanner;

    public class boj_1000 {
        	public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int A = scanner.nextInt();
		    int B = scanner.nextInt();
		    }
	    }
      }

// 이게 끝...

```

### 2) About BufferedReader(입력) & BufferedWriter(출력)
: 버퍼를 이용하는 함수.
: 많은 양의 데이터를 받을 경우 좋음. 작업속도도 차이가 많이 남.

#### ㄱ. Buffered Reader
: scanner는 Space와 Enter 모두를 경계로 인식하지만, Buffered Reader는 Enter만 경계로 인식함.
: 입력받은 데이터는 String으로 고정되어 타입변환이 필수


```java

//선언 후, 값 입력
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine();
int i = Integer.parseInt(br.readLine(); //Integer.parseInt()를 이용하여 형변환

```

: scanner는 Space도 경계값으로 인식하여공백 다음 숫자를 받지만, Buffer는 아님.
  따라서, StringTokenizer를 이용.
  
```java

BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

int T = Integer.parseInt(st.nextToken());
int N = Integer.parseInt(st.nextToken());

```

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
String str = "kkk"
bw.write(str); //개행 불가
bw.flush(); // 남은 데이터 출력
bw.close(); // 종료
