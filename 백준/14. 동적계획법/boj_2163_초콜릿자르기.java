package net.acmicpc;

import java.util.Scanner;

public class boj_2163_초콜릿자르기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] d = new int[N + 1][M + 1];

		d[1][1] = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (i == 1 || j == 1) {
					int max = Math.max(i, j);
					d[i][j] = max - 1;
				} else if (d[i][j] == 0) {
					if (i < j) {
						d[i][j] = d[i][j - 1] + d[i][1] + 1;
					} else {
						d[i][j] = d[i - 1][j] + d[1][j] + 1;
					}
				}
				System.out.println("WOW : " + d[i][j] + " " + i + " " + j);
			}
		}
		System.out.println(d[N][M]);
	}
}
