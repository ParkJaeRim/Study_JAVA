package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11724_연결요소의갯수_bfs {
	static boolean[] visited;
	static int[][] map;
	static int M, N, cnt;

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
		cnt = 0;
		for (int i = 0; i < map.length; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void bfs(int kk) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(kk);

		while (!que.isEmpty()) {
			int X = que.poll();
			visited[X] = true;
			for (int i = 0; i < N; i++) {
				if (map[X][i] == 1 && !visited[i]) {
					visited[i] = true;
					que.offer(i);
				}
			}
		}
	}
}
