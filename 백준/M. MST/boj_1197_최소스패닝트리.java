package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리 {
	static int V, E;
	static int[] parentNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> que = new PriorityQueue<>();

		parentNode = new int[V + 1];

		for (int i = 1; i < parentNode.length; i++) {
			parentNode[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			que.offer(new Edge(from, to, weight));
		}

		int result = 0;
		while (!que.isEmpty()) {
			Edge tmp = que.poll();
			int from = find(tmp.start);
			int to = find(tmp.end);

			if (from != to) {
				union(from, to);
				result += tmp.value;
			} else {
				continue;
			}
		}
		System.out.println(result);
	}

	public static void union(int m, int n) {
		int rootM = find(m);
		int rootN = find(n);
		if (rootM != rootN) {
			parentNode[rootM] = rootN;
		} else {
			return;
		}

	}

	public static int find(int x) {
		if (parentNode[x] == x) {
			return x;
		}
		return parentNode[x] = find(parentNode[x]);
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
			if (this.value > o.value) {
				return 1;
			} else if (this.value == o.value) {
				return 0;
			}
			return -1;
		}
	}

}
