package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17142_연구소3 {
	static int N, M, subResult, none, ans, stop;
	static Queue<int[]> que;
	static int[][] count, map;
	static boolean[][] visited;
	static LinkedList<int[]> al, choice;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		stop = 0;
		map = new int[N][N];
		que = new LinkedList<>();
		al = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						al.add(new int[] { i, j });
						cnt++;
					}
				}
			}
		}
		ans = Integer.MAX_VALUE;
		choice = new LinkedList<>();
		none = 0;
		comb(0, 0);
		if (stop == none) {
			System.out.println(-1);
		} else {
			if (ans == Integer.MAX_VALUE) {
				System.out.println(0);
			} else
				System.out.println(ans);
		}

	}

	public static void comb(int start, int cnt) {
		if (cnt == M) {
			count = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1) {
						count[i][j] = -1;
					}
				}
			}
			visited = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				que.add(new int[] { choice.get(i)[0], choice.get(i)[1] });
				visited[choice.get(i)[0]][choice.get(i)[1]] = true;
			}
			bfs();
			check();

			if (subResult != Integer.MIN_VALUE && ans > subResult) {
				ans = subResult;
			}
			stop++;
			return;
		}

		for (int i = start; i < al.size(); i++) {
			choice.add(al.get(i));
			comb(i + 1, cnt + 1);
			choice.remove(choice.size() - 1);
		}

	}

	public static void check() {
		boolean flag = false;
		subResult = Integer.MIN_VALUE;

		aa: for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i].length; j++) {
				if (map[i][j] == 0 && count[i][j] == 0) {
					none++;
					flag = true;
					break aa;
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i].length; j++) {
				if (!flag && map[i][j] != 2 && count[i][j] != -1 && subResult < count[i][j]) {
					subResult = count[i][j];
				}
			}
		}
	}

	public static void bfs() {
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int cy = tmp[0];
			int cx = tmp[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (safe(ny, nx) && !visited[ny][nx]) {
					if (map[ny][nx] != 1) {
						count[ny][nx] = count[cy][cx] + 1;
						visited[ny][nx] = true;
						que.offer(new int[] { ny, nx });
					}
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
}
