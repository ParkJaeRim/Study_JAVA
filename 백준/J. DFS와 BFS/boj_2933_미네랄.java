package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2933_미네랄 {
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pair> que;
	static int R, C, danji;
	static ArrayList<Pair> al;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = R - 1; i >= 0; i--) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (tmp[j] == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		int N = Integer.parseInt(br.readLine());
		int[] makde = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < makde.length; i++) {
			makde[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < makde.length; i++) {
			if (i % 2 == 0) {
				// left
				for (int j = 0; j < C; j++) {
					if (map[makde[i] - 1][j] == 1) {
						map[makde[i] - 1][j] = 0;
						break;
					}
				}
				al = new ArrayList<>();
				find();
				if (al.size() != 0)
					drop();

			} else {
				for (int j = C - 1; j >= 0; j--) {
					if (map[makde[i] - 1][j] == 1) {
						map[makde[i] - 1][j] = 0;
						break;
					}
				}
				al = new ArrayList<>();
				find();
				if (al.size() != 0)
					drop();
			}
		}
		print(map);
	}

	private static void drop() {
		int cnt = 0;

		for (Pair p : al) {
			map[p.y][p.x] = 0;
		}

		aa: for (int i = 1; i < R; ++i) {
			for (Pair p : al) {
				if (p.y - i < 0 || map[p.y - i][p.x] == 1) {
					break aa;
				}
			}
			cnt = i;
		}
		for (Pair p : al) {
			map[p.y - cnt][p.x] = 1;
		}
	}

	public static void find() {
		visited = new boolean[R][C];
		que = new LinkedList<>();

		for (int x = 0; x < C; x++) {
			if (!visited[0][x] && map[0][x] == 1) {
				visited[0][x] = true;
				que.offer(new Pair(0, x));
				bfs();
			}
		}
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					al.add(new Pair(i, j));
				}
			}
		}
	}

	public static void bfs() {
		while (!que.isEmpty()) {
			Pair p = que.poll();
			int cy = p.y;
			int cx = p.x;

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (ny >= 0 && nx >= 0 && nx < C && ny < R && !visited[ny][nx] && map[ny][nx] == 1) {
					que.offer(new Pair(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void print(int[][] map) {
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1)
					System.out.print("x");
				else
					System.out.print(".");
			}
			System.out.println();
		}
		System.out.println();
	}
}
