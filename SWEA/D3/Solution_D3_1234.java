package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			int N = scanner.nextInt();
			String s = scanner.next();
			Stack<Character> stck = new Stack<>();

			for (int i = 0; i < N; i++) {
				if (stck.isEmpty()) {
					stck.push(s.charAt(i));
				} else if (stck.peek() != s.charAt(i)) {
					stck.push(s.charAt(i));
				} else if (stck.peek() == s.charAt(i)) {
					stck.pop();
				}
			}
			char[] lst = new char[stck.size()];
			int kk = 0;
			while (!stck.isEmpty()) {
				lst[kk] = stck.pop();
				kk++;
			}
			System.out.print("#" + tc + " ");
			for (int i = lst.length - 1; i >= 0; i--) {
				System.out.print(lst[i] + "");
			}
			
			System.out.println();
		}
	}
}
