import java.io.*;
import java.util.*;

public class boj_15552_빠른AB {
	public static void main(String[] args) throws Exception {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int i = Integer.parseInt(bf.readLine());
		
		for (int x=0; x<i; x++) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());			
			int N = Integer.parseInt(st.nextToken());
			int result = M+N;
			bw.write(result+"\n");
		}
		bw.flush();
	}
}