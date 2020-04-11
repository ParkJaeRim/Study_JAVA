package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_14891_톱니바퀴 {
	static char[] topni1, topni2, topni3, topni4;
	static boolean[] visited;
	static ArrayList<char[]> al;
	static int[] rotate;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		al = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		topni1 = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		topni2 = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		topni3 = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		topni4 = st.nextToken().toCharArray();

		al.add(topni1);
		al.add(topni2);
		al.add(topni3);
		al.add(topni4);

		st = new StringTokenizer(br.readLine());
		int howMany = Integer.parseInt(st.nextToken());

		for (int i = 0; i < howMany; i++) {
			st = new StringTokenizer(br.readLine());
			visited = new boolean[4];
			rotate = new int[4];
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			int topni = x - 1;
			visited[topni] = true;
			rotate[topni] = dir;

			Clock(topni, dir);
			move();
		}

		ArrayList<Character> result = new ArrayList<>();
		for (int j = 0; j < al.size(); j++) {
			result.add(al.get(j)[0]);
		}

		int ans = 0;
		if (result.get(0) == '1') {
			ans += 1;
		}
		if (result.get(1) == '1') {
			ans += 2;
		}
		if (result.get(2) == '1') {
			ans += 4;
		}
		if (result.get(3) == '1') {
			ans += 8;
		}
		System.out.println(ans);

	}

	public static void move() {
		for (int i = 0; i < rotate.length; i++) {
			if (rotate[i] == 1) {
				char[] tmp = al.get(i);
				char store = tmp[tmp.length - 1];
				for (int j = tmp.length - 1; j > 0; j--) {
					tmp[j] = tmp[j - 1];
				}
				tmp[0] = store;
			} else if (rotate[i] == -1) {
				char[] tmp = al.get(i);
				char store = tmp[0];

				for (int j = 0; j < tmp.length - 1; j++) {
					tmp[j] = tmp[j + 1];
				}
				tmp[tmp.length - 1] = store;
			}
		}

	}

	public static void Clock(int topni, int dir) {
		if (topni + 1 < 4 && !visited[topni + 1]) {
			if (al.get(topni)[2] == al.get(topni + 1)[6]) {
				visited[topni + 1] = true;
			} else {
				rotate[topni + 1] = rotate[topni] * (-1);
				visited[topni + 1] = true;
				Clock(topni + 1, dir);
			}
		}
		if (topni - 1 >= 0 && !visited[topni - 1]) {
			char[] tmp = al.get(topni);
			if (al.get(topni)[6] == al.get(topni - 1)[2]) {
				visited[topni - 1] = true;
			} else {
				rotate[topni - 1] = rotate[topni] * (-1);
				visited[topni - 1] = true;
				Clock(topni - 1, dir);
			}
		}
	}
}
