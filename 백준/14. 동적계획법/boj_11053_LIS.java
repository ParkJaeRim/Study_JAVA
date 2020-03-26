package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11053_LIS {
	static int N;
	static int[] lst;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = scanner.nextInt();
		}

		int[] d = new int[N];
		Arrays.fill(d, 1);

		for (int i = 1; i < lst.length; i++) {
			int maxV = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (lst[i] > lst[j]) {
					maxV = Math.max(maxV, d[j]);
					d[i] = maxV + 1;
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < d.length; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
