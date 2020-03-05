package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_14502_연구소 {
	static int R, C, zero, MAX;
	static int[][] map;
	static boolean[][] visitedbfs;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		R = scanner.nextInt();
		C = scanner.nextInt();
		map = new int[R][C];

		MAX = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		makeWall(map, 0);
		System.out.println(MAX);
	}

	public static void makeWall(int[][] map, int cnt) {
		if (cnt == 3) {
			bfs(map);
			MAX = Math.max(MAX, zero);
			return;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(map, cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void bfs(int[][] map) {
		int[][] count = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					count[i][j] = 1;
				}
			}
		}
		// 바이러스
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 2) {
					visitedbfs = new boolean[R][C];
					Queue<int[]> que = new LinkedList<>();

					count[i][j] = 2;
					visitedbfs[i][j] = true;
					que.offer(new int[] { i, j });

					while (!que.isEmpty()) {
						int[] cu = que.poll();
						int y = cu[0];
						int x = cu[1];

						for (int d = 0; d < 4; d++) {
							int ny = y + dy[d];
							int nx = x + dx[d];

							if (safe(ny, nx) && !visitedbfs[ny][nx] && map[ny][nx] == 0) {
								count[ny][nx] = 2;
								visitedbfs[ny][nx] = true;
								que.offer(new int[] { ny, nx });
							}
						}
					}

				}
			}
		}
		zero = 0;
		countZero(count);

	}

	public static void countZero(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0 && map[i][j] != 1) {
					zero++;
				}
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < R && x < C) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
