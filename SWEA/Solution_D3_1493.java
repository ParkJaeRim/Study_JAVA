package com.swea;

import java.util.Scanner;

public class Solution_D3_1493 {
	static int T;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		int N = 10;
		int[][] lst = new int[N][N];

		int limit = 1;
		int x = 1;

		for (int i = 1; i < limit; i++) {
			for (int j = limit; j >= 1; j--) {
				System.out.println(limit + " "+ j);
				lst[i][j] = x;
				x++;
				limit++;
			}
		}

		for (int j = 0; j < lst.length; j++) {
			for (int k = 0; k < lst[j].length; k++) {
				System.out.print(lst[j][k] + " ");
			}
			System.out.println();
		}

	}

}
