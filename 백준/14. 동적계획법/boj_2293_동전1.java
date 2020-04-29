package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2293_동전1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int v = scanner.nextInt();
		int[] coin = new int[N];
		int[][] d = new int[N][v + 1];

		for (int i = 0; i < N; i++) {
			coin[i] = scanner.nextInt();
			d[i][0] = 1;
		}
		Arrays.sort(coin);

		for (int i = 1; i <= v; i++) {
			if (i % coin[0] == 0) {
				d[0][i] = 1;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < v + 1; j++) {
				if (j - coin[i] < 0) {
					d[i][j] = d[i - 1][j];
				} else {
					d[i][j] = d[i - 1][j] + d[i][j - coin[i]];
				}
			}
		}
		System.out.println(d[N - 1][v]);
	}
}
