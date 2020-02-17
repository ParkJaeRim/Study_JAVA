package com.swea;

import java.util.Scanner;

public class Solution_D3_5549 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = scanner.next();
			
			int x = Integer.parseInt(s.substring(s.length()-1, s.length()));
			
			if(x%2 == 1) {
				System.out.println("#"+tc+ " Odd");
			}else {
				System.out.println("#"+tc+ " Even");
			}
			
		}
	}

}
