package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_4676 {
	static String k;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			StringBuffer st = new StringBuffer();
			st.append(scanner.next());

			int H = scanner.nextInt();
			int x = 0;
			int[] d = new int[H];
			for (int i = 0; i < H; i++) {
				d[i] = scanner.nextInt();
			}
			Arrays.sort(d);

			for (int j = 0; j < d.length; j++) {
				st.insert(d[j] + x, "-");
//				System.out.println(d[j] + " " + x);
//				System.out.println(st);
				x++;
			}
			System.out.println("#"+tc + " "+ st );
		}
	}

}
