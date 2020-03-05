package net.acmicpc;

import java.util.Scanner;

public class boj_10972_다음순열 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = scanner.nextInt();
		}
		int ans = 0;
		int MIN = Integer.MAX_VALUE;
		int x = -1;
		int y = -1;

		for (int i = N - 1; i >= 0; i--) {
			if (i == 0) {
				System.out.println(-1);
				break;
			}
			if (lst[i] > lst[i - 1]) {
				x = i - 1;
				for (int j = i; j < lst.length; j++) {
					if (lst[i - 1] < lst[j]) {
						MIN = Math.min(MIN, lst[j]);
					}
					for (int j2 = 0; j2 < lst.length; j2++) {
						if (lst[j2] == MIN) {
							y = j2;
						}
					}
				}

				int temp = lst[x];
				lst[x] = lst[y];
				lst[y] = temp;

				for (int m = x + 1; m < N - 1; m++) {
					for (int n = m + 1; n < N; n++) {
						if (lst[m] > lst[n]) {
							temp = lst[m];
							lst[m] = lst[n];
							lst[n] = temp;
						}
					}
				}
				for (int kk = 0; kk < lst.length; kk++) {
					System.out.print(lst[kk] + " ");
				}
				System.out.println();
				break;
			}
		}
	}
}
