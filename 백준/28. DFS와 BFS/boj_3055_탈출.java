package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_3055_탈출 {
	static int R, C, startX, startY, endX, endY;
	static int[][] ww, aa, go;
	static boolean[][] waterVisited, visited;
	static boolean[][] animalvisited;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Queue<int[]> que;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		R = scanner.nextInt();
		C = scanner.nextInt();

		map = new char[R][C];
		animalvisited = new boolean[R][C];
		waterVisited = new boolean[R][C];
		ww = new int[R][C];
		aa = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = scanner.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == 'S') {
					startY = i;
					startX = j;
				}
				if (map[i][j] == 'D') {
					endY = i;
					endX = j;
					ww[i][j] = -1;
				}
				if (map[i][j] == 'X') {
					ww[i][j] = -1;
					aa[i][j] = -1;
				}

				if (map[i][j] == '*') {
					aa[i][j] = -1;
				}

			}
		}
		// INPUT

		que = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					que.offer(new int[] { i, j });
					ww[i][j] = 0;
					waterVisited[i][j] = true;
				}
			}
		}

		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (safe(ny, nx) && !waterVisited[ny][nx] && ww[ny][nx] == 0 && map[ny][nx] != 'X'
						&& map[ny][nx] != 'D') {
					ww[ny][nx] = ww[y][x] + 1;
					waterVisited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}

			}
		}

		animal(startY, startX);

		if (aa[endY][endX] != 0) {
			System.out.println(aa[endY][endX]);
		} else {
			System.out.println("KAKTUS");
		}
	}

	private static void animal(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		animalvisited[i][j] = true;
		aa[i][j] = 0;
		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && ny == endY && nx == endX && !animalvisited[ny][nx]) {
					aa[ny][nx] = aa[y][x] + 1;
					animalvisited[ny][nx] = true;
				}
				if (safe(ny, nx) && ww[ny][nx] == 0 && aa[ny][nx] == 0 && !animalvisited[ny][nx]) {
					aa[ny][nx] = aa[y][x] + 1;
					animalvisited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}
				if (safe(ny, nx) && ww[ny][nx] != -1 && aa[ny][nx] == 0 && aa[y][x] + 1 < ww[ny][nx]
						&& !animalvisited[ny][nx]) {
					aa[ny][nx] = aa[y][x] + 1;
					animalvisited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < R && x < C && y >= 0 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
