import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class level1_완주하지못한선수 {
	// 6시30분 ~4분
	public static void main(String[] args) {

//		String[] participant = { "mislav", "stanko", "mislav", "ana" };
//		String[] completion = { "stanko", "ana", "mislav" };
		String[] participant = { "A", "B", "B" };
		String[] completion = { "A", "B" };
		String a = solution(participant, completion);
//		System.out.println(a);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		int val = 0;
		HashMap<String, Integer> partHM = new HashMap<>();
		for (String part : participant) {
			if (partHM.get(part) == null) {
				partHM.put(part, 1);
			} else {
				val = partHM.get(part) + 1;
				partHM.put(part, val);
			}
		}

		HashSet<String> compHS = new HashSet<>();
		for (int p = 0; p < completion.length; p++) {
			compHS.add(completion[p]);
		}

		Iterator<String> keys = partHM.keySet().iterator();

		for (String comp : completion) {
			val = partHM.get(comp);
			partHM.put(comp, val - 1);
			continue;
		}
		
		for (String x : partHM.keySet()) {
			if(partHM.get(x)!=0) {
				System.out.println(x);
				break;
			}
		}

		return answer;
	}
}
