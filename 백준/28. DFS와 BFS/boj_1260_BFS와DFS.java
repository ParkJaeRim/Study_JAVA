package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1260_BFS와DFS {
	static int N, M, V, a, b;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();
		V = scanner.nextInt();

		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();

			map[a - 1][b - 1] = map[b - 1][a - 1] = 1;
		}
		dfs(V - 1);
		System.out.println();
		visited = new boolean[N];
		bfs(V - 1);
	}

	private static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		visited[v] = true;
		que.offer(v);

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int i = 0; i < N; i++) {
				if (map[x][i] == 1 && !visited[i]) {
					visited[i] = true;
					que.offer(i);
				}
			}
			System.out.print((x + 1) + " ");
		}

	}

	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + 1 + " ");

		for (int i = 0; i < N; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}