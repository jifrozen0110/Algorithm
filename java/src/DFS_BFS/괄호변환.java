package DFS_BFS;
import java.util.*;
public class 괄호변환 {
	class Solution {

		public int checkBalanced(String str){
			int count=0;
			for(int i=0;i<str.length();i++){
				if('('==str.charAt(i)) count++;
				else count--;
				if(count==0){return i;}
			}
			return -1;
		}

		public boolean checkRight(String str){
			int count=0;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='('){
					count++;
				}else{
					if(count==0){
						return false;
					}
					count--;
				}
			}
			return true;

		}
		public String solution(String p) {
			String answer = "";
			if (p.equals("")) return answer;
			int index=checkBalanced(p);
			String u=p.substring(0,index+1);
			String v=p.substring(index+1);
			if(checkRight(u)){
				answer=u+solution(v);
			}
			else{
				answer+="(";
				answer+=solution(v);
				answer+=")";
				u=u.substring(1,u.length()-1);
				for(int i=0;i<u.length();i++){
					if(u.charAt(i)==')') answer+="(";
					else answer+=")";
				}
			}
			return answer;
		}

	}
}
