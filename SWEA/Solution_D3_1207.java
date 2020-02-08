package com.swea;

import java.util.Scanner;

public class Solution_D3_1207 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] lst = new int[N];
			int cnt = 0;
			int MAXa = Integer.MIN_VALUE;
			int MAXb = Integer.MIN_VALUE;
			int MAX = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			for (int i = 2; i < lst.length - 2; i++) {
				if (lst[i - 1] < lst[i] && lst[i - 2] < lst[i] && lst[i + 1] < lst[i] && lst[i + 2] < lst[i]) {
					MAXa = lst[i - 2] > lst[i - 1] ? lst[i - 2] : lst[i - 1];
					MAXb = lst[i + 2] > lst[i + 1] ? lst[i + 2] : lst[i + 1];
					MAX = MAXa > MAXb ? MAXa : MAXb;
					cnt += lst[i] - MAX;
				}
			}
			System.out.println("#" + tc  + " " +cnt);
		}

	}
}
