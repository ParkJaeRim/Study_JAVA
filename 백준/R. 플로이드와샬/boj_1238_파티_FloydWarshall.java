package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1238_파티_FloydWarshall {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int party = scanner.nextInt();

		int[][] map = new int[N + 1][N + 1];

		int INF = 987654321;

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], INF);
		}

		for (int i = 0; i < M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int value = scanner.nextInt();
			map[a][b] = value;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int k = 0; k < N + 1; k++) {
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < N + 1; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == INF) {
					map[i][j] = 0;
				}
			}
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < map.length; i++) {
			if (i != party) {
				ans = Math.max(ans, map[i][party] + map[party][i]);
			}
		}
		System.out.println(ans);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
