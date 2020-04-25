package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int[][] map, border;
	static int N, min, max, danji, howMany, limit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
		}
		limit = (N * N + 1);
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		howMany = 0;
		first();
		System.out.println(howMany);
	}

	public static void first() {
		border = new int[N][N];
		visited = new boolean[N][N];

		danji = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					danji++;
				}
			}
		}

		if (danji != limit) {
			howMany++;
			first();
		} else {
			return;
		}
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { y, x });
		visited[y][x] = true;
		border[y][x] = danji;

		int count = 1;
		int ppl = map[y][x];

		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			for (int d = 0; d < 4; d++) {
				int curY = tmp[0] + dy[d];
				int curX = tmp[1] + dx[d];
				if (!(safe(curY, curX) && checkMinMax(map[curY][curX], map[tmp[0]][tmp[1]]) && !visited[curY][curX])) {
					continue;
				} else {
					count++;
					border[curY][curX] = danji;
					visited[curY][curX] = true;
					que.offer(new int[] { curY, curX });
					ppl += map[curY][curX];
				}
			}
		}

		for (int i = 0; i < border.length; i++) {
			for (int j = 0; j < border[i].length; j++) {
				////진짜.. 이거때문이라고....?///
				if (border[i][j] == danji && count > 1) {
					map[i][j] = ppl / count;
				}
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < N && x < N && y >= 0 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkMinMax(int future, int past) {
		if (Math.abs(future - past) >= min && Math.abs(future - past) <= max) {
			return true;
		}
		return false;
	}

	public static void print(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
