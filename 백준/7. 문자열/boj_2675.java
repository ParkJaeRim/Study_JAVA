package baekjoon;

import java.util.Scanner;

public class boj_2675 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int i=0; i<T; i++) {
			int R = scanner.nextInt();
			String S = scanner.next();
			
			int len = S.length();
			String lst[] = new String[len];
			
			for (int j=0; j<len; j++) {
				lst[j] = S.substring(j,j+1);
			
				for (int k=0; k<R; k++) {
					System.out.print(lst[j]);
				}
			}
			System.out.println();
		}
	}
}
