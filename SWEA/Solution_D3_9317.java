package com.swea;

import java.util.Scanner;

public class Solution_D3_9317 {
	static int T;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] a;
		char[] b;
		T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			a = new char[N];
			b = new char[N];
			String tmpa = scanner.next();
			String tmpb = scanner.next();
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if(tmpa.charAt(i)== tmpb.charAt(i)) {
//					if((int) (tmpa.charAt(i))== (int)tmpb.charAt(i)) {
				cnt++;
				}
			}
			System.out.println("#" +tc + " " +cnt);

		}

	}

}
