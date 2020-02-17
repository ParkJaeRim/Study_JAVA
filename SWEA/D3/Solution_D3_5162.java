package com.swea;

import java.util.Scanner;

public class Solution_D3_5162 {
	static int A, B, C, x, y, sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {
			A = scanner.nextInt();
			B = scanner.nextInt();
			C = scanner.nextInt();

			if (B < A) {
				x = C / B;
				y = (C - B * x) / A;
				sum = x + y;

				while (x >= 0) {
					x--;
					y = (C - B * x) / A;

					sum = sum > x + y ? sum : x + y;
				}
				System.out.println("#" + (tc + 1) + " " + sum);
			}

			else if (B >= A) {
				x = C / A;
				y = (C - A * x) / B;
				sum = x + y;

				while (x >= 0) {
					x--;
					y = (C - A * x) / B;

					sum = sum > x + y ? sum : x + y;
				}
				System.out.println("#" + (tc + 1) + " " + sum);
			}
		}
	}

}
