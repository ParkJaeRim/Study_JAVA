package com.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D5_7793_오나의여신님 {
	static int R, C, sy, sx, ey, ex;
	static char[][] map;
	static int[][] spread, step;
	static boolean[][] visited;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Queue<int[]> akma;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			R = scanner.nextInt();
			C = scanner.nextInt();

			map = new char[R][C];
			spread = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				Arrays.fill(spread[i], -1);
			}
			
			step = new int[R][C];
			visited = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				String s = scanner.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'S') {
						sy = i;
						sx = j;
					}
					if (map[i][j] == 'D') {
						ey = i;
						ex = j;
					}
				}
			}

			akma = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*') {
						akma.offer(new int[] { i, j });
						spread[i][j] = 1;
					}
				}
			}
			badguy();
			go(sy, sx);	
		
			if(step[ey][ex]==0) {
				System.out.println("#" + tc+ " GAME OVER");
			}
			else {
				System.out.println("#"+ tc+ " " + (step[ey][ex]-1));
			}
		}
	}

	public static void badguy() {
		while (!akma.isEmpty()) {
			int[] tmp = akma.poll();
			int y = tmp[0];
			int x = tmp[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && spread[ny][nx] == -1 && map[ny][nx] == '.') {
					spread[ny][nx] = spread[y][x] + 1;
					akma.offer(new int[] { ny, nx });
				}
			}
		}
	}

	public static void go(int i, int j) {
		Queue<int[]> suyeon = new LinkedList<>();
		suyeon.offer(new int[] { i, j });
		visited[i][j] = true;
		step[i][j] = 1;

		while (!suyeon.isEmpty()) {
			int[] tmp = suyeon.poll();
			int y = tmp[0];
			int x = tmp[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && (map[ny][nx] == '.' || map[ny][nx]=='D') && (spread[ny][nx] == -1 || step[y][x] + 1 < spread[ny][nx])) {
					step[ny][nx] = step[y][x] + 1;
					visited[ny][nx] = true;
					suyeon.offer(new int[] { ny, nx });
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
