package net.acmicpc;

import java.util.Scanner;

public class boj_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			score[i] = scanner.nextInt();
		}
		int[][] lst = new int[300][2];

		lst[0][0] = score[0];
		lst[0][1] = 0;

		if (N == 1) {
			System.out.println(score[0]);
		} else {
			lst[1][0] = score[1];
			lst[1][1] = score[1] + lst[0][0];

			if (N == 2) {
				System.out.println(lst[1][1]);

			} else {
				for (int i = 2; i < N; i++) {
					lst[i][0] = Math.max(lst[i - 2][0], lst[i - 2][1]) + score[i];
					lst[i][1] = lst[i - 1][0] + score[i];
				}

				System.out.println(Math.max(lst[N - 1][0], lst[N - 1][1]));
			}
		}
	}
}
