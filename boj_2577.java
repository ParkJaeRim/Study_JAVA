package com.baekjoon;

import java.util.Scanner;

public class boj_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int result = A*B*C;
		int N = 10;
		
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] =0;
		}
		
		int i = 10;
		while (result!=0) {
			int a = result % i;
			result /= i; 
			num[a] += 1;
			}
		for (int j = 0; j < num.length; j++) {
			System.out.println(num[j]);
		}
	}
}
