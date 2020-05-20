package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {
	static int N, M;
	static int[][] map;
	static int[][][] tetris = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } }, // 1
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }, // 2
			
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } }, // 3

			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 0, 0 }, { -1, 0 }, { -1, 1 }, { -2, 1 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } }, // 4

			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 0, 2 } }, { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 2 } },
			{ { 0, 0 }, { 1, -1 }, { 1, 0 }, { 2, 0 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } };//5

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		///////////////////// INPUT//////////////////////
		int fin = Integer.MIN_VALUE;
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				for (int k = 0; k < tetris.length; k++) {
					int total = 0;

					for (int m = 0; m < tetris[k].length; m++) {
						if (!(j+tetris[k][m][1]>=0 && i+tetris[k][m][0]>=0 && i + tetris[k][m][0] < N && j + tetris[k][m][1] < M)) {
							total = 0;
							break;
						}
						total += map[i + tetris[k][m][0]][j + tetris[k][m][1]];
					}
					fin = Math.max(total, fin);
				}
			}
		}
		System.out.println(fin);
	}
}
