package com.swea;

import java.util.Scanner;

public class Solution_D1_1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			if(N%i==0) {
				System.out.print(i+" ");
			}
		}
	}

}
