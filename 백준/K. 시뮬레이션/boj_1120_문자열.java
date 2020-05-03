package net.acmicpc;

import java.util.Scanner;

public class boj_1120_문자열 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char[] a = scanner.next().toCharArray();
		char[] b = scanner.next().toCharArray();

		int len = b.length - a.length;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= len; i++) {
			char[] newA = new char[b.length];
			int cnt = 0;
			
			for (int j = 0; j < a.length; j++) {
				newA[j + i] = a[j];
			}
			
			for (int j = 0; j < newA.length; j++) {
				if (newA[j] != 0 && b[j] != newA[j]) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
