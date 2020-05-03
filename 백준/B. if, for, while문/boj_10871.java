package baekjoon;

import java.util.Scanner;

public class boj_10871 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		
		int A[] = new int[N];
		
		for (int i=0; i<N; i++) {
			A[i]= scanner.nextInt();
		}
		
		for (int j=0; j<A.length; j++) {
			if (A[j]<X){
				System.out.printf("%d ", A[j]);
			}
		}
	}

}
