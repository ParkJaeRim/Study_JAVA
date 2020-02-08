package com.swea;

import java.util.Scanner;

public class Solution_D2_1979_no {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int[][] map;
	static int cnt, T, K, result, y, x;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			K = scanner.nextInt();
			map = new int[N][N];
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scanner.nextInt();

				}
			}
			// 시작점(y,x) 찾는 것 넣어줘야 함
			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					if (map[m][n] == 1) {
						y = m;
						x = n;
						System.out.println(y + " " + x);
					}
					for (int d = 0; d < dx.length; d++) {
						if (d == 0) {
							cnt = 0;
//						if (d == 0 && x - dx[d] >= 0 && map[y][x - dx[d]] == 0) {
							while (x + dx[d] < N  && map[y][x + dx[d]] == 1) {
								cnt++;
								x += dx[d];
								System.out.println("가로" + cnt);
							}
						} else if (d == 1) {
							cnt = 0;
//						} else if (d == 1 && y - dy[d] >= 0 && map[y - dy[d]][x] == 0) {
							while ( y + dy[d] < N && map[y + dy[d]][x] == 1) {
								cnt++;
								y += dy[d];
								System.out.println("세로" + cnt);
							}
						}
						if (cnt == K) {
							result += 1;
						}
					}
				}

			}
			System.out.println(result);
		}
	}
}
