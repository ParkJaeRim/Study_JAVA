package com.baekjoon;

import java.util.Scanner;

public class boj_1546 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int[] score = new int[N];
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			score[i] = scanner.nextInt();			
		}
		double max = 0.0;
		
		for (int i = 0; i < score.length; i++) {
			max = max<score[i] ? score[i] : max;			
		}
		for (int i = 0; i < score.length; i++) {
			sum += (score[i]/max)*100;
	
		}
		double avg = sum / N;
		System.out.printf("%.2f",avg);
	}

}
