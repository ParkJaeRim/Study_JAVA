package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7569_토마토2 {

	static int K, C, R;
	static boolean flag;
	static int[][][] map;
	static int[][][] count;
	static boolean[][][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		C = scanner.nextInt();
		R = scanner.nextInt();
		K = scanner.nextInt();
		map = new int[R][C][K];
		count = new int[R][C][K];
		visited = new boolean[R][C][K];

		for (int k = 0; k < K; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j][k] = scanner.nextInt();
				}
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j][k] == 1 && !visited[i][j][k]) {
						que.offer(new int[] { i, j, k });

						count[i][j][k] = 1;
						visited[i][j][k] = true;
					}
				}
			}
		}

		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];
			int z = cu[2];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx)) {
					if (count[ny][nx][z] == 0 && map[ny][nx][z] == 0 && !visited[ny][nx][z]) {
						count[ny][nx][z] = count[y][x][z] + 1;
						visited[ny][nx][z] = true;
						que.offer(new int[] { ny, nx, z });
					}

					if (z + 1 < K && count[y][x][z + 1] == 0 && map[y][x][z + 1] == 0 && !visited[y][x][z + 1]) {
						count[y][x][z + 1] = count[y][x][z] + 1;
						visited[y][x][z + 1] = true;
						que.offer(new int[] { y, x, z + 1 });
					}
					if (z - 1 >= 0 && count[y][x][z - 1] == 0 && map[y][x][z - 1] == 0 && !visited[y][x][z - 1]) {
						count[y][x][z - 1] = count[y][x][z] + 1;
						visited[y][x][z - 1] = true;
						que.offer(new int[] { y, x, z - 1 });
					}
				}
			}
		}
		
		flag = true;
		int ans = Integer.MIN_VALUE;
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j][k] == 0) {
						flag = false;
					}
				}
			}
		}
		if (flag) {
			System.out.println(0);
		} 
		else {
			for (int k = 0; k < K; k++) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (count[i][j][k] == 0 && map[i][j][k] != -1) {
							flag = true;
						}
					}
				}
			}
			if(flag) {
				System.out.println(-1);
			}
			
			int hangmax = Integer.MIN_VALUE;
			if (!flag) {
				for (int o = 0; o < K; o++) {
					hangmax = Integer.MIN_VALUE;
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							hangmax = Math.max(hangmax, count[i][j][o]);
						}
					}
					ans = Math.max(ans, hangmax);
				}
				System.out.println(ans-1);
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