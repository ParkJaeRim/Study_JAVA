package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_9095_123더하기 {
	static int[] num, arr;
	static int N, T, ans;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		num = new int[] { 1, 2, 3 };

		for (int tc = 0; tc < T; tc++) {
			N = scanner.nextInt();
			arr = new int[N + 1];
			ans = 0;
			nCr(0, 0);
			System.out.println(ans);
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
			if (sum == N) {
				ans++;
			}
		}

		for (int i = start; i < 3; i++) {
			arr[cnt] = num[i];
			nCr(start, cnt + 1);
		}
	}
}
