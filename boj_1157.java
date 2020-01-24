package net.acmicpc;

import java.util.Scanner;

public class boj_1157 {
	static int num;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String s = scanner.next();
		s = s.toUpperCase();
		int[] lst = new int[26];

		for (int i = 0; i < s.length(); i++) {
			num = ((int) s.charAt(i) - 65);
			lst[num] += 1;
		}

		int MAX =0 ;
		int cnt = 0;
		for (int i = 0; i < lst.length; i++) {
			MAX = lst[i] > MAX ? lst[i] : MAX;
		}

		for (int j = 0; j < lst.length; j++) {			
			if(lst[j]==MAX && lst[j] != 0) {
				cnt +=1;
			}
		}
		
		if(cnt>=2) {
			System.out.println("?");
		}
		else {
			for (int k = 0; k < lst.length; k++) {
				if(MAX == lst[k]) {
					System.out.println((char)(k+65));
				}
			}
		}		
	}
}
		
