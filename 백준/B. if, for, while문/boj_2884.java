package baekjoon;

import java.util.Scanner;

public class boj_2884 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int time[] = new int[2];
		
		for(int i=0; i<2; i++) {
			time[i] = scanner.nextInt();
		}
		
		int hours = time[0];
		int minutes = time[1];
		
		if (hours != 0) {
			if (minutes < 45) {
				hours -= 1; minutes = 15+minutes ; 
				System.out.printf("%d %d",hours, minutes);

			}
			else if(minutes>45 && minutes <=60) {
				minutes -= 45;
				System.out.printf("%d %d", hours, minutes);
			}			
		}
		if (hours == 0) {
			if (minutes < 45) {
				hours = 23 ; minutes = 15+minutes ; 
				System.out.printf("%d %d",hours, minutes);

			}
			else if(minutes>45 && minutes <=60) {
				minutes -= 45;
				System.out.printf("%d %d", hours, minutes);
			}			
		}
	}
}
