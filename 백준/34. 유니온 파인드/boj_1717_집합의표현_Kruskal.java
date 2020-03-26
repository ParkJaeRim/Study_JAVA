package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1717_집합의표현_Kruskal {
	static int[] parent;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}

		parent = new int[N + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				int what = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				if (what == 0) {
					union(u, v);
				} else if (what == 1) {
					int aa = find(u);
					int bb = find(v);

					if (aa == bb) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
			}
		}
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
		} else {
			parent[c] = find(parent[c]);
			return parent[c];
		}
	}
}