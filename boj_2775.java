package net.acmicpc;

import java.util.Scanner;

public class boj_2775 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {


			int K = scanner.nextInt();
			int N = scanner.nextInt();
			int[][] apart = new int[K + 1][N];

			for (int m = 0; m <= K; m++) {
				for (int n = 0; n < N; n++) {
					if (m == 0) {
						apart[m][n] = n + 1;
					} else {
						for (int k = n; k >= 0; k--) {
							apart[m][n] += apart[m - 1][k];
						}
					}
				}
			}
			System.out.print(apart[K][N - 1] + " ");
		}
	}
}
