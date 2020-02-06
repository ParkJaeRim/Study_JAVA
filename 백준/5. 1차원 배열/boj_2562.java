package com.baekjoon;

import java.util.Scanner;

public class boj_2562{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 9;
		int[] lst = new int[N];
		
		for (int i = 0; i < N; i++) {
			lst[i] = sc.nextInt();			
		}
		
		int MAX = 0;
		
		for (int i = 0; i < N; i++) {
			MAX = MAX < lst[i] ? lst[i] : MAX;
		}
		System.out.println(MAX);
		for (int i = 0; i < N; i++) {
			if (lst[i]==MAX) {
				System.out.println(i+1);
			}
		}
	}

}
