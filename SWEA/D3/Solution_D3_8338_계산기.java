package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_8338_계산기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] lst = new int[N];
			Stack<Integer> stck = new Stack<>();

			for (int i = 0; i < lst.length; i++) {
				lst[i] = scanner.nextInt();
			}

			for (int i = 0; i < lst.length; i++) {
				if (stck.isEmpty()) {
					stck.push(lst[i]);
				} else if (stck.peek() == 1 || stck.peek() == 0) {
					int x = stck.pop() + lst[i];
					stck.push(x);

				} else if (lst[i] != 0 && lst[i] != 1) {
					int x = stck.pop() * lst[i];
					stck.push(x);
				} else if (lst[i] == 0 || lst[i] == 1) {
					int x = stck.pop() + lst[i];
					stck.push(x);
				}

			}
			System.out.println("#" + tc + " " + stck.peek());
		}
	}

}