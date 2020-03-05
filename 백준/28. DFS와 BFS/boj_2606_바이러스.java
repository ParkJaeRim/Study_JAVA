package net.acmicpc;

import java.util.Scanner;

public class boj_2606_바이러스 {
	static boolean[] visited;
	static int[][] map;
	static int N, M, cnt;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();

		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			map[u - 1][v - 1] = map[v - 1][u - 1] = 1;
		}
		visited[0] = true;
		cnt = 0;
		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int start) {

		for (int i = 0; i < N; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
				cnt++;
			}
		}
	}
}
