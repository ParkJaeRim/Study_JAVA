package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1427_소트인사이드 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();

		String[] tmp = new String[s.length()];
		tmp = s.split("");
		int[] lst = new int[tmp.length];

		for (int i = 0; i < tmp.length; i++) {
			lst[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(lst);
		
		for (int i = lst.length-1; i >=0; i--) {
			System.out.print(lst[i]);
		}
	}

}
