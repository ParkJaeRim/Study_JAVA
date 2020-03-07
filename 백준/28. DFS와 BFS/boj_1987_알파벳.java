package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1987_알파벳 {
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static ArrayList<Character> al;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		R = scanner.nextInt();
		C = scanner.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		al = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			map[i] = scanner.next().toCharArray();
		}

		al.add(map[0][0]);
		visited[0][0] = true;
		ans = Integer.MIN_VALUE;

		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (safe(ny, nx) && !visited[ny][nx] && !al.contains(map[ny][nx])) {
				visited[ny][nx] = true;
				al.add(map[ny][nx]);

				dfs(ny, nx);

				visited[ny][nx] = false;
				al.remove(al.size() - 1);
			}

			if (al.size() > ans) {
				ans = al.size();
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y < R && x < C && y >= 0 && x >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
