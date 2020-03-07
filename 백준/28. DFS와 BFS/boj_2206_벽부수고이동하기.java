package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2206_벽부수고이동하기 {

	static int K, C, R;
	static boolean flag;
	static int[][] map;
	static int[][][] count;
	static boolean[][][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		R = scanner.nextInt();
		C = scanner.nextInt();
		map = new int[R][C];
		count = new int[R][C][2];
		visited = new boolean[R][C][2];

		for (int i = 0; i < R; i++) {
			String s = scanner.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int ans = Integer.MAX_VALUE;
		flag = false;
		bfs(0, 0);

		if (flag) {
			for (int o = 0; o < 2; o++) {
				if (count[R - 1][C - 1][o] != 0) {
					if (ans > count[R - 1][C - 1][o]) {
						ans = count[R - 1][C - 1][o];
					}
				}
			}
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j, 0 });
		count[i][j][0] = 1;
		visited[i][j][0] = true;

		while (!que.isEmpty()) {

			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];
			int z = cu[2];

			if (y == R - 1 && x == C - 1) {
				flag = true;

				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx)) {
					if (count[ny][nx][z] == 0 && map[ny][nx] == 0 && !visited[ny][nx][z]) {
						count[ny][nx][z] = count[y][x][z] + 1;
						visited[ny][nx][z] = true;
						que.offer(new int[] { ny, nx, z });
					}
					if (z + 1 < 2 && count[ny][nx][z + 1] == 0 && map[ny][nx] == 1 && !visited[ny][nx][z + 1]) {
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
}
