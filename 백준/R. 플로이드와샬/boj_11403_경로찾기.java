package net.acmicpc;

import java.util.Scanner;

public class boj_11403_경로찾기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
				map[i][j] = map[i][j] == 0 ? 100000 : 1;
			}
		}

		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 100000) {
					System.out.print(0+" ");
				}else
				System.out.print(1+ " ");
			}
			System.out.println();
		}
	}
}