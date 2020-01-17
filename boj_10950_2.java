package baekjoon;
import java.util.Scanner;

public class boj_10950_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		int lst[] = new int[2];
		
		for(int x = 1; x <= T; x++ ) {
			for (int y=0; y<2; y++) {
				lst[y] = scanner.nextInt();
			}
			System.out.println(lst[0]+lst[1]);

		}
	}
}
