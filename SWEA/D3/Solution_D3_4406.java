package com.swea;

import java.util.Scanner;

public class Solution_D3_4406 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuffer sb = new StringBuffer();
			String s = scanner.next();
			for (int i = 0; i < s.length(); i++) {
				if(!(s.charAt(i)== 'a' ||s.charAt(i)== 'e' ||s.charAt(i)== 'i' ||
						s.charAt(i)== 'o' ||s.charAt(i)== 'u')) {
					sb.append(s.charAt(i));
				}
				else {
					continue;
				}
			}
			System.out.println("#" + tc + " "+ sb.toString());
		}
	}

}
