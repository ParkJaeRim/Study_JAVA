package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] test = new int[N];
		if (st.hasMoreTokens()) {
			for (int i = 0; i < N; i++) {
				test[i] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int major = 0;
		int minor = 0;
		if (st.hasMoreTokens()) {
			major = Integer.parseInt(st.nextToken());
			minor = Integer.parseInt(st.nextToken());
		}

		long tot = N;
		for (int i = 0; i < test.length; i++) {
			test[i] = test[i] - major;
			if (test[i] < 0) {
				test[i] = 0;
			}
			tot += test[i] / minor;
			if (test[i] % minor != 0) {
				tot++;
			}
		}
		System.out.println(tot);
	}
}
