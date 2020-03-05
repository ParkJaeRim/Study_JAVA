package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//타임리밋
public class boj_2573_빙산 {
	static int R, C, cnt, bing;
	static boolean[][] visited;
	static int[][] map, ICE;
	static int[][] count;
	static int day;
	static boolean flag;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		R = scanner.nextInt();
		C = scanner.nextInt();
		map = new int[R][C];
		ICE = new int[R][C];
		count = new int[R][C];

		day = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		bing = 0;
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					HowManyIce(i, j);
					bing++;
				}
			}
		}

		if (bing >= 2) {
			day = 0;
		}

		while (bing < 2) {
			day++;
			melting(map); // 빙하 녹이기
			bing = 1;
			visited = new boolean[R][C];
			ICE = new int[R][C];
			flag = false;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						flag = true;
					}
				}
			}
			if (!flag) {
				day = 0;
				break;
			} else if (flag) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] != 0 && !visited[i][j]) {
							HowManyIce(i, j);
							bing++;
						}
					}
				}
			}
			bing = bing - 1;
		}
		System.out.println(day);

	}

	public static void HowManyIce(int i, int j) { // 빙하가 총 몇 단지 있는지?
		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { i, j });
		visited[i][j] = true;
		ICE[i][j] = bing;

		while (!que.isEmpty()) {
			int[] current = que.poll();
			int y = current[0];
			int x = current[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
					visited[ny][nx] = true;
					ICE[ny][nx] = bing;
					que.offer(new int[] { ny, nx });
				}
			}
		}
	}

	public static void melting(int[][] map) {
		int[][] count_melt = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt = 0;
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (safe(i + dy[d], j + dx[d]) && map[i + dy[d]][j + dx[d]] == 0) {
							cnt++;
						}
					}

				}
				count_melt[i][j] = cnt;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] -= count_melt[i][j];
				if (map[i][j] < 0) {
					map[i][j] = 0;
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