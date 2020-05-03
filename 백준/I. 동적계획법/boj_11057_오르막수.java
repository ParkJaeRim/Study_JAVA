package net.acmicpc;

import java.util.Scanner;

public class boj_11057_오르막수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[][] d = new int[N][10];

		for (int i = 0; i < 10; i++) {
			d[0][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += (d[i - 1][k]) % 10007;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += d[N - 1][i];
		}
		System.out.println(sum % 10007);
	}
}
