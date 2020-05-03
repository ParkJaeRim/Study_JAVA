package net.acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_6118_숨바꼭질 {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	static int[] dist;
	static boolean flag;
	static int N;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		al = new ArrayList<>();

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < N + 1; i++) {
			al.add(new ArrayList<>());
		}

		int M = scanner.nextInt();

		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			al.get(start).add(end);
			al.get(end).add(start);
		}
//		que에는 (index, distande)
		int maxV = Integer.MIN_VALUE;

		Queue<Integer> que = new LinkedList<>();
		visited[1] = true;
		que.offer(1);
		dist[1] = 0;

		while (!que.isEmpty()) {
			int idx = que.poll();

			for (int i = 0; i < al.get(idx).size(); i++) {
				int next = al.get(idx).get(i);
				if (!visited[next] && dist[next] > dist[idx] + 1) {
					dist[next] = dist[idx] + 1;
					que.offer(next);
					visited[next] = true;
				}
			}
		}

		int ans1 = 0;
		int tmpMax = Integer.MIN_VALUE;
		for (int i = dist.length - 1; i > 0; i--) {
			if (tmpMax <= dist[i]) {
				ans1 = i;
				tmpMax = dist[i];
			}
		}

		int ans2 = dist[ans1];
		int ans3 = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[ans1] == dist[i]) {
				ans3++;
			}
		}
		
		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}
}
