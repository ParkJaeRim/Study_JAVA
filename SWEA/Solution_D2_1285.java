package com.swea;

import java.util.Scanner;

public class Solution_D2_1285 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] score = new int[N];
			int MIN = Integer.MAX_VALUE;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int tmp = scanner.nextInt();
				score[i] = Math.abs(0 - tmp);
				MIN = MIN < score[i] ? MIN : score[i];
			}
			for (int j = 0; j < score.length; j++) {
				if (MIN == score[j]) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + MIN + " " + cnt);
		}
	}
}
