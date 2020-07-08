package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753_최단경로 {
	static ArrayList<Pair>[] lst;
	static int N, x;
	static boolean[] visited;
	static boolean flag;
	static int[] dist;
	static int start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
		}

		dist = new int[N + 1];
		visited = new boolean[N + 1];
		lst = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			lst[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				lst[u].add(new Pair(v, weight));
			}
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Pair(start, dist[start]));

		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int current = p.idx;
			int distance = p.dist;

			if (dist[current] < distance) {
				continue;
			}

			for (int i = 0; i < lst[current].size(); i++) {
				int next = lst[current].get(i).idx;
				int nextDistance = distance + lst[current].get(i).dist;

				if (nextDistance < dist[next]) {
					dist[next] = nextDistance;
					pq.offer(new Pair(next, nextDistance));
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	}

	public static class Pair implements Comparable<Pair> {

		int idx;
		int dist;

		public Pair(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}

	}
}
