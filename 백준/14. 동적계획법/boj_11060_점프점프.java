package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_11060_점프점프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] miro = new int[N];
		int[] cnt = new int[N];

		st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			for (int i = 0; i < N; i++) {
				miro[i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= miro[i]; j++) {
				if (i + j < N && cnt[i + j] == 0) {
					if ((cnt[i] == 0 && i == 0) || cnt[i] != 0) {
						cnt[i + j] = cnt[i] + 1;
					} else {
						cnt[i + j] = Math.min(cnt[i + j], cnt[i] + 1);
					}
				}
			}
		}
		int ans = 0;
		if (N == 1) {
			ans = 0;
		} else if (cnt[N - 1] == 0) {
			ans = -1;
		} else {
			ans = cnt[N - 1];
		}
		System.out.println(ans);
	}
}
