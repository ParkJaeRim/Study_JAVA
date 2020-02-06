package com.swea;

import java.util.Scanner;

public class Solution_D2_1989 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			boolean dec = true;

			String s = scanner.next();
			char[] lst = new char[s.length()];
			char[] rev = new char[s.length()];
			lst = s.toCharArray();

			int x = 0;
			for (int i = lst.length - 1; i >= 0; i--) {
				rev[x] = lst[i];
				x++;
			}
			for (int i = 0; i < rev.length; i++) {
				if(rev[i]==lst[i]) {
					continue;
				}
				else {
					dec=false;
					break;
				}
			}
			if(!dec) {
				System.out.println("#" + tc + " 0");
			}
			else {
				System.out.println("#" + tc + " 1");
			}
		}
	}
}
