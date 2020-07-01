package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3020_개똥벌레 {
	static int N, H;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		int[] suk;

		if (N % 2 == 1) {
			suk = new int[H + 1];
		} else {
			suk = new int[H + 1];
		}

		int[] jong = new int[H + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (i % 2 == 0) {
				suk[Integer.parseInt(st.nextToken())]++;
			} else {
				jong[Integer.parseInt(st.nextToken())]++;
			}
		}
		int[] tmpsuk = new int[H + 1];
		int[] tmpjong = new int[H + 1];

		for (int j = 1; j < tmpsuk.length; j++) {
			tmpsuk[j] = tmpsuk[j - 1] + suk[j];
			tmpjong[j] = tmpjong[j - 1] + jong[j];
		}

		int cnt = 0;
		int minV = N;
		for (int i = 1; i <= H; i++) {
			int kkwang = 0;
			kkwang += tmpsuk[H] - tmpsuk[i - 1];
			kkwang += tmpjong[H] - tmpjong[H - i];

			if (minV > kkwang) {
				minV = kkwang;
				cnt = 1;
			} else if (minV == kkwang) {
				cnt++;
			}
		}
		System.out.println(minV + " " + cnt);
	}
}
