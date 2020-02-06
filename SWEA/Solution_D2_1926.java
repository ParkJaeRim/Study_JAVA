package com.swea;

import java.util.Scanner;

public class Solution_D2_1926 {
	static int cnt;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		StringBuffer sb = new StringBuffer();

		for (int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			cnt = 0;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
					cnt++;
				}
			}
			if (cnt == s.length()) {
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
			} else if (cnt != 0 && cnt < s.length()) {
				sb.append("-");
			} else {
				sb.append(s);
			}
			sb.append(" ");
		}
		System.out.print(sb);
	}

}
