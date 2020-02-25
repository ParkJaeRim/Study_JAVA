package net.acmicpc;
//참고 TestCase Link http://acm.student.cs.uwaterloo.ca/~acm00/090613/data/ 의 B~로 시작하는 data들
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_4179_불 {
	static int M, N, startY, startX;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static char[][] map;
	static int[][] fire, jihoon;
	static boolean[][] visited;
	static boolean flag;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		M = scanner.nextInt();
		N = scanner.nextInt();

		map = new char[M + 2][N + 2];
		fire = new int[M + 2][N + 2];
		visited = new boolean[M + 2][N + 2];
		jihoon = new int[M + 2][N + 2];

		for (int i = 1; i < M + 1; i++) {
			String s = scanner.next();
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = s.charAt(j - 1);
				if (map[i][j] == 'J') {
					startY = i;
					startX = j;
				}
				if (map[i][j] == '#') {
					fire[i][j] = -1;
					jihoon[i][j] = -1;
				}
				if (map[i][j] == 'F') {
					jihoon[i][j] = -1;
				}
			}
		}

		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < M + 2; i++) {
			for (int j = 0; j < N + 2; j++) {

				if (map[i][j] == 'F') {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
					fire[i][j] = 0;
				}
			}
		}

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0];
			int x = cur[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx] && (map[ny][nx] == '.' || map[ny][nx] == 'J')) {
					visited[ny][nx] = true;
					fire[ny][nx] = fire[y][x] + 1;
					que.offer(new int[] { ny, nx });
				}
			}
		}

		visited = new boolean[M + 2][N + 2];
		go(startY, startX);
		if (!flag) {
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void go(int i, int j) {
		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			int y = cur[0];
			int x = cur[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (safe(ny, nx) && !visited[ny][nx]) {
					if (ny == 0 || ny == M + 1 || nx == 0 || nx == N + 1) {
						jihoon[ny][nx] = jihoon[y][x] + 1;
						visited[ny][nx] = true;
						flag = true;
						System.out.println(jihoon[ny][nx]);
						return;
					}

					if (fire[ny][nx] == 0 && jihoon[ny][nx] == 0) {
						jihoon[ny][nx] = jihoon[y][x] + 1;
						visited[ny][nx] = true;
						que.offer(new int[] { ny, nx });
					}
					if (fire[ny][nx] != -1 && jihoon[ny][nx] == 0 && jihoon[y][x] + 1 < fire[ny][nx]) {
						jihoon[ny][nx] = jihoon[y][x] + 1;
						visited[ny][nx] = true;
						que.offer(new int[] { ny, nx });
					}
				}
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < M + 2 && x < N + 2 && y >= 0 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
