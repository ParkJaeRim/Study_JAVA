package com.swea;

import java.util.Scanner;

public class Solution_D3_7272 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String A = scanner.next();
			String B = scanner.next();

			int[] lstA = new int[A.length()];
			int[] lstB = new int[B.length()];

			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == 'A' || A.charAt(i) == 'D' || A.charAt(i) == 'O' || A.charAt(i) == 'P'
						|| A.charAt(i) == 'Q' || A.charAt(i) == 'R') {
					lstA[i] = 0;
				} else if (A.charAt(i) == 'B') {
					lstA[i] = 1;
				} else {
					lstA[i] = 2;
				}
			}

			for (int i = 0; i < B.length(); i++) {
				if (B.charAt(i) == 'A' || B.charAt(i) == 'D' || B.charAt(i) == 'O' || B.charAt(i) == 'P'
						|| B.charAt(i) == 'Q' || B.charAt(i) == 'R') {
					lstB[i] = 0;
				} else if (B.charAt(i) == 'B') {
					lstB[i] = 1;
				} else {
					lstB[i] = 2;
				}
			}

			boolean dec = true;
			if (lstA.length != lstB.length) {
				dec = false;
				
			} else {
				for (int i = 0; i < lstA.length; i++) {
					if (lstA[i] != lstB[i]) {
						dec = false;
                        break;
					}
				}
			}
			if (!dec) {
				System.out.println("#" + tc + " DIFF");
			} else {
				System.out.println("#" + tc + " SAME");
			}
		}

	}

}