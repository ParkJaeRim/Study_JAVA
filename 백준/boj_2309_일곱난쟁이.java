package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int[] lst = new int[9];
		for (int i = 0; i < 9; i++) {
			lst[i] = scanner.nextInt();
			sum += lst[i];
		}
		Arrays.sort(lst);
		int y = 0;
		int x = 0;
		for (int i = 0; i < lst.length; i++) {
			for (int j = i + 1; j < lst.length; j++) {
				if ((sum - lst[i] - lst[j]) == 100) {
					y = i;
					x = j;
				}
			}
		}
		
		for (int i = 0; i < lst.length; i++) {
			if(i!=y && i!=x) {
				System.out.println(lst[i]);
			}
		}
	}
}
