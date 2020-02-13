package com.swea;

import java.util.Scanner;

public class Solution_D3_1213 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int c = scanner.nextInt();
			String s = scanner.next();

			String kk = scanner.next();
			int cnt = 0;
			for (int i = 0; i <= kk.length() - s.length(); i++) {
				if (kk.substring(i, i + (s.length())).equals(s)) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
