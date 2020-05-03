package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1600_말이되고픈원숭이 {
	static int K, C, R;
	static boolean flag;
	static int[][] map;
	static int[][][] count;
	static boolean[][][] visited;
	static int[] dy = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		K = scanner.nextInt();
		C = scanner.nextInt();
		R = scanner.nextInt();
		map = new int[R][C];
		count = new int[R][C][K + 1];
		visited = new boolean[R][C][K + 1];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		flag = false;
		bfs(0, 0);
		int min = Integer.MAX_VALUE;
		if (flag) {
			for (int o = 0; o <= K; o++) {
				if (count[R - 1][C - 1][o] != 0) {
					min = Math.min(min, count[R - 1][C - 1][o]);
				}
			}
			if (min == Integer.MAX_VALUE) {
				System.out.println(0);
			}else 
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j, 0 });
		count[i][j][0] = 0;
		visited[i][j][0] = true;
		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];
			int z = cu[2];

			if (y == R - 1 && x == C - 1) {
				if(map[R-1][C-1] ==1) {
					flag= false;
				}else {
					flag = true;
				}
				return;
			}

			for (int d = 0; d < 12; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx)) {
					if (d < 4 && count[ny][nx][z] == 0 && map[ny][nx] == 0 && !visited[ny][nx][z]) {
						count[ny][nx][z] = count[y][x][z] + 1;
						visited[ny][nx][z] = true;
						que.offer(new int[] { ny, nx, z });
					}
					if (d >= 4 && d < 12 && z + 1 <= K && count[ny][nx][z + 1] == 0 && map[ny][nx] == 0
							&& !visited[ny][nx][z + 1]) {
						count[ny][nx][z + 1] = count[y][x][z] + 1;
						visited[ny][nx][z + 1] = true;
						que.offer(new int[] { ny, nx, z + 1 });
					}
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

	public static void print(int[][][] lst) {
		for (int i = 0; i <= K; i++) {
			System.out.println(i);
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					System.out.print(lst[j][k][i] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("============");
	}
}
