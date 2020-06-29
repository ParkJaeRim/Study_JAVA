package net.acmicpc;

import java.util.Scanner;

public class boj_2606_바이러스 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = 10000;
			}
		}
		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			map[start - 1][end - 1] = Math.min(map[start - 1][end - 1], 1);
			map[end - 1][start - 1] = Math.min(map[end - 1][end - 1], 1);
		}

		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (i != k || j != k) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						map[j][i] = map[i][j];
					}
				}
			}
		}
		int cnt = 0;
		for (int j = 0; j < map.length; j++) {
			if (0 != j && map[0][j] != 10000) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
