package net.acmicpc;

import java.util.Scanner;

public class boj_9507_GenerationsofTribbles {
	static int N;
	static long[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = scanner.nextInt();
			arr = new long[68];
			arr[0] = arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			System.out.println(dp(N));
		}
	}

	public static long dp(int n) {
		if (arr[n] > 0) {
			return arr[n];
		}
		if (n >= 4) {
			arr[n] = dp(n - 1) + dp(n - 2) + dp(n - 3) + dp(n - 4);
			return arr[n];
		}
		
		return arr[n];
	}
}
