package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1068_트리 {
	static int N;
	static int[] whoIsParent, countSibling;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		whoIsParent = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			whoIsParent[i] = Integer.parseInt(st.nextToken());
		}

		countSibling = new int[N];

		for (int i = 0; i < countSibling.length; i++) {
			if (whoIsParent[i] != -1)
				countSibling[whoIsParent[i]]++;
		}

		int eraseNode = Integer.parseInt(br.readLine());
		find(eraseNode);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (whoIsParent[i] != -9 && countSibling[i] == 0) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static void find(int e) {
		if (whoIsParent[e] != -1)
			countSibling[whoIsParent[e]]--;

		for (int i = 0; i < N; i++) {
			if (whoIsParent[i] == e) {
				countSibling[e]--;
				if (countSibling[i] > 0) {
					find(i);
				} else if (countSibling[i] == 0) {
					whoIsParent[i] = -9;
				}
			}
		}
		whoIsParent[e] = -9;
	}
}
