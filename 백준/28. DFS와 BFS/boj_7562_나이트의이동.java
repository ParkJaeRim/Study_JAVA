package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7562_나이트의이동 {
	static int[] dy = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[][] visited;
	static int[][] map;
	static int T, N, start_y, start_x, end_y, end_x;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = scanner.nextInt();
			map = new int[N][N];

			start_y = scanner.nextInt();
			start_x = scanner.nextInt();

			end_y = scanner.nextInt();
			end_x = scanner.nextInt();

			visited = new int[N][N];
			bfs(start_y, start_x);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { i, j });
		visited[i][j] = 0;

		while (!que.isEmpty()) {
			int[] current = que.poll();
			int y = current[0];
			int x = current[1];
			for (int d = 0; d < dy.length; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (y == end_y && x == end_x) {
					System.out.println(visited[y][x]);
					return;
				}
				
				if (safe(ny, nx) && visited[ny][nx] == 0) {
					visited[ny][nx] = visited[y][x] + 1;
					que.offer(new int[] { ny, nx });
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
	
	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j]+" ");
			}System.out.println();
		}System.out.println();
	}
}
