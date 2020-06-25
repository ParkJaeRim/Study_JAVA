package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512_예산{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] lst = new int[N];
		int sum = 0;
		int real_max = 0;
		st = new StringTokenizer(br.readLine());
		if (st.hasMoreTokens()) {
			for (int i = 0; i < N; i++) {
				lst[i] = Integer.parseInt(st.nextToken());
				sum += lst[i];
				real_max = Math.max(real_max, lst[i]);
			}
		}

		st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(st.nextToken());

		Arrays.sort(lst);

		int start = 0;
		int end = max;
		int mid = 0;
		int ans = Integer.MIN_VALUE;
		if (sum <= max) {
			System.out.println(real_max);
		} else {
			while (start < end) {
				int tot = 0;
				mid = (start + end) / 2;

				for (int i = 0; i < lst.length; i++) {
					if (lst[i] < mid) {
						tot += lst[i];
					} else {
						tot += mid;
					}
				}
				if (tot > max) {
					end = mid;
				} else {
					start = mid + 1;
					ans = Math.max(ans, mid);
				}
			}
			System.out.println(ans);
		}
	}
}
