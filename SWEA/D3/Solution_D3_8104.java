package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_8104 {
	static int[] dy = { 0, 0 };
	static int[] dx = { 1, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int K = scanner.nextInt();
			int N = scanner.nextInt();
			int[][] map = new int[K][N];
			for (int j = 0; j < map.length; j++) {
				Arrays.fill(map[j], 1);
			}
			int deung = 1;
			int y = 0;
			int x = 0;
			int d = 0;
			System.out.print("#" + tc  +" ");
			while (y < K && map[y][x] == 1) {
				if (d == 0) {
					if (x + dx[d] < N && map[y][x + dx[d]] == 1) {
						map[y][x] = deung;
						deung++;
						x += dx[d];
					} else {
						map[y][x] = deung;
						deung++;
						y += 1;
						d = 1;
						x = N - 1;

					}
				} else if (d == 1) {
					if (x + dx[d] >= 0 && map[y][x + dx[d]] == 1) {
						map[y][x] = deung;
						deung++;
						x += dx[d];
					} else {
						map[y][x] = deung;
						deung++;
						y += 1;
						d = 0;
						x = 0;
					}
				}
			}
			for (int n = 0; n < N; n++) {
				int sum = 0;
				for (int m = 0; m < K; m++) {
					sum += (map[m][n]);
				}
				System.out.print(sum+ " ");
			}
			System.out.println();
		}

	}

}
