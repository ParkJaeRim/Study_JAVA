package com.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int T, N, click;
	static char[][] map;
	static int[][] count, result;
	static boolean[][] visited;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			map = new char[N][N];
			visited = new boolean[N][N];
			count = new int[N][N];
			result = new int[N][N];

			for (int i = 0; i < count.length; i++) {
				Arrays.fill(count[i], -1);
			}

			for (int i = 0; i < N; i++) {
				map[i] = scanner.next().toCharArray();
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int cnt = 0;

					for (int d = 0; d < 8; d++) {
						if (safe(i + dy[d], j + dx[d]) && map[i + dy[d]][j + dx[d]] == '*') {
							cnt++;
						}
						if (map[i][j] == '.') {
							count[i][j] = cnt;
						}
					}
				}

			}
			click = 0;
			for (int i = 0; i < count.length; i++) {
				for (int j = 0; j < count[i].length; j++) {
					if (map[i][j] == '*') {
						visited[i][j] = true;
					}
					if (count[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited[i].length; j++) {
					if (!visited[i][j]) {
						click++;
					}
				}
			}
			System.out.println(click);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;
		click++;
		
		while (!que.isEmpty()) {
			int[] current = que.poll();

			int y = current[0];
			int x = current[1];

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx]) {
					if (count[ny][nx] == 0) {
						visited[ny][nx] = true;
						que.offer(new int[] { ny, nx });
					} else {
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < N && x < N && y >= 0 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
