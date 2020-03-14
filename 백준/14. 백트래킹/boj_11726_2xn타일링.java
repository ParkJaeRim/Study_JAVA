package net.acmicpc;

import java.util.*;

public class boj_11726_2xn타일링 {

	static int d[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		d = new int[N + 1];

		d[1] = 1;
		if (N >= 2)
			d[2] = 2;

		for (int i = 3; i <= N; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] = d[i] % 10007;
		}

		System.out.println(d[N]);

	}

}