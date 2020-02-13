package ssafy0213;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_8500 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N =  scanner.nextInt();
			int[] lst = new int[N];
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			Arrays.sort(lst);
			int cnt = 0;
			for (int i = 0; i < lst.length; i++) {
				if(i==N-1) {
					cnt+= lst[i];
				}
				cnt +=  lst[i];
				cnt ++;
			}
			System.out.println("#" + tc + " "+  cnt);
		}
	}

}
