package net.acmicpc;

import java.util.Scanner;

public class boj_1010_다리놓기 {
	static int N, M;
	static int[][] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 0; tc < T; tc++) {
			N = scanner.nextInt();
			M = scanner.nextInt();

			d = new int[N+1][M + 1];
			for (int x = 1; x < M+1; x++) {
				d[1][x] = x;
			}

			for (int i = 2; i < N+1; i++) {
				for (int j = 0; j < M + 1; j++) {
					for (int k = 0; k < j; k++) {
						d[i][j] += d[i - 1][k];
					}
				}
			}
			System.out.println(d[N][M]);
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
