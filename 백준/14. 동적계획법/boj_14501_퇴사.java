package net.acmicpc;

import java.util.Scanner;

public class boj_14501_퇴사 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] day = new int[N + 1];
		int[] money = new int[N + 1];
		int[][] d = new int[N + 1][2];

		for (int i = 1; i < N + 1; i++) {
			day[i] = scanner.nextInt();
			money[i] = scanner.nextInt();
		}

		for (int i = 1; i < d.length; i++) {
			if (day[i] + i <= N + 1) {
				int max = Integer.MIN_VALUE;

				d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
				for (int j = 1; j < i; j++) {
					if (j + day[j] <= i) {
						max = Math.max(max, d[j][1]);
					}
				}
				if (max == Integer.MIN_VALUE) {
					d[i][1] = money[i];
				} else {
					d[i][1] = max + money[i];
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				ans = Math.max(ans, d[i][j]);
			}
		}
		System.out.println(ans);
	}
}
