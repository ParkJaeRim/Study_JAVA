package net.acmicpc;

import java.util.Scanner;

public class boj_8958 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			String s = scanner.next();
			boolean[] S = new boolean[s.length()];

			int temp = 0;
			int result = 0;
			for (int j = 0; j < S.length; j++) {
				if (s.charAt(j) == 'O') {
					temp += 1;
				} else {
					temp = 0;
				}
				result += temp;
			}
			System.out.println(result);
		}
	}
}
