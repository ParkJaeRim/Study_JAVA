package com.swea;

import java.util.Scanner;

public class Solution_D1_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= a; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
