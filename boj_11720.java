package baekjoon;

import java.util.*;

public class boj_11720 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		String st = scanner.next();
		int lst[] = new int[N];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			lst[i]= Integer.parseInt(st.substring(i,i+1));
			sum += lst[i];
		}
		System.out.print(sum);
	}	
}
