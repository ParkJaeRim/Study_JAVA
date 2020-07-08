package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1753_최단경로 {
	static int V, E;
	static int[] dist;
	static ArrayList<Edge>[] al;
	static boolean[] visited;
	static Queue<Edge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[V + 1];
		visited = new boolean[V + 1];
		al = new ArrayList[V + 1];

		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < V + 1; i++) {
			al[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al[x].add(new Edge(y, v));
		}

		for (int i = 0; i < al.length; i++) {
			ArrayList<Edge> a = al[i];
		}

		visited[start] = true;

		int INF = 987654321;
		Arrays.fill(dist, INF);
		pq = new LinkedList<>();
		dist[start] = 0;
		find(start);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	public static void find(int s) {
		for (int j = 0; j < al[s].size(); j++) {
			pq.offer(new Edge(al[s].get(j).y, al[s].get(j).v));
		}

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (dist[e.y] > dist[s] + e.v) {
				dist[e.y] = dist[s] + e.v;
			}
		}

		int x = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 1; i < dist.length; i++) {
			if (!visited[i] && dist[i] != 0 && x > dist[i]) {
				x = Math.min(x, dist[i]);
				idx = i;
			}
		}
		if (idx != -1)
			visited[idx] = true;
		else
			return;
		find(idx);
	}

	public static class Edge {
		int y;
		int v;

		public Edge(int y, int v) {
			this.y = y;
			this.v = v;
		}
	}
}
