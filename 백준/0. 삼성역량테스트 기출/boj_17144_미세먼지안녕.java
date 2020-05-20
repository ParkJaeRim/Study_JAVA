package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17144_미세먼지안녕 {
	static int R, C, T, tot, upAirY, downAirY;
	static int[][] map, count;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
		}

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 0; i < T; i++) {
			visited = new boolean[R][C];
			bfs(map);

		}
		tot = 0;
		for (int m = 0; m < R; m++) {
			for (int n = 0; n < C; n++) {
				tot += count[m][n];
			}
		}
		System.out.println(tot);
	}

	public static void SelectUpDown() {
		ArrayList<int[]> airMachine = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == -1) {
					airMachine.add(new int[] { i, j });
				}
			}
		}
		if (airMachine.get(0)[0] < airMachine.get(1)[0]) {
			upAirY = airMachine.get(0)[0];
			downAirY = airMachine.get(1)[0];
		} else {
			upAirY = airMachine.get(1)[0];
			downAirY = airMachine.get(0)[0];
		}
	}

	public static void rotate(int[][] map) {
		for (int i = upAirY; i >= 1; i--) {
			map[i][0] = map[i - 1][0];
		}
		map[0][0] = map[0][1];

		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		map[0][C - 1] = map[1][C - 1];

		for (int i = 0; i < upAirY; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		map[upAirY][C - 1] = map[upAirY][C - 2];

		for (int i = C - 1; i > 0; i--) {
			map[upAirY][i] = map[upAirY][i - 1];
		}

		map[upAirY][0] = map[upAirY - 1][0];
		map[upAirY][0] = 0;
		map[upAirY][1] = 0;

		///////////

		for (int i = downAirY; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		map[R - 1][0] = map[R - 1][1];

		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		map[R - 1][C - 1] = map[R - 2][C - 1];

		for (int i = R - 1; i > downAirY; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		map[downAirY][C - 1] = map[downAirY][C - 2];

		for (int i = C - 1; i > 0; i--) {
			map[downAirY][i] = map[downAirY][i - 1];
		}
		map[downAirY][1] = 0;
		map[downAirY][0] = map[downAirY + 1][0];
		map[downAirY][0] = 0;
	}

	public static void bfs(int[][] map) {
		Queue<int[]> que = new LinkedList<>();
		count = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0 && map[i][j] >= 5) {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				} else {
					count[i][j] = map[i][j];
				}
			}
		}

		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int cy = tmp[0];
			int cx = tmp[1];
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (safe(ny, nx) && map[ny][nx] != -1) {
					count[ny][nx] = count[ny][nx] + map[cy][cx] / 5;
					cnt++;
				}

			}
			if (map[cy][cx] >= 5) {
				count[cy][cx] = count[cy][cx] + map[cy][cx] - (map[cy][cx] / 5) * cnt;
			} else {
				count[cy][cx] = map[cy][cx];
			}
		}
		SelectUpDown();
		rotate(count);

		T--;
		if (T != 0) {
			bfs(count);
		}

	}

	public static boolean safe(int y, int x) {
		if (y < R && x < C && y >= 0 && x >= 0) {
			return true;
		}
		return false;
	}

	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
