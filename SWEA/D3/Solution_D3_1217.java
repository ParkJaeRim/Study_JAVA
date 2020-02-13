package ssafy0213;

import java.util.Scanner;

public class Soltuion_D3_1217 {
	static int c, mit, jisu;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			c = scanner.nextInt();
			mit = scanner.nextInt();
			jisu = scanner.nextInt();
			
//			System.out.println("#"+ tc + " " +  checking(mit, 0));
			checking(c, mit,1);
		}
	}
	
	public static void checking(int c, int x, int cnt) {
		
		if(cnt == jisu) {
			System.out.println("#"+c + " "+ x);
			return;
		}
		
		checking(c, x*mit,cnt+1);
	}

}
