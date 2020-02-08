package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1223 {
	static char[] lst;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			lst = new char[N];
			String s = scanner.next();
			lst = s.toCharArray();
			System.out.println("#" + tc + " " + calc());
		}
	}

	public static String trans(char[] lst) {
		Stack<Character> stck = new Stack<>();
		String ss = "";

		for (int i = 0; i < lst.length; i++) {
			if (Character.isDigit(lst[i])) {
				ss += lst[i];
			} else {
				if (lst[i] == '+') {
					if (stck.isEmpty()) {
						stck.push(lst[i]);
					} else {
						while (!stck.isEmpty()) {
							ss += stck.pop();
						}
						stck.push(lst[i]);
					}
				} else {
					stck.push(lst[i]);
				}
			}
		}
		while (!stck.isEmpty()) {
			ss += stck.pop();
		}
		System.out.println(ss);
		return ss;
	}

	public static int calc() {
		String a = trans(lst);
		char[] result = new char[a.length()];
		Stack<Integer> what = new Stack<>();

		for (int i = 0; i < result.length; i++) {
			String tmp = a.substring(i, i + 1);
			result[i] = tmp.charAt(0);
		}

		for (int m = 0; m < result.length; m++) {
			if (result[m] >= '0' && result[m] <= '9') {
				what.push(result[m] - '0');
			} else if (result[m] == '+') {
				int x = what.pop();
				int y = what.pop();
				int add_result = x + y;
				what.push(add_result);
			} else if (result[m] == '*') {
				int i = what.pop();
				int j = what.pop();
				int multi_result = i * j;
				what.push(multi_result);
			}
		}
		int k = what.pop();
		return k;
	}
}