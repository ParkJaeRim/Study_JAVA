package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686_치킨배달 {
	static int N, M, ans, tot;
	static int[] arr, pick;
	static ArrayList<int[]> chicken, home, open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}

		chicken = new ArrayList<>();
		home = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < N; j++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 2) {
						chicken.add(new int[] { i, j });
					}
					if (x == 1) {
						home.add(new int[] { i, j });
					}
				}
			}
		}
		arr = new int[M];
		pick = new int[chicken.size()];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < chicken.size(); i++) {
			pick[i] = i;
		}
		combination(M, 0, 0);
		System.out.println(ans);
	}

	public static void combination(int m, int start, int cnt) {
		if (cnt == m) {
			open = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				int chickY = chicken.get(arr[i])[0];
				int chickX = chicken.get(arr[i])[1];
				open.add(new int[] { chickY, chickX });
			}

			find();
			if (tot < ans) {
				ans = tot;
			}
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			arr[cnt] = pick[i];
			combination(m, i + 1, cnt + 1);
		}
	}

	public static void find() {
		tot = 0;
		for (int i = 0; i < home.size(); i++) {
			int distance = Integer.MAX_VALUE;
			int[] h = home.get(i);
			for (int j = 0; j < open.size(); j++) {
				int[] c = open.get(j);
				distance = Math.min(distance, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
			}
			tot += distance;
		}
	}
}
