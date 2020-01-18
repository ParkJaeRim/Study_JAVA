package baekjoon;

import java.io.*;
import java.util.*;

public class boj_10818_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lst[] = new int[N];
		int i=0;
		
		for (i = 0 ; i<N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lst);
		
//		while (st.hasMoreTokens()) {
//			lst[i] = Integer.parseInt(st.nextToken());
//			i++;
//		}
//		
//		Arrays.sort(lst);
		System.out.print(lst[0]+ " "+ lst[lst.length-1]);
	}
}
