package net.acmicpc;

import java.util.Scanner;

public class boj_2567 {
	static int len = 100;
	static int[][] lst = new int[len + 20][len + 20];
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		for (int i = 0; i < N; i++) {
			int y = scanner.nextInt();
			int x = scanner.nextInt();

			for (int m = 0; m < 10; m++) {
				for (int n = 0; n < 10; n++) {
					lst[y + m][x + n] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < len + 20; i++) {
			for (int j = 0; j < len + 20; j++) {
				if (lst[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (nx < len + 20 && nx >= 0 && ny >= 0 && ny < len + 20 && lst[i + dy[d]][j + dx[d]] == 0) {
							cnt++;
						}
					}
				}
			}

		}
		System.out.println(cnt);
	}
}
