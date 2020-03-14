package net.acmicpc;

import java.util.Scanner;

public class boj_1904_01타일링 {

	static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		d = new int[N + 1];

		int result = dp(N);
		System.out.println(result);
	}

	public static int dp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (d[n] > 0) {
			return d[n];
		}

		d[n] = dp(n - 1) + dp(n - 2);
		d[n] = d[n] % 15746;

		return d[n];
	}
}
