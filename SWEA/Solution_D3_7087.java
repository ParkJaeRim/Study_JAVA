package com.swea;

import java.util.Scanner;

public class Solution_D3_7087 {
	static int N;
	static char[] lst;
	static int cnt;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			cnt =0;
			N = scanner.nextInt();
			lst = new char[N];
			
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.next().charAt(0);
			}
			System.out.println("#"+tc + " " + checking('A'));
		}
	}
	
	public static int checking(char ch) {
		for (int i = 0; i < N; i++) {
			if(lst[i] == ch) {
				cnt ++;
				checking((char) (ch+1));
				break;
			}
		}
		return cnt;
	}

}