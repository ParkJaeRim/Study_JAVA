package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_11048_이동하기 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		int[][] map = new int[N][M];
		int[][] calc = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 1; i < M; i++) {
			map[0][i] += map[0][i - 1];
		}
		for (int i = 1; i < N; i++) {
			map[i][0] += map[i - 1][0];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				map[i][j] = Math.max(map[i - 1][j - 1], Math.max(map[i - 1][j], map[i][j - 1])) + map[i][j];
			}
		}

		bw.write(map[N - 1][M - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
