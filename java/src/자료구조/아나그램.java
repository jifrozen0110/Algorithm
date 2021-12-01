package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 아나그램 {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();

		for (char alpa : a.toCharArray()) {
			map.put(alpa, map.getOrDefault(alpa, 0) + 1);
		}
		boolean isAna = true;

		for (char alpa : b.toCharArray()) {
			if(!map.containsKey(alpa)||map.get(alpa)==0) {isAna=false; break;}
			map.put(alpa, map.get(alpa) - 1);
		}

		if (isAna) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}

	}

}
