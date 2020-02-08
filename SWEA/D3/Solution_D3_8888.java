package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8888 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= cases; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람수
			int T = Integer.parseInt(st.nextToken()); // 문제수
			int P = Integer.parseInt(st.nextToken()); // 번호
			int[][] test = new int[N][T];
			int[] baejum = new int[T];
			int[] solve = new int[N];
			int[] score= new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < T; j++) {
					test[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < N; j++) {
					if(test[j][i] == 0) {
						baejum[i]++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < T; j++) {
					if(test[i][j] == 1) {
						solve[i]++;
						score[i]  += baejum[j];
					}
				}
			}
			int rank = 0;
			int idx = P-1;
			for (int i = 0; i < score.length; i++) {
				if(idx != i && score[idx] < score[i] ) {
					rank++;
				}
				else if(idx!=i && score[idx]==score[i]) {
					if(solve[idx]<solve[i]) {
						rank++;
					}
					else if(solve[idx]==solve[i] && i<P-1) {
						rank++;
					}
				}
			}
			System.out.println("#"+ tc + " " + score[idx]+ " "+ (rank+1));
		}
	}
}
