package com.swea;

import java.util.Scanner;

public class Solution_D3_7234 {

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int s = scanner.nextInt();
			int N = s + 2;
			int[][] lst = new int[N][N];
			int[][] map = new int[N][N];
			int MAX = Integer.MIN_VALUE;
			int B = scanner.nextInt();

			for (int b = 0; b < B; b++) {
				int y = scanner.nextInt();
				int x = scanner.nextInt();
				map[y][x]++;

				for (int d = 0; d < dy.length; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					int ny2 = ny + dy[d];
					int nx2 = nx + dx[d];

					if (ny < N && ny >= 0 && nx < N && nx >= 0) {
						map[ny][nx]++;
					}

					if (ny2 < N && ny2 >= 0 && nx2 < N && nx2 >= 0) {
						map[ny2][nx2]++;
					}

				}
				for (int i = 1; i < s; i++) {
					for (int j = 1; j < s; j++) {
						MAX = MAX > map[i][j] ? MAX : map[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " +MAX);
		}
	}
}
