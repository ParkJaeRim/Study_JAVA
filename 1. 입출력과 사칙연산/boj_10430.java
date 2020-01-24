package baekjoon;

import java.util.Scanner;

public class boj_10430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lst []= new int[3];
		
		for (int i=0; i<3; i++) {
			lst[i] = sc.nextInt();
		}
		
		
		System.out.println((lst[0]+lst[1])%lst[2]);
		System.out.println((lst[0]%lst[2] + lst[1]%lst[2])%lst[2]);
		System.out.println((lst[0]*lst[1])%lst[2]);
		System.out.println((lst[0]%lst[2] *lst[1]%lst[2])%lst[2]);
		
	}

}
