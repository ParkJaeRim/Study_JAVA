package baekjoon;

import java.util.Scanner;

public class boj_2908 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		
		A = (A%10)*100 + (A/10)%10*10 + (A/100);
		B = (B%10)*100 + (B/10)%10*10 + (B/100);
		
		if (A >= B) {
			System.out.print(A);
		}
		else {
			System.out.print(B);
		}
	}

}
