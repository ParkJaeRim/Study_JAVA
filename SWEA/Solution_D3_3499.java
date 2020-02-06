package com.swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_3499 {
	static int T;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Queue<String> queA = new LinkedList<>();
		Queue<String> queB = new LinkedList<>();

		T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			StringBuffer sb = new StringBuffer();
			int N = scanner.nextInt();
			queA.clear();
			queB.clear();
			String[] lst = new String[N];
			ArrayList<String> al = new ArrayList<>();
			String[] result = new String[N];
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.next();
			}

			if (N % 2 == 1) {
				for (int i = 0; i < lst.length / 2 + 1; i++) {
					queA.offer(lst[i]);
					if (i == lst.length / 2) {
						break;
					} else {
						queB.offer(lst[i + (lst.length / 2) + 1]);
					}
				}
			} else {
				for (int i = 0; i < lst.length / 2; i++) {
					queA.offer(lst[i]);
					queB.offer(lst[i + (lst.length / 2) ]);
				}

			}

			while (!(queA.isEmpty())) {
				sb.append(queA.poll()+ " ");
				if(!queB.isEmpty()) {
				sb.append(queB.poll()+ " ");
				}
				else {
					continue;
				}
			}
			System.out.println("#" + tc + " " + sb.toString().trim());
		}

	}

}