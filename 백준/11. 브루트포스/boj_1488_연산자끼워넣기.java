package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1488_연산자끼워넣기 {
	static int N;
	static int[] num;
	static int[] cal;
	static char[] calArr;
	static boolean[] visited;
	static ArrayList<Character> al;
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		num = new int[N];
		cal = new int[4];

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
		// + - * /

		al = new ArrayList<>();

		for (int i = 0; i < cal.length; i++) {
			if (cal[i] != 0) {
				if (i == 0) {
					for (int j = 0; j < cal[i]; j++) {
						al.add('+');
					}
				}
				if (i == 1) {
					for (int j = 0; j < cal[i]; j++) {
						al.add('-');
					}
				}
				if (i == 2) {
					for (int j = 0; j < cal[i]; j++) {
						al.add('*');
					}
				}
				if (i == 3) {
					for (int j = 0; j < cal[i]; j++) {
						al.add('/');
					}
				}
			}
		}
		calArr = new char[al.size()];
		visited = new boolean[al.size()];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		calPerm(0);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	public static void calPerm(int cnt) {
		if (cnt == calArr.length) {
			int sum = num[0];
			for (int i = 0; i < calArr.length; i++) {
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
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}

		}
		for (int i = 0; i < calArr.length; i++) {
			if (!visited[i]) {
				calArr[cnt] = al.get(i);
				visited[i] = true;
				calPerm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
