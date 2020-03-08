package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_6593_상범빌딩 {

	static int L, C, R, sy, sx, sz, ey, ex, ez;
	static boolean flag, go;
	static char[][][] map;
	static int[][][] count;
	static boolean[][][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		go = false;
		while (!go) {
			L = scanner.nextInt();
			R = scanner.nextInt();
			C = scanner.nextInt();
			if (L == 0 && R == 0 && C == 0) {
				go = true;
			}

			else {
				map = new char[R][C][L];
				count = new int[R][C][L];
				visited = new boolean[R][C][L];
				flag = false;

				for (int k = 0; k < L; k++) {
					for (int i = 0; i < R; i++) {
						String s = scanner.next();
						for (int j = 0; j < C; j++) {
							map[i][j][k] = s.charAt(j);
							if (map[i][j][k] == 'E') {
								sy = i;
								sx = j;
								sz = k;
							}
							if (map[i][j][k] == 'S') {
								ey = i;
								ex = j;
								ez = k;
							}
						}
					}
				}

				bfs(sy, sx, sz);
				if (flag) {
					System.out.println("Escaped in " + count[ey][ex][ez] + " minute(s).");
				} else {
					System.out.println("Trapped!");
				}
			}
		}
	}

	public static void bfs(int a, int b, int c) {

		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { a, b, c });
		count[a][b][c] = 0;
		visited[a][b][c] = true;

		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];
			int z = cu[2];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny == ey && nx == ex && z == ez) {
					flag = true;
					count[ny][nx][z] = count[y][x][z] + 1;
					visited[ny][nx][z] = true;
					return;
				}

				if (safe(ny, nx)) {
					if (count[ny][nx][z] == 0 && map[ny][nx][z] == '.' && !visited[ny][nx][z]) {
						count[ny][nx][z] = count[y][x][z] + 1;
						visited[ny][nx][z] = true;
						que.offer(new int[] { ny, nx, z });
					}

					if (z + 1 < L && count[y][x][z + 1] == 0 && map[y][x][z + 1] == '.' && !visited[y][x][z + 1]) {
						count[y][x][z + 1] = count[y][x][z] + 1;
						visited[y][x][z + 1] = true;
						que.offer(new int[] { y, x, z + 1 });
					}
					if (z - 1 >= 0 && count[y][x][z - 1] == 0 && map[y][x][z - 1] == '.' && !visited[y][x][z - 1]) {
						count[y][x][z - 1] = count[y][x][z] + 1;
						visited[y][x][z - 1] = true;
						que.offer(new int[] { y, x, z - 1 });
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
