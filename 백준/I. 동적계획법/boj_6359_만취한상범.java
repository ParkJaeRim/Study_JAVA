package net.acmicpc;

import java.util.Scanner;

public class boj_6359_만취한상범 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = scanner.nextInt();
			int[] lst = new int[N];
			int[][] d = new int[N + 1][N];

			for (int i = 0; i < N; i++) {
				d[0][i] = 1;
			}

			for (int i = 1; i < d.length; i++) {
				for (int j = 0; j < N; j++) {
					if ((j + 1) % i == 0) {
						if (d[i - 1][j] == 1) {
							d[i][j] = 0;
						} else {
							d[i][j] = 1;
						}
					} else {
						d[i][j] = d[i - 1][j];
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (d[N][i] == 0) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j] + " ");
			}
			System.out.println();
		}
	}

}
