package net.acmicpc;

import java.util.Scanner;

public class boj_10844_쉬운계단수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long[][] d = new long[N + 1][10];

		for (int i = 1; i < 10; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					d[i][j] = d[i - 1][j + 1] % 1000000000;
				} else if (j == 9) {
					d[i][j] = d[i - 1][j - 1] % 1000000000;
				} else {
					d[i][j] = (d[i - 1][j + 1] + d[i - 1][j - 1]) % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + d[N][i]) % 1000000000;
		}
		System.out.println(sum);
	}
}