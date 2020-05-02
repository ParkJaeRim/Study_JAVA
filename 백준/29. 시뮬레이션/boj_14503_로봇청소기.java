package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14503_로봇청소기 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int R, C, clean, startY, startX, startD;
	static int[][] map, tmpCnt;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		map = new int[R][C];
		tmpCnt = new int[R][C];
		visited = new boolean[R][C];

		st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			startD = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		clean = 1;
		bfs(startY, startX, startD);
		System.out.println(clean);
	}

	private static void bfs(int startY, int startX, int startD) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { startY, startX, startD });
		int cnt = 0;
		tmpCnt[startY][startX] = clean;
		visited[startY][startX] = true;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			int y = current[0];
			int x = current[1];
			int d = current[2];
			if (cnt < 4) {
				if (d == 0) {
					if (safe(y, x - 1) && map[y][x - 1] == 0) {
						if (!visited[y][x - 1]) {
							visited[y][x - 1] = true;
							x -= 1;
							cnt = 0;
							clean++;
							tmpCnt[y][x] = clean;
						} else {
							cnt++;
						}
					} else {
						cnt++;
					}
					d = 3;
				} else if (d == 1) {
					if (safe(y - 1, x) && map[y - 1][x] == 0) {
						if (!visited[y - 1][x]) {
							visited[y - 1][x] = true;
							y -= 1;
							cnt = 0;
							clean++;
							tmpCnt[y][x] = clean;
						} else {
							cnt++;
						}
					} else {
						cnt++;
					}
					d = 0;
				} else if (d == 2) {
					if (safe(y, x + 1) && map[y][x + 1] == 0) {
						if (!visited[y][x + 1]) {
							visited[y][x + 1] = true;
							x += 1;
							cnt = 0;
							clean++;
							tmpCnt[y][x] = clean;
						} else {
							cnt++;
						}
					} else {
						cnt++;
					}
					d = 1;
				} else if (d == 3) {
					if (safe(y + 1, x) && map[y + 1][x] == 0) {
						if (!visited[y + 1][x]) {
							visited[y + 1][x] = true;
							y += 1;
							cnt = 0;
							clean++;
							tmpCnt[y][x] = clean;
						} else {
							cnt++;
						}
					} else {
						cnt++;
					}
					d = 2;
				}

			} else {
				cnt = 0;
				if (!back(y, x, d)) {
					return;
				} else {

					if (d == 0) {
						y += 1;
					} else if (d == 1) {
						x -= 1;
					} else if (d == 2) {
						y -= 1;
					} else {
						x += 1;
					}

					if (map[y][x] != 0) {
						return;
					}
				}
			}
			que.offer(new int[] { y, x, d });
		}
	}

	public static boolean back(int y, int x, int d) {
		if (d == 0) {
			if (safe(y + 1, x)) {
				return true;
			} else {
				return false;
			}
		} else if (d == 1) {
			if (safe(y, x - 1)) {
				return true;
			} else {
				return false;
			}
		} else if (d == 2) {
			if (safe(y - 1, x)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (safe(y, x + 1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y >= 0 && y < R && x >= 0 && x < C) {
			return true;
		} else {
			return false;
		}
	}
}
