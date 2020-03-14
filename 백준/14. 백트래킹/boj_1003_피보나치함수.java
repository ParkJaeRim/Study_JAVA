package net.acmicpc;

import java.util.Scanner;

public class boj_1003_피보나치함수 {
	static long[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {

			int N = scanner.nextInt();

			d = new long[41];

			long cnt0 = dp0(N);

			d = new long[41];
			long cnt1 = dp1(N);

			System.out.println(cnt0 + " " + cnt1);

		}
	}

	public static long dp0(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 0;
		}

		if (d[n] > 0) {
			return d[n];
		}

		d[n] = dp0(n - 1) + dp0(n - 2);
		return d[n];
	}

	public static long dp1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if (d[n] > 0) {
			return d[n];
		}

		d[n] = dp1(n - 1) + dp1(n - 2);
		return d[n];
	}
}
