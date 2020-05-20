package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크 {
	static int N, fin;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		visited = new boolean[N];
		fin = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(fin);
	}

	public static void comb(int start, int cnt) {
		if (N / 2 == cnt) {
			int red = 0;
			int blue = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (visited[i] && visited[j]) {
						red += map[i][j];
					}
					if (!visited[i] && !visited[j]) {
						blue += map[i][j];
					}
				}
			}
			fin = Math.min(fin, Math.abs(red - blue));
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
		return;
	}
}
