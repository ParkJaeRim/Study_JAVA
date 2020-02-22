package com.swea;

import java.util.Scanner;

public class Solution_D3_2817 {
	static int T, N, R;
	static int[] lst, arr;
	static int x;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			R = scanner.nextInt();
			lst = new int[N];
			arr = new int[N + 1];

			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			x = 0;
			nCr(0, 0);
			System.out.println("#" + tc + " " + x);
		}

	}

	public static void nCr(int start, int cnt) {
		if (cnt > N) {
			return;
		}
		if (N >= cnt) {
			int sum = 0;
			for (int i = 0; i < cnt; i++) {
				sum += arr[i];

			}
			if (sum == R) {
				x++;
			}
		}

		for (int i = start; i < N; i++) {
			arr[cnt] = lst[i];
			nCr(i + 1, cnt + 1);
		}
	}

}
