package ssafy0213;

import java.util.Scanner;

public class Solution_D3_5789 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		int N,Q,L,R;
		int[] box;
		
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			Q = scanner.nextInt();
			box = new int[N+1];
			
			for (int i = 1; i <= Q; i++) {
				L = scanner.nextInt();
				R = scanner.nextInt();
				
				for (int x = L; x <= R; x++) {
					box[x] = i;
				}
			}
			System.out.print("#" + tc);
			for (int kk = 1 ; kk <= N ; kk++) {
				System.out.print(" "+ box[kk] );
			}
			System.out.println();
		}
	}

}