package baekjoon;

import java.util.Scanner;

public class boj_2588 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		int y_100 = y / 100; 
		int y_10 = (y - (y_100 * 100)) / 10 ;
		int y_1 = y %10;

		System.out.println(x*y_1);
		System.out.println(x*y_10);		
		System.out.println(x*y_100);
		System.out.println(x*y);
		
	}

}
