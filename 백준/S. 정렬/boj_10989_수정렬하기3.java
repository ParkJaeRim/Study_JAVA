package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] lst = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lst[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(lst);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lst.length; i++) {
			sb.append(lst[i]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();

	}
}
