package com.swea;

import java.util.Scanner;

public class Solution_D1_2029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + i + " " + (a/b) + " " + (a%b));
		}
	}

}
