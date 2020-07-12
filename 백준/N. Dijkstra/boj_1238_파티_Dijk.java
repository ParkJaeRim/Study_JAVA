package net.acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1238_파티_Dijk {
	static int N, M, startNode;
	static int INF = 987654321;
	static ArrayList<Pair>[] al;
	static int[] dist;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();
		startNode = scanner.nextInt();

		al = new ArrayList[N + 1];

		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int value = scanner.nextInt();
			al[a].add(new Pair(b, value));
		}

		Dijk(startNode);

		int[][] ans = new int[N + 1][N + 1];
		for (int i = 1; i < dist.length; i++) {
			Dijk(i);
			for (int j = 0; j < dist.length; j++) {
				ans[i][j] = dist[j];
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 1; i < ans.length; i++) {
			result = Math.max(result, ans[i][startNode] + ans[startNode][i]);
		}
		System.out.println(result);
	}

	public static void Dijk(int s) {
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {
			Pair p = pq.poll();

			for (int i = 0; i < al[p.y].size(); i++) {
				int nextNode = al[p.y].get(i).y;
				int nextDist = p.value + al[p.y].get(i).value;

				if (dist[nextNode] > nextDist) {
					dist[nextNode] = nextDist;
					pq.offer(new Pair(nextNode, nextDist));
				}
			}
		}
	}

	public static class Pair implements Comparable<Pair> {
		int y;
		int value;

		public Pair(int y, int value) {
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}
}
