package ssafy0213;

import java.util.Scanner;

public class Solution_D3_7102 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T= scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			int[] lst = new int[N+M+1];
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 1; i <= N; i++) {
				A[i-1] = i;
			}
			for (int j = 1; j <= M; j++) {
				B[j-1] = j;
			}
			
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B.length; j++) {
						lst[A[i]+B[j]]++;	
				}
			}
			int MaxVal = lst[0];
			for (int i = 1; i < lst.length; i++) {
				if(MaxVal<lst[i]) {
					MaxVal = lst[i];
				}
			}
//			System.out.println(MaxVal);
			System.out.print("#"+ tc );
			for (int i = 0; i < lst.length; i++) {
				if(lst[i]== MaxVal) {
					System.out.print(" "+ i);
				}
			}
			System.out.println();
		}
		
	}

}
