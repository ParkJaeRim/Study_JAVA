package net.acmicpc;

import java.util.Scanner;

public class boj_2292 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int what = 1;
		int i=1;
		
		while(N>what) {
			what += 6*i;
			i ++;
		}
		System.out.println(i);
	}
	

}
