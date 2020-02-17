package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_6692 {

	static double sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			sum = 0;

			for (int i = 0; i < N; i++) {
				double P = scanner.nextDouble();
				int x = scanner.nextInt();

				sum += P * x;
			}
			System.out.printf("#%d %.6f\n",tc,sum);
		}
		
	}

}