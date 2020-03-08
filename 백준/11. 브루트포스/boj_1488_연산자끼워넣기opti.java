package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_1488_연산자끼워넣기opti {
	static int N;
	static int[] num;
	static int[] cal;
	static char[] calArr;
	static char[] calArr1 = { '+', '-', '*', '/' };
	static boolean[] visited;
	static int sum, min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		num = new int[N];
		cal = new int[4];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			for (int i = 0; i < cal.length; i++) {
				cal[i] = Integer.parseInt(st.nextToken());
			}
		}

		calArr = new char[N - 1];

		calPerm(0);

		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(min);
		System.out.println(sb);

	}

	public static void calPerm(int cnt) {
		if (cnt == calArr.length) {
			sum = num[0];
			for (int i = 0; i < N - 1; i++) {
				if (calArr[i] == '+') {
					sum += num[i + 1];
				}
				if (calArr[i] == '-') {
					sum -= num[i + 1];
				}
				if (calArr[i] == '*') {
					sum *= num[i + 1];
				}
				if (calArr[i] == '/') {
					sum /= num[i + 1];
				}
			}
			if (max < sum)
				max = sum;
			if (min > sum)
				min = sum;
		}

		for (int i = 0; i < 4; i++) {
			if (cal[i] != 0) {
				cal[i]--;
				calArr[cnt] = calArr1[i];
				calPerm(cnt + 1);
				cal[i]++;
			}
		}
	}
}