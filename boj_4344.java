package net.acmicpc;

import java.util.Scanner;

public class boj_4344 {
	static int sum, avg,cnt;
	static double ratio;
	static int[] student;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int i = 0; i < T; i++) {
			sum = 0 ;
			avg = 0;
			cnt = 0;
			ratio = 0;
			int N = scanner.nextInt();
			student = new int[N];
			
			for (int j = 0; j < N; j++) {
				student[j] = scanner.nextInt();
				sum += student[j];
				avg = sum/N;				
			}
			
			for (int k = 0; k < student.length; k++) {
				if(student[k]>avg) {
					cnt += 1;
					ratio = (double) cnt / N * 100;
					
				}
				
			}
			System.out.printf("%.3f",ratio);
			System.out.println("%");
			
		}
	}

}
