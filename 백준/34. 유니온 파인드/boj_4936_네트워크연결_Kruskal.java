package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4936_네트워크연결_Kruskal {
	static int N, M, u, v, cost;
	static int[] parent;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
			}
			pq.add(new Edge(u, v, cost));
		}

		int result = 0;
		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();

			int tmpstart = find(tmp.start);
			int tmpend = find(tmp.end);

			if (tmpstart != tmpend) {
				union(tmpstart, tmpend);
				result += tmp.value;
			}
		}

		System.out.println(result);

	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = bRoot;
		} else {
			return;
		}

	}

	public static int find(int c) {
		if (parent[c] == c) {
			return c;
		}
		return parent[c] = find(parent[c]);
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
