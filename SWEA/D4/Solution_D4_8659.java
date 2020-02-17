package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_8659 {
	static int T, cnt, K;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			K = scanner.nextInt();
			long lst[] = new long[92];
			lst[0] = 1L;
			lst[1] = 1L;
			lst[2] = 2L;
			for (int i = 3; i < lst.length; i++) {
				lst[i] = lst[i - 1] + lst[i - 2];
			}
			System.out.println("#"+ tc + " " + lst[K+1] + " " + lst[K]);

		}
	}
}