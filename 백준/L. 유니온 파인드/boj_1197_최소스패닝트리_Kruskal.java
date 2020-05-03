package net.acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1197_최소스패닝트리_Kruskal {
	static int[] parent;

	public static void main(String[] args) {
		// 정점 , 간선
		// u,v, cost
		Scanner scanner = new Scanner(System.in);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int cost = scanner.nextInt();

			pq.add(new Edge(u, v, cost));
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			Edge current = pq.poll();

			int currentStart = find(current.start);
			int currentEnd = find(current.end);

			if (currentStart != currentEnd) { 
				//부모노드가 다름 => 합치는 함수 실행해봄
				union(currentStart, currentEnd);
				//합쳐졌다면 value더해줌.
				ans += current.value;
			}

		}
		System.out.println(ans);

	}

	public static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot != yRoot) {
			parent[xRoot] = yRoot;
		} else {
			return;
		}
	}

	public static int find(int w) {
		if (parent[w] == w) {
			return w;
		} else {
			parent[w] = find(parent[w]);
			return parent[w];
		}
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;

		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}
}
