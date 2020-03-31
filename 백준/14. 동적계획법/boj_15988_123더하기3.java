package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_15988_123더하기3 {
	static long[] lst = new long[1000001];
	static long need = 1000000009L;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(st.nextToken());
		lst[0] = 1;
		lst[1] = 1;
		lst[2] = 2;
		lst[3] = 4;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			for (int i = 4; i <= 1000000; i++) {
				if (lst[i] != 0) {
					break;
				}
				lst[i] = (lst[i - 1] + lst[i - 2] + lst[i - 3]) % need;
			}
			bw.write(lst[N] + "\n");
			bw.flush();
		}
	}

}