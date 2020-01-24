package net.acmicpc;

import java.util.Scanner;

public class boj_3052 {
	static int[] lst = new int[42];
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int num = scanner.nextInt();
			
			lst[num%42] += 1;
			
		}
		for (int i = 0; i < lst.length; i++) {
			if(lst[i]> 0) {
				cnt +=1;
				
			}
		}System.out.println(cnt);
	}

}
