package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_17837_새로운게임2 {
	static int N, M;
	static int[][] map;

	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };

	static ArrayList<Integer>[][] state;
	static mal[] horse;

	// 4시 5분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		state = new ArrayList[N + 1][N + 1];
		horse = new mal[M + 1];
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				state[i][j] = new ArrayList<>();
			}
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			horse[i + 1] = new mal(y, x, dir);
			state[y][x].add(i + 1);
		}

		int cnt = 1;

		aa: while (cnt <= 1000) {

			for (int turn = 1; turn <= M; turn++) {
				mal now = horse[turn];
				LinkedList<Integer> store = new LinkedList<>();

				for (int i = 0; i < state[now.y][now.x].size(); i++) {

					if (state[now.y][now.x].get(i) == turn) {
						int startidx = i;
						for (int j = startidx; j < state[now.y][now.x].size(); j++) {
							store.offer(state[now.y][now.x].get(j));
						}
						for (int j = startidx; j < state[now.y][now.x].size(); j++) {
							state[now.y][now.x].remove(j);
							j--;
						}
					}
				}
				if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
						&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 0) {
					int y = now.y + dy[now.dir];
					int x = now.x + dx[now.dir];

					while (!store.isEmpty()) {
						int tmp = store.pollFirst();
						state[y][x].add(tmp);
						horse[tmp].y = y;
						horse[tmp].x = x;
					}
				}

				else if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
						&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 1) {

					int y = now.y + dy[now.dir];
					int x = now.x + dx[now.dir];

					while (!store.isEmpty()) {
						int tmp = store.pollLast();
						state[y][x].add(tmp);
						horse[tmp].y = y;
						horse[tmp].x = x;
					}
				}

				else if ((safe(now.y + dy[now.dir], now.x + dx[now.dir])
						&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 2)) {
					now.dir = changedir(now.dir);
					if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
							&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 0) {
						int y = now.y + dy[now.dir];
						int x = now.x + dx[now.dir];

						while (!store.isEmpty()) {
							int tmp = store.pollFirst();
							state[y][x].add(tmp);
							horse[tmp].y = y;
							horse[tmp].x = x;
						}
					} else if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
							&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 1) {
						int y = now.y + dy[now.dir];
						int x = now.x + dx[now.dir];

						while (!store.isEmpty()) {
							int tmp = store.pollLast();
							state[y][x].add(tmp);
							horse[tmp].y = y;
							horse[tmp].x = x;
						}
					} else if (!safe(now.y + dy[now.dir], now.x + dx[now.dir])
							|| map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 2) {
						while (!store.isEmpty()) {
							int tmp = store.pollFirst();
							state[now.y][now.x].add(tmp);
							horse[tmp].y = now.y;
							horse[tmp].x = now.x;
						}
					}

				}

				else if (!safe(now.y + dy[now.dir], now.x + dx[now.dir])) {
					now.dir = changedir(now.dir);
					if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
							&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 0) {
						int y = now.y + dy[now.dir];
						int x = now.x + dx[now.dir];

						while (!store.isEmpty()) {
							int tmp = store.pollFirst();
							state[y][x].add(tmp);
							horse[tmp].y = y;
							horse[tmp].x = x;
						}
					} else if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
							&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 1) {
						int y = now.y + dy[now.dir];
						int x = now.x + dx[now.dir];

						while (!store.isEmpty()) {
							int tmp = store.pollLast();
							state[y][x].add(tmp);
							horse[tmp].y = y;
							horse[tmp].x = x;
						}
					} else if (safe(now.y + dy[now.dir], now.x + dx[now.dir])
							&& map[now.y + dy[now.dir]][now.x + dx[now.dir]] == 2) {
						while (!store.isEmpty()) {
							int tmp = store.pollFirst();
							state[now.y][now.x].add(tmp);
							horse[tmp].y = now.y;
							horse[tmp].x = now.x;
						}
					}
				}
				for (int i = 1; i < map.length; i++) {
					for (int j = 1; j < map[i].length; j++) {
						if (state[i][j].size() >= 4) {
							break aa;
						}
					}
				}
			}
			cnt++;
		}
		if (cnt > 1000)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}

	public static int changedir(int dir) {
		if (dir == 1)
			dir = 2;
		else if (dir == 2)
			dir = 1;
		else if (dir == 3)
			dir = 4;
		else if (dir == 4)
			dir = 3;
		return dir;
	}

	public static boolean safe(int y, int x) {
		if (y < N + 1 && x < N + 1 && y > 0 && x > 0) {
			return true;
		}
		return false;
	}

	public static class mal {
		int y;
		int x;
		int dir;

		public mal(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

	}
}
