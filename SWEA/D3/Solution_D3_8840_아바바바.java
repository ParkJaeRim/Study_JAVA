package com.swea;

import java.util.Scanner;

public class Solution_D3_8840_아바바바 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			long x = N / 2;

			long ans = x*x;

			System.out.println("#" + tc + " " + ans);
		}
	}

}
