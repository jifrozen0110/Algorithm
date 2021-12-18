package 자료구조;
import java.util.*;
public class 로또의_최고_순위와_최저_순위 {
	class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			int[] answer = new int[2];
			answer[0]=answer[1]=6;
			HashSet<Integer> set=new HashSet<>();

			int count0=0;

			for(int i=0;i<lottos.length;i++){
				if(lottos[i]==0){
					count0+=1;
				}else{
					set.add(lottos[i]);
				}
			}

			for(int i=0;i<win_nums.length;i++){
				set.add(win_nums[i]);
			}

			int success=12-count0-set.size();

			if(count0+success>1){
				answer[0]=7-count0-success;
				if(success>1){
					answer[1]=7-success;
				}
			}

			return answer;
		}
	}
}
