package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465_스티커 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[2][N];
			int[][] d = new int[N][3];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.hasMoreTokens()) {
					for (int j = 0; j < N; j++) {
						sticker[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			d[0][0] = sticker[0][0];
			d[0][1] = sticker[1][0];
			d[0][2] = 0;

			for (int i = 1; i < N; i++) {
				d[i][0] = sticker[0][i] + Math.max(d[i - 1][1], d[i - 1][2]);
				d[i][1] = sticker[1][i] + Math.max(d[i - 1][0], d[i - 1][2]);
				d[i][2] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
			}

			int result = Integer.MIN_VALUE;
			for (int i = 0; i < d[N - 1].length; i++) {
				result = Math.max(d[N - 1][i], result);
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
