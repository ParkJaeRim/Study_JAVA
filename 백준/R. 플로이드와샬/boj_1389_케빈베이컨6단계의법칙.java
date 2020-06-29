package net.acmicpc;

import java.util.Scanner;

public class boj_1389_케빈베이컨6단계의법칙 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 10000;
			}
		}

		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			map[start - 1][end - 1] = Math.min(map[start - 1][end - 1], 1);
			map[end - 1][start - 1] = Math.min(map[end - 1][start - 1], 1);
		}

		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int[] cnt = new int[N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i != j && map[i][j] != 10000) {
					cnt[i] += map[i][j];
				}
			}
		}
		int tmp = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] < tmp) {
				tmp = cnt[i];
				ans = i;
			}
		}
		System.out.println(ans + 1);
	}
}