package com.swea;

import java.util.Scanner;

public class Solution_D3_3233_정삼각형분할놀이 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			
			int div = A/B;
			long ans = (long)div * div;
			System.out.println("#"+tc+" "+ ans);
		}
	}
}
