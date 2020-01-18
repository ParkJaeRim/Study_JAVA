package baekjoon;

import java.util.Scanner;

public class boj_10809 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String S = scanner.next();
		
		for (char i ='a'; i<='z'; i++) {
			System.out.print(S.indexOf(i)+" ");
		}
	}

}
