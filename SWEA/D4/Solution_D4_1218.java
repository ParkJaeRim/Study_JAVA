package com.swea;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218 {

	public static void main(String[] args) {
		HashMap<Character, Character> hm = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		hm.put('}','{');
		hm.put(')','(');
		hm.put('>','<');
		hm.put(']','[');

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stck = new Stack<>();

			int N = scanner.nextInt();
			char[] lst = new char[N];

			lst = scanner.next().toCharArray();
			boolean dec = true;
			
			for (int i = 0; i < lst.length; i++) {
				if (lst[i] == '{' || lst[i] == '<' ||lst[i] == '[' ||lst[i] == '(') {
					stck.push(lst[i]);
//					System.out.println(stck.push(lst[i]));
					
				} else {
					if(hm.get(lst[i]) == stck.peek()) {
						stck.pop();
//						System.out.println(stck.pop());
					}
					else {
						dec = false;
						break;
					}
				}
			}
			
			if((!stck.isEmpty())|| dec ==false) {
				System.out.println("#"+tc + " 0");
			}else {
				System.out.println("#"+tc + " 1");

			}
		}
	}
}

