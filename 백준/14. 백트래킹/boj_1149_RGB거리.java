package net.acmicpc;

import java.util.Scanner;

public class boj_1149_RGB거리 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[][] lst = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				lst[i][j] = scanner.nextInt();
			}
		}

		for (int x = 1; x < N; x++) {
			lst[x][0] += Math.min(lst[x - 1][1], lst[x - 1][2]);
			lst[x][1] += Math.min(lst[x - 1][0], lst[x - 1][2]);
			lst[x][2] += Math.min(lst[x - 1][0], lst[x - 1][1]);
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (ans > lst[N - 1][i]) {
				ans = lst[N - 1][i];
			}
		}
		System.out.println(ans);
	}
}
