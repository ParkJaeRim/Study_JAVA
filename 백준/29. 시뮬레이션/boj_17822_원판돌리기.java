package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17822_원판돌리기 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, T;

	static int[][] wonpan;
	static boolean[][] visited;
	static ArrayList<int[]> al;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
		}

		wonpan = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < M; j++) {
					wonpan[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				while (k != 0) {
					rotate(x, d);
					k--;
				}
				int cnt = 0;
				visited = new boolean[N][M];
				boolean goNormalize = true;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						al = new ArrayList<>();
						if (!visited[i][j]) {
							al.add(new int[] { i, j });
							bfs(i, j);
						}
						if (al.size() > 1) {
							for (int m = 0; m < al.size(); m++) {
								int tmpy = al.get(m)[0];
								int tmpx = al.get(m)[1];
								wonpan[tmpy][tmpx] = 0;
							}
							goNormalize = false;
						}
					}
				}
				int sumWonpan = 0;
				int notZero = 0;

				if (goNormalize) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (wonpan[i][j] != 0) {
								sumWonpan += wonpan[i][j];
								notZero++;
							}
						}
					}

					double avg = (double) sumWonpan / notZero;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (wonpan[i][j] != 0) {
								if (avg < wonpan[i][j]) {
									wonpan[i][j]--;
								} else if (avg > wonpan[i][j]) {
									wonpan[i][j]++;
								} else {
									continue;
								}
							}
						}
					}
				}

			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += wonpan[i][j];
			}
		}

		System.out.println(ans);
	}

	public static void rotate(int x, int d) {
		for (int i = 0; i < N; i++) {
			if ((i + 1) % x == 0) {
				if (d == 0) {// 시계방향
					int store = wonpan[i][wonpan[i].length - 1];
					for (int j = M - 1; j > 0; j--) {
						wonpan[i][j] = wonpan[i][j - 1];
					}
					wonpan[i][0] = store;
				} else {
					int store = wonpan[i][0];
					for (int j = 0; j < M - 1; j++) {
						wonpan[i][j] = wonpan[i][j + 1];
					}
					wonpan[i][M - 1] = store;
				}
			}
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;
		int saveNum = wonpan[i][j];
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int curY = tmp[0];
			int curX = tmp[1];

			for (int d = 0; d < 4; d++) {
				int ny = curY + dy[d];
				int nx = curX + dx[d];

				if (nx < 0) {
					nx = M - 1;
				} else if (nx > M - 1) {
					nx = 0;
				}
				if (safe(ny, nx) && !visited[ny][nx] && wonpan[ny][nx] == saveNum) {
					que.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					if (wonpan[ny][nx] != 0)
						al.add(new int[] { ny, nx });
				}
			}
		}

	}

	public static boolean safe(int y, int x) {
		if (x < M && x >= 0 && y < N && y >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
