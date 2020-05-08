package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146_다리만들기 {
	static int N, danji, ans;
	static boolean[][] visited;
	static int[][] map, count;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		danji = 1;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					bfs(i, j);
					danji++;
				}
			}
		}

		ans = Integer.MAX_VALUE;
		for (int i = 1; i < danji; i++) {
			makeDari(i);
		}
		System.out.println(ans);
	}

	public static void makeDari(int danji) {
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[N][N];
		count = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == danji) {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int cy = tmp[0];
			int cx = tmp[1];
			if (map[cy][cx] != 0 && map[cy][cx] != danji) {
				if (ans > (count[cy][cx] - 1)) {
					ans = count[cy][cx] - 1;
				}
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (safe(ny, nx) && !visited[ny][nx]) {
					count[ny][nx] = count[cy][cx] + 1;
					visited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}
			}

		}
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		visited[y][x] = true;
		map[y][x] = danji;

		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int cy = tmp[0];
			int cx = tmp[1];

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
					map[ny][nx] = danji;
					visited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
				}
			}

		}
	}

	public static boolean safe(int y, int x) {
		if (y < N && x < N && y >= 0 && x >= 0) {
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
