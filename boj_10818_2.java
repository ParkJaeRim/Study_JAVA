package baekjoon;

import java.io.*;
import java.util.*;

public class boj_10818_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int MAX = Integer.MAX_VALUE;
		int MIN = Integer.MIN_VALUE;
		
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			MIN = Math.min(MIN, num);
			MAX = Math.max(MAX, num);
		}
		System.out.println(MIN+" "+MAX);
				
	}

}
