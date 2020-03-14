package net.acmicpc;

import java.util.Scanner;

public class boj_9461_파도반수열 {

	static long[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {

			int N = scanner.nextInt();
			d = new long[N + 1];

			long result = dp(N);
			System.out.println(result);
		}
	}

	public static long dp(int n) {
		if (n == 1 || n == 2 || n == 3)
			return 1;

		if (d[n] > 0) {
			return d[n];
		}
		d[n] = dp(n - 2) + dp(n - 3);

		return d[n];
	}
}