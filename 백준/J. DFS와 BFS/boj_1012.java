package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1012 {
	static int T, M, N, ny, nx, n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = scanner.nextInt(); // 열
			M = scanner.nextInt(); // 행

			map = new int[M][N];
			visited = new boolean[M][N];

			int K = scanner.nextInt();
			for (int i = 0; i < K; i++) {
				int x = scanner.nextInt(); // 열
				int y = scanner.nextInt(); // 행
				map[y][x] = 1;
			}
			
			n = 1;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						bfs(i, j);
						n++;
					}
				}
			}
			System.out.println(n-1);
		}
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		visited[y][x] = true;
		map[y][x] = n;

		while (!que.isEmpty()) {
			int[] current = que.poll();
			for (int d = 0; d < 4; d++) {
				ny = current[0] + dy[d];
				nx = current[1] + dx[d];

				if (check(ny, nx) && visited[ny][nx] == false && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					map[ny][nx] = n;
					que.offer(new int[] {ny,nx});
				}
			}
		}
	}

	public static boolean check(int y, int x) {
		if (y >= 0 && y < M && x >= 0 && x < N) {
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

	public static void print(boolean[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
