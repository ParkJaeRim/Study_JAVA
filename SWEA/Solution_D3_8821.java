package com.swea;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_8821 {
	static int T;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		ArrayList<Integer> al = new ArrayList<>();

		for (int tc = 1; tc <= T; tc++) {
			String S = scanner.next();
			int[] lst = new int[S.length()];
			al.clear();
			
			for (int i = 0; i < S.length(); i++) {
				int x = S.charAt(i) - '0';
				if (!al.contains(x)) {
					al.add(x);
				} else {
					for (int j = 0; j < al.size(); j++) {
						if(al.get(j)==x) {
							al.remove(j);
						}
					}
				}
			}
			if (al.isEmpty()) {
				System.out.println("#"+tc +" "+0);
			} else {
				System.out.println("#"+tc +" "+al.size());
			}
		}

	}

}
