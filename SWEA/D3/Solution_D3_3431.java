package ssafy0213;

import java.util.Scanner;

public class Solution_D3_3431 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int v = scanner.nextInt();
			
			if(end<v) {
				System.out.println("#"+ tc+ " -1");
			}
			else if(start <= v && v<= end) {
				System.out.println("#"+ tc+" 0");
			}else {
				System.out.println("#"+tc + " "+ (start-v));
			}
		}
		
	}

}
