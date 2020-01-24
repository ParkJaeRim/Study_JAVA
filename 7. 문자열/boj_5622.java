package net.acmicpc;

import java.util.Scanner;

public class boj_5622 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int phone[]= new int[s.length()];
		
		for (int i=0; i<s.length();i++) {
			phone[i] = (int) s.charAt(i) - 65;
		}
		int sec = 0;

		for (int j = 0; j < phone.length; j++) {
			if(0 <= phone[j] && phone[j]<=2) {
				sec+=3;
			}
			else if(3<=phone[j]&& phone[j]<=5) {
				sec += 4;
			}
			else if(6<=phone[j]&& phone[j]<=8) {
				sec += 5;
			}
			else if(9<=phone[j]&& phone[j]<=11) {
				sec += 6;
			}
			else if(12<=phone[j]&& phone[j]<=14) {
				sec += 7;
			}
			else if(15<=phone[j]&& phone[j]<=18) {
				sec += 8;
			}
			else if(19<=phone[j]&& phone[j]<=21) {
				sec += 9;
			}
			else if(22<=phone[j]&& phone[j]<=25) {
				sec += 10;
			}
		}
		System.out.println(sec);
	}

}
