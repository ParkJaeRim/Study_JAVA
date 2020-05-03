package net.acmicpc;

import java.io.*;
import java.util.*;

public class boj_16236_아기상어 {
	static int N, baby, babyY, babyX, time, grow;
	static int[][] map, cnt;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		babyY = 0;
		babyX = 0;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 9) {
						babyY = i;
						babyX = j;
					}
				}
			}
		}
		grow = 0;
		baby = 2;
		time = 0;
		shark();
	}

	public static void shark() {
		if (checkEat()) {
			bfs(babyY, babyX);
			int minTime = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cnt[i][j] != 0 && map[i][j] != 0 && map[i][j] < baby) {
						if (minTime > cnt[i][j]) {
							minTime = cnt[i][j];
						}
					}
				}
			}

			ArrayList<Edge> al = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cnt[i][j] == minTime && map[i][j] != 0 && map[i][j] != baby) {
						al.add(new Edge(i, j));
					}
				}
			}
			if (al.size() == 0) {
				System.out.println(time);
				return;
			}
			Collections.sort(al);
			time += minTime;
			babyY = al.get(0).y;
			babyX = al.get(0).x;
			grow++;
			map[babyY][babyX] = 0;
			if (grow == baby) {
				baby++;
				grow = 0;
			}

			if (checkEat()) {
				shark();
			} else {
				System.out.println(time);
				return;
			}
		} else {
			System.out.println(time);
			return;
		}

	}

	public static boolean checkEat() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && map[i][j] <= baby) {
					return true;
				}
			}
		}
		return false;
	}

	public static void bfs(int y, int x) {
		map[y][x] = 0;
		visited = new boolean[N][N];
		cnt = new int[N][N];

		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		visited[y][x] = true;

		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int cy = tmp[0];
			int cx = tmp[1];

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] <= baby) {
					visited[ny][nx] = true;
					cnt[ny][nx] = cnt[cy][cx] + 1;
					que.offer(new int[] { ny, nx });
				}
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int y;
		int x;

		public Edge(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.y > o.y) {
				return 1;
			} else if (this.y == o.y) {
				if (this.x < o.x) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return -1;
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < N && x < N && y >= 0 && x >= 0) {
			return true;
		}
		return false;
	}
}
