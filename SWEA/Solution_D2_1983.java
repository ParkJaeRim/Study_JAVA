package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1983 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int student = scanner.nextInt();
			int idx = scanner.nextInt();
			double[] lst = new double[student];

			for (int i = 0; i < student; i++) {
				int mid = scanner.nextInt();
				int fin = scanner.nextInt();
				int ass = scanner.nextInt();

				lst[i] = (double) (mid * 0.35 + fin * 0.45 + ass * 0.2);
			}
			double Score = lst[idx - 1];
			int hakjum_student = student/10;
			Arrays.sort(lst);
			int deung = 0;
			for (int i = 0; i < lst.length; i++) {
				if (Score == lst[i]) {
					deung = i;
				}
			}
			String[] hakjum = new String[] { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
			int x = Math.round(deung/hakjum_student);
			System.out.println("#" + tc + " " + hakjum[x]);
		}
	}
}
