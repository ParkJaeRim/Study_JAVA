package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11559_puyopuyo {
	static int cnt, pop;
	static boolean flag;
	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		map = new char[12][6];
		visited = new boolean[12][6];
		count = new int[12][6];

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 12; i++) {
			map[i] = scanner.next().toCharArray();
		}

		pop = 0;
		flag = false;

		first();
		while (flag) {
			down(map);
			first();
			pop++;
		}
		System.out.println(pop);
	}

	public static void first() {
		flag = false;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				visited = new boolean[12][6];

				if (map[i][j] != '.' && !visited[i][j]) {
					cnt = 1;
					countBubble(i, j);
				}
			}
		}
	}

	public static void countBubble(int i, int j) {
		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0];
			int x = cur[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] == map[y][x]) {
					cnt++;
					visited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}
			}
		}

		if (cnt >= 4) {
			flag = true;

			char X = map[i][j];
			Queue<int[]> que2 = new LinkedList<>();
			visited = new boolean[12][6];
			que2.offer(new int[] { i, j });

			visited[i][j] = true;
			map[i][j] = '.';

			while (!que2.isEmpty()) {
				int[] cur = que2.poll();
				int y = cur[0];
				int x = cur[1];

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] == X) {
						visited[ny][nx] = true;
						map[ny][nx] = '.';
						que2.offer(new int[] { ny, nx });
					}
				}
			}
		}
	}

	public static void down(char[][] map) {
		for (int x = 0; x < 6; x++) {
			for (int y = 11; y >= 0; y--) {
				if (map[y][x] == '.') {
					for (int z = y - 1; z >= 0; z--) {
						if (map[z][x] != '.') {
							map[y][x] = map[z][x];
							map[z][x] = '.';
							break;
						}
					}
				}
			}
		}
	}

	////////////////////////////////////////////////////////////////
	public static boolean safe(int y, int x) {
		if (y < 12 && y >= 0 && x < 6 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
