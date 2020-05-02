package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_9084_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] coin = new int[N];

			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int i = 0; i < N; i++) {
					coin[i] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int[][] d = new int[N][v + 1];
			for (int i = 0; i < N; i++) {
				d[i][0] = 1;
			}
			Arrays.sort(coin);

			for (int i = 1; i <= v; i++) {
				if (i % coin[0] == 0) {
					d[0][i] = 1;
				}
			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < v + 1; j++) {
					if (j - coin[i] < 0) {
						d[i][j] = d[i - 1][j];
					} else {
						d[i][j] = d[i - 1][j] + d[i][j - coin[i]];
					}
				}
			}
			sb.append(d[N - 1][v] + "\n");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
