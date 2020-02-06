package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_10818 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		ArrayList lst = new ArrayList(4);
		
		for(int i=0; i<N; i++) {
			lst.add(scanner.nextInt());
		}
		
		Collections.sort(lst);
		
		int MAX = (int) lst.get(0);
		int MIN = (int) lst.get(N-1);
		System.out.printf("%d %d", MAX, MIN);		
	}

}
