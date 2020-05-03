package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2636_치즈 {
	static int N, M, cnt;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] cheesemap;
	static int[][] newMap;
	static boolean flag = true;
	static int day = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		M = scanner.nextInt();
		N = scanner.nextInt();

		cheesemap = new int[M + 2][N + 2];
		visited = new boolean[M + 2][N + 2];

		// 혹시모를 상황 대비하여 Padding
		// 따라서, 무조건 0단지는 바깥 치즈

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				cheesemap[i][j] = scanner.nextInt();
			}
		}
		// 입력
		cheese(cheesemap);
		System.out.println(day);

	}

	public static void cheese(int[][] map) {
		visited = new boolean[M + 2][N + 2];
		newMap = new int[M + 2][N + 2];
		for (int i = 0; i < newMap.length; i++) {
			Arrays.fill(newMap[i], 1);
		} //
		flag = false;
		cnt = 0;
		for (int i = 0; i < M + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					zeroDanji(i, j);
					cnt++;
				}

				if (newMap[i][j] >= 2) {
					newMap[i][j] = 1;
				}
			}
		}
//		System.out.println("new");
//		print(newMap);

		find(newMap);
//		System.out.println("ori");
//		print(cheesemap);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (cheesemap[i][j] == 1) {
					day++;
					cheese(cheesemap);
				}
			}
		}
	}

////////////////////////////////////////////////////

	public static void zeroDanji(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		visited[i][j] = true;
		newMap[i][j] = cnt;

		while (!que.isEmpty()) {
			int[] cu = que.poll();
			int y = cu[0];
			int x = cu[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (safe(ny, nx) && !visited[ny][nx] && cheesemap[ny][nx] == 0) {
					visited[ny][nx] = true;
					newMap[ny][nx] = newMap[y][x];
					que.offer(new int[] { ny, nx });
				}
			}
		}

	}

	public static void find(int[][] lst) {
		int zeroCount = 0;
		for (int i = 0; i < M + 2; i++) {
			for (int j = 0; j < N + 2; j++) {

				if (lst[i][j] == 1) {
					zeroCount = 0;
					for (int d = 0; d < 4; d++) {
						if (safe(i + dy[d], j + dx[d]) && lst[i + dy[d]][j + dx[d]] == 0) {
							zeroCount++;
						}
					}
//					System.out.println(i + " " + j + " " + zeroCount);
					if (zeroCount >= 2) {
						cheesemap[i][j] = 0;
					}
				}
			}
		}
	}
	
	
	/////////////////////////////////////////
	
	public static boolean safe(int y, int x) {
		if (0 <= x && x < N + 2 && 0 <= y && y < M + 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
