package baekjoon;

import java.util.Scanner;

public class boj_1110{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y,buffer;
		int cnt =0;		
		int given = scanner.nextInt();
	
		x= given/10; y= given %10;
		buffer = given -1 ;
		
		while (given!=buffer) {
			buffer = x+y;
			buffer = y*10 + buffer %10;
			x = buffer /10 ; y= buffer %10;
			cnt +=1;
		}		
		System.out.print(cnt);
	}
}