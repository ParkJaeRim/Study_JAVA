package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//약 1시간 30분 걸림.
public class boj_15686_치킨배달 {
	static int N, M, dist, ans;
	static int[] arr, pick;
	static int[][] map, count, cityMap;
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static ArrayList<int[]> chicken;
	static Queue<int[]> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		map = new int[N][N];

		int cntChicken = 0;

		chicken = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						chicken.add(new int[] { i, j });
					}
				}
			}
		}
		arr = new int[M];
		pick = new int[chicken.size()];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < chicken.size(); i++) {
			pick[i] = i;
		}
		combination(M, 0, 0);
		System.out.println(ans);
	}

	public static void combination(int m, int start, int cnt) {
		if (cnt == m) {
			cityMap = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				int chickY = chicken.get(arr[i])[0];
				int chickX = chicken.get(arr[i])[1];
				cityMap[chickY][chickX] = 3;
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1) {
						cityMap[i][j] = 1;
					}
				}
			}

			bfs();
			if (dist < ans) {
				ans = dist;
			}
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			arr[cnt] = pick[i];
			combination(m, i + 1, cnt + 1);
		}
	}

	public static void bfs() {
		dist = 0;
		que = new LinkedList<>();
		for (int i = 0; i < cityMap.length; i++) {
			for (int j = 0; j < cityMap.length; j++) {
				que.clear();
				aa: if (cityMap[i][j] == 1) {
					visited = new boolean[N][N];
					count = new int[N][N];
					que.offer(new int[] { i, j });
					visited[i][j] = true;
					while (!que.isEmpty()) {
						int[] tmp = que.poll();
						int cy = tmp[0];
						int cx = tmp[1];
						for (int d = 0; d < 4; d++) {
							int ny = cy + dy[d];
							int nx = cx + dx[d];
							if (safe(ny, nx) && !visited[ny][nx]) {
								count[ny][nx] = count[cy][cx] + 1;
								visited[ny][nx] = true;
								if (cityMap[ny][nx] == 3) {
									dist += count[ny][nx];
									break aa;
								}
								que.offer(new int[] { ny, nx });
							}
						}
						if (dist >= ans) {
							return;
						}
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
