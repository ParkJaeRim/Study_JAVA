package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_17315_캐슬디펜스 {
	static int N, M, D, fin, ans;
	static int[] cnt, arr;
	static int[][] map;
	static PriorityQueue<Pair> pq;
	static boolean go;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M];

		arr = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fin = Integer.MIN_VALUE;
		comb(0, 0, map);
		System.out.println(fin);
		br.close();

	}

	public static void comb(int start, int cnt, int[][] map) {
		if (cnt == 3) {
			ans = 0;
			int[][] castle = new int[N + 1][M];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, castle[i], 0, map[i].length);
			}
			go = true;

			while (go) {
				ArrayList<Pair> al = new ArrayList<>();
				for (int s = 0; s < 3; s++) {
					pq = new PriorityQueue<>();

					for (int i = 0; i < castle.length; i++) {
						for (int j = 0; j < castle[i].length; j++) {
							if (castle[i][j] == 1) {
								int dist = Math.abs((N) - i) + Math.abs(arr[s] - j);
								pq.add(new Pair(i, j, dist));
							}
						}
					}
					al.add(pq.poll());
				}

				for (int i = 0; i < 3; i++) {
					int y = al.get(i).y;
					int x = al.get(i).x;
					if (al.get(i).dist <= D && castle[y][x] == 1) {
						castle[y][x] = 0;
						ans++;
					}
				}
				down(castle);
			}
			fin = Math.max(ans, fin);
			return;
		}

		for (int i = start; i < M; i++) {
			arr[cnt] = i;
			comb(i + 1, cnt + 1, map);
		}
	}

	public static void down(int[][] castle) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < castle[i].length; j++) {
				if (castle[i][j] == 1) {
					if (i + 1 < N) {
						castle[i + 1][j] = 1;
					}
					castle[i][j] = 0;
				}
			}
		}
		go = false;
		for (int i = 0; i < castle.length; i++) {
			for (int j = 0; j < castle[i].length; j++) {
				if (castle[i][j] == 1) {
					go = true;
					return;
				}
			}
		}
	}

	public static class Pair implements Comparable<Pair> {
		int y;
		int x;
		int dist;

		public Pair(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.dist == o.dist) {
				return this.x - o.x;

			}
			return this.dist - o.dist;
		}

	}
}
