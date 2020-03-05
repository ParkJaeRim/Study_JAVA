package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2589_보물섬 {
	static int R, C, cnt, ans;
	static int start_y, start_x, end_y, end_x;
	static char[][] map;
	static boolean[][] visited;
	static int[][] count;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		R = scanner.nextInt();
		C = scanner.nextInt();

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = scanner.next().toCharArray();
		}
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visited = new boolean[R][C];
				count = new int[R][C];
				if(map[i][j] == 'L') {
					cnt=0;
					bfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;
		count[i][j] = cnt;

		while (!que.isEmpty()) {
			int[] current = que.poll();
			int y = current[0];
			int x = current[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && map[ny][nx] == 'L' && !visited[ny][nx]) {
					que.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					count[ny][nx] = count[y][x] + 1;
					ans = Math.max(ans, count[ny][nx]);
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
