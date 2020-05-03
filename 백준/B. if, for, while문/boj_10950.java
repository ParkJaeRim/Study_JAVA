package baekjoon;

import java.util.Scanner;

public class boj_10950 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		int T = scanner.nextInt();
		
		for(int x = 1; x <= T; x++ ) {
			int A= scanner.nextInt();
			int B= scanner.nextInt();
			System.out.println(A+B);
		}
	}
}
