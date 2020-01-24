package baekjoon;

import java.io.*;

public class boj_1152 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] lst = S.split(" ");
		int cnt = 0;
		
		for (int j=0; j<lst.length; j++) {
			if (lst[j].length() > 0) {
				cnt += 1;
			}
		}
		System.out.print(cnt);
	}

}
