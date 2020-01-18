package baekjoon;

import java.io.*;
import java.util.*;

public class boj_2920 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int i = 0 ;
		int lst[] = new int[9];
		
		while (st.hasMoreTokens()) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		
		int lst_2[] = lst;
		Arrays.sort(lst);
		if (lst == lst_2) {
			System.out.print("ascending");
		}
//이거 이걸로 풀면 안됨...ArrayList 공부하기...
	}

}
