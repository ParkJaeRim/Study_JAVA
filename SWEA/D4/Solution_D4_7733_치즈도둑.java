package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_7733_치즈도둑 {
	static int[][] map;
	static int T, N, maxDay, danji, dungi;
	static boolean[][] visited;
	static int[][] count;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			map = new int[N][N];
			maxDay = 0;
			dungi = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scanner.nextInt();
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}

			int day = 0;
			while (day != maxDay) {
				visited = new boolean[N][N];
				count = new int[N][N];
				danji = 1;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] <= day) {
							map[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] != 0 && !visited[i][j]) {
							bfs(i, j);
							danji++;
							dungi = Math.max(dungi, danji-1);
						}
					}
				}
				day++;
			}
			System.out.println("#"+ tc + " "+ dungi);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;
		count[i][j] = danji;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			int y = current[0];
			int x = current[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
					que.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					count[ny][nx] = danji;
				}
			}
		}

	}

	public static boolean safe(int y, int x) {
		if (y < N && x < N && y >= 0 & x >= 0) {
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
	}
}
