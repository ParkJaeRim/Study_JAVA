package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_11725_트리의부모찾기 {
	static int N;
//	static int[][] map;
	static ArrayList<Integer>[] map;
	static int[] whoIsParent;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();

		map = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			map[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			map[u].add(v);
			map[v].add(u);
		}
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].size(); j++) {
//				System.out.print(map[i].get(j) + " ");
//			}
//			System.out.println();
//		}

		int start = 1;
		visited = new boolean[N + 1];
		whoIsParent = new int[N + 1];

		visited[start] = true;
		find(start);
		for (int i = 2; i < whoIsParent.length; i++) {
			System.out.println(whoIsParent[i]);
		}

	}

	public static void find(int root) {
		for (int i = 0; i < map[root].size(); i++) {
			if (!visited[map[root].get(i)]) {
				whoIsParent[map[root].get(i)] = root;
				visited[map[root].get(i)] = true;
				find(map[root].get(i));
			}
		}

	}
}
