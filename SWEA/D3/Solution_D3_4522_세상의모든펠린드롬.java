package com.swea;

import java.util.Scanner;

public class Solution_D3_4522_세상의모든펠린드롬 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String s = scanner.next();
			char[] lst = new char[s.length()];

			for (int i = 0; i < lst.length; i++) {
				lst[i] = s.charAt(i);
			}
			boolean dec = true;
			for (int i = 0; i < lst.length / 2; i++) {
				if(lst[i]=='?'|| lst[lst.length-i-1] =='?') {
					continue;
				}
				else if (lst[i] != lst[lst.length - i - 1]) {
					dec = false;
					break;
				}
			}
			if (dec) {
				System.out.println("#" + tc + " Exist");
			} else {
				System.out.println("#" + tc + " Not exist");
			}
		}
	}
}
