package baekjoon;

import java.util.Scanner;

public class boj_1330 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int lst[] = new int[2];
		
		for (int i=0; i<2; i++) {
			lst[i]= scanner.nextInt();
		}
		
		if (lst[0] > lst[1]) {
			System.out.println(">");			
		}
		else if (lst[0] == lst[1]) {
			System.out.println("==");
		}
		
		else {
			System.out.println("<");
		}
	}

}
