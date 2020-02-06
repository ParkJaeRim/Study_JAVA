package com.swea;

import java.util.Scanner;

public class Solution_D2_1945 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int num = scanner.nextInt();
			int[] lst = new int[5];
			
			while(num%2 ==0) {
				lst[0] += 1;
				num =  num/2;				
			}
			
			while(num%3 ==0) {
				lst[1] += 1;
				num =  num/3;				
			}
			while(num%5 ==0) {
				lst[2] += 1;
				num =  num/5;				
			}
			while(num%7 ==0) {
				lst[3] += 1;
				num =  num/7;				
			}
			while(num%11 ==0) {
				lst[4] += 1;
				num =  num/11;				
			}
			System.out.print("#" + tc +" ");
			for (int i = 0; i < lst.length; i++) {
				System.out.print(lst[i]+ " ");
			}
			System.out.println();
		} 
	}

}
