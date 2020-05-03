package net.acmicpc;

import java.util.Scanner;

public class boj_1912_연속합 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] c = new int[N];
		int[] d = new int[N];

		for (int i = 0; i < N ; i++) {
			c[i] = scanner.nextInt();
		}

		d[0] = c[0];
		int max = d[0];

		for (int i = 1; i < d.length; i++) {
			d[i] = Math.max(d[i - 1] + c[i], c[i]);
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
	}
}
