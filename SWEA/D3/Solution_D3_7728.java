package com.swea;

import java.util.Scanner;

public class Solution_D3_7728 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String  s = scanner.next();
			char[] lst = s.toCharArray();
			int[] num = new int[10];
			int cnt = 0;
			for (int i = 0; i < lst.length; i++) {
				num[lst[i]-'0']++;
			}
			
			for (int i = 0; i < num.length; i++) {
				if(num[i] >= 1) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " "+ cnt);
 		}
	}

}
