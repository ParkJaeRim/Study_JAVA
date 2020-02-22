package com.swea;

import java.util.Scanner;

public class Solution_D3_4047 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = scanner.next();
			String[] lst = new String[s.length() / 3];
			boolean result = true;
			int[] dec = new int[4];

			for (int i = 1; i <= s.length() / 3; i++) {
				lst[i - 1] = s.substring(3 * i - 3, 3 * i);
//				System.out.println(lst[i-1]);
			}

			for (int i = 0; i < lst.length; i++) {
				for (int j = i + 1; j < lst.length; j++) {
					if (lst[i].equals(lst[j])) {
//						System.out.println(lst[i]+ " " +lst[j]);
						result = false;
					}
				}
				if (lst[i].charAt(0) == 'S') {
					dec[0]++;
				} else if (lst[i].charAt(0) == 'D') {
					dec[1]++;
				} else if (lst[i].charAt(0) == 'H') {
					dec[2]++;
				} else if (lst[i].charAt(0) == 'C') {
					dec[3]++;
				}
			}

			System.out.print("#" + tc + " ");
			if (!result) {
				System.out.print("ERROR");
			} else {
				for (int i = 0; i < dec.length; i++) {
					System.out.print(13 - dec[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
