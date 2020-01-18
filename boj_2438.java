package baekjoon;

import java.util.Scanner;

public class boj_2438 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int line = scanner.nextInt();
		
		for (int i=1; i<= line; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print('*');
			}
			System.out.print('\n');
		}

	}

}