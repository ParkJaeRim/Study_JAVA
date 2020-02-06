package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8741 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		String[] lst = new String[3];
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < lst.length; i++) {
				if(st.hasMoreTokens()) {
					lst[i] = st.nextToken();
				}
			}
			System.out.println("#" + tc + " ");
			for (int j = 0; j < lst.length; j++) {
				System.out.print(lst[j].substring(0,1).toUpperCase());
			}
			System.out.println();
		}

	}

}
