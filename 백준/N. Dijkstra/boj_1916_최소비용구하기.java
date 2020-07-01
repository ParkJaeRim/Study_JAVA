import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();

		ArrayList<Pair>[] list = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < M; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int value = scanner.nextInt();

			list[u].add(new Pair(v, value));

		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		int start = scanner.nextInt();
		int goal = scanner.nextInt();

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Pair(start, dist[start]));

		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int current = p.idx;
			int distance = p.distance;

			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i).idx;
				int nextDist = distance + list[current].get(i).distance;
				if (dist[next] > nextDist) {
					dist[next] = nextDist;
					pq.offer(new Pair(next, nextDist));
				}
			}
		}
		
		System.out.println(dist[goal]);

	}

	public static class Pair implements Comparable<Pair> {
		int idx;
		int distance;

		public Pair(int idx, int distance) {
			this.idx = idx;
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair o) {
			return this.distance - o.distance;
		}

	}

}