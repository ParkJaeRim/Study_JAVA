package net.acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj_2565_전깃줄 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int[][] lst = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				lst[i][j] = scanner.nextInt();
			}
		}

		Arrays.sort(lst, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});

		int[] d = new int[N];
		Arrays.fill(d, 1);

		for (int i = 1; i < lst.length; i++) {
			int maxV = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (lst[i][1] > lst[j][1]) {
					maxV = Math.max(maxV, d[j]);
					d[i] = maxV + 1;
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < d.length; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(N - ans);
	}
}
