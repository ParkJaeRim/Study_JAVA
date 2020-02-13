package com.swea;

import java.util.Scanner;

public class Solution_D3_6730 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] lst = new int[N];

			int up = 0;
			int down = 0;
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}

			for (int i = 0; i < lst.length - 1; i++) {
				if (lst[i] < lst[i + 1]) {
					up = up > lst[i + 1] - lst[i] ? up : lst[i + 1] - lst[i];
				} else if (lst[i] > lst[i + 1]) {
					down = down > lst[i] - lst[i + 1] ? down : lst[i] - lst[i + 1];
				} else {
					continue;
				}
			}
			System.out.println("#" + tc + " " + up + " " + down);
		}
	}

}
