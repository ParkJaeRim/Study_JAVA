package com.swea;

import java.util.Scanner;

public class Solution_D3_7236 {
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int s = scanner.nextInt();
			int N = s + 2;
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				map[i][0] = 'G';
				map[i][N - 1] = 'G';
				map[0][i] = 'G';
				map[N - 1][i] = 'G';
			}
			for (int i = 1; i <= s; i++) {
				for (int j = 1; j <= s; j++) {
					map[i][j] = scanner.next().charAt(0);
				}
			}
			int MAX = Integer.MIN_VALUE;
			int cnt = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 'W') {
						cnt = 0;
						for (int d = 0; d < dx.length; d++) {
							if (x + dx[d] < N && x + dx[d] >= 0 && y + dy[d] >= 0 && y + dy[d] < N
									&& map[x + dx[d]][y + dy[d]] == 'W') {
								cnt++;
							}
						}
					}
					if (cnt == 0) {
						cnt = 1;
					}
					MAX = MAX > cnt ? MAX : cnt;
				}
			}
			System.out.println("#" + tc + " " + MAX);
		}
	}
}
