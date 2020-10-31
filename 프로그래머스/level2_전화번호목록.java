import java.util.HashMap;

public class level2_전화번호목록 {
	public static void main(String[] args) {
		// 4시
		String[] phone = { "123", "456", "789" };
		boolean x = solution(phone);
		System.out.println(x);
	}

	public static boolean solution(String[] phone_book) {

		HashMap<String, Integer> hm = new HashMap<>();
		for (String x : phone_book) {
			hm.put(x, 1);
		}

		for (String key : hm.keySet()) {
			for (String p : phone_book) {
				if (!p.equals(key) && p.length() <= key.length() && p.equals(key.substring(0, p.length()))) {
					System.out.println(p);
					return false;
				}
			}
		}

		return true;
	}
}
