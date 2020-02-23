package com.swea;

import java.util.Scanner;

public class Solution_D3_8457_알덴테스파게티 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int B = scanner.nextInt();
			int E = scanner.nextInt();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int x = scanner.nextInt();
				int j = 1;
				
				while (x * j <= B + E) {
					if (B - E <= x*j && x*j <= B + E) {
						cnt++;
						break;
					}
					j++;
				}
			}
			System.out.println("#" + tc+ " " +cnt);
		}
	}

}
