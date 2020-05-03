package net.acmicpc;

import java.util.Scanner;

public class boj_1094_막대기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int cnt = 1;
		while (N != 1) {
			if (N % 2 != 0) {
				cnt++;
			}
			N /= 2;
		}
		System.out.println(cnt);
	}
}
