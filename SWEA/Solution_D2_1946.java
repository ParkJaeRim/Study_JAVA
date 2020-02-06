package com.swea;

import java.util.Scanner;

public class Solution_D2_1946 {
	static String A;
	static int Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[][] file = new String[20][10];
			int n = 0;
			int m = 0;

			for (int i = 0; i < N; i++) {
				A = sc.next();
				Q = sc.nextInt();

				for (int j = 0; j < Q; j++) {
					file[n][m] = A;
					m++;
					if (m == 10) {
						m = 0;
						n++;
					}
				}
			}
			System.out.println("#" + tc);
			for (int x = 0; x < file.length; x++) {
				for (int y = 0; y < file[x].length; y++) {
					if (file[x][y] == null) {
						break;
					}
					else {
					System.out.print(file[x][y]);
					}
				}
				if(file[x][0]==null) {
					continue;
				}
				else {
				System.out.println();
				}

			}
//			System.out.println();
		}

	}

}
