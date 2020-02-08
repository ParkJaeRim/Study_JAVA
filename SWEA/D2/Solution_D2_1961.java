package com.swea;

import java.util.Scanner;

public class Solution_D2_1961 {
	static int T, N;
	static int[][] map;
	static int[][] map_90, map_180, map_270;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			map = new int[N][N];
			map_90 = new int[N][N];
			map_180 = new int[N][N];
			map_270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			turn90(map);
			turn180(map_90);
			turn270(map_180);

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map_90[i][j]);

				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(map_180[i][j]);

				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(map_270[i][j]);
				}
				System.out.print(" ");
				System.out.println();
			}
		}
	}

	public static void turn90(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_90[i][j] = map[N - 1 - j][i];
			}
		}
	}

	public static void turn180(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_180[i][j] = map[N - 1 - j][i];
			}
		}
	}

	public static void turn270(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_270[i][j] = map[N - 1 - j][i];
			}
		}

	}
}
