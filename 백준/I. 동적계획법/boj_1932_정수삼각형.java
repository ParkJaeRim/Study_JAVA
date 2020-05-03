package net.acmicpc;

import java.util.Scanner;

public class boj_1932_정수삼각형 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N  =scanner.nextInt();
		int[][] lst = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				lst[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j-1<0) {
					lst[i][j]+= lst[i-1][j];
				}
				else {
				lst[i][j] += Math.max(lst[i-1][j-1], lst[i-1][j]); 
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		
		for (int x = 0; x < lst[N-1].length; x++) {
			if(ans<lst[N-1][x]) {
				ans = lst[N-1][x];
			}
		}
		System.out.println(ans);
	}
}

