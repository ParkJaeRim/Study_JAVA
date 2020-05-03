package net.acmicpc;

import java.util.Scanner;

public class boj_2748_피보나치수2 {

	static long[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		d = new long[N + 1];

		long result = dp(N);
		System.out.println(result);
	}

	public static long dp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1)
			return 1;

		if (d[n] > 0) {
			return d[n];
		}
		d[n] = dp(n - 1) + dp(n - 2);

		return d[n];
	}
}