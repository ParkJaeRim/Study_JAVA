package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_숫자카드{
	static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		check = new int[N];

		st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			for (int i = 0; i < N; i++) {
				check[i] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(check);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int ans = 0;
			int m = Integer.parseInt(st.nextToken());

			int startIdx = 0;
			int endIdx = check.length - 1;

			while (startIdx <= endIdx) {
				int midIdx = (startIdx + endIdx) / 2;

				if (m > check[midIdx]) {
					startIdx = midIdx + 1;
				} else if (m < check[midIdx]) {
					endIdx = midIdx - 1;
				} else {
					ans = 1;
					break;
				}
			}
			System.out.print(ans+" ");
		}
	}
}
