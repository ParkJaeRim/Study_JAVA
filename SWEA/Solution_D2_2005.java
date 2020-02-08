package com.swea;

import java.util.Scanner;

public class Solution_D2_2005 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[][] pyramid = new int[N][];

			for (int i = 0; i < N; i++) {
				pyramid[i] = new int[i + 1];
				pyramid[i][i] = 1;
				pyramid[i][0] = 1;
			}
			for (int i = 2; i < pyramid.length; i++) {
				for (int j = 1; j < pyramid[i].length - 1; j++) {
					pyramid[i][j] = pyramid[i - 1][j - 1] + pyramid[i - 1][j];
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < pyramid.length; i++) {
				for (int j = 0; j < pyramid[i].length; j++) {
					System.out.print(pyramid[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
