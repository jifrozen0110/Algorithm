package 자료구조;
import java.util.*;
public class 완주하지_못한_선수 {
	class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String,Integer> set=new HashMap<>();
			for(String str:participant){
				set.put(str,set.getOrDefault(str,0)+1);
			}
			for(String str:completion){
				set.put(str,set.get(str)-1);
			}

			for(String str:set.keySet()){
				if(set.get(str)>0){
					answer=str;
				}
			}

			return answer;
		}
	}
}
