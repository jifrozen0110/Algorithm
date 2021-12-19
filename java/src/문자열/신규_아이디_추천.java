package 문자열;

public class 신규_아이디_추천 {
	class Solution {
		public String solution(String new_id) {
			String answer = "";

			// 1단계
			new_id=new_id.toLowerCase();

			String step2="";

			//2단계
			for(char c:new_id.toCharArray()){
				if((c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.'){
					step2+=c;
				}
			}


			//3단계
			while(step2.contains("..")){
				step2=step2.replace("..",".");
			}
			//4단계
			if(step2.length()>0){
				if(step2.charAt(0)=='.'){
					step2=step2.substring(1,step2.length());
				}
			}
			if(step2.length()>0){
				if(step2.charAt(step2.length()-1)=='.'){
					step2=step2.substring(0,step2.length()-1);
				}
			}

			//5단계
			if(step2.length()==0){
				step2="a";
			}


			//6단계
			if(step2.length()>=16){
				step2=step2.substring(0,15);
				if(step2.charAt(step2.length()-1)=='.'){
					step2=step2.substring(0,step2.length()-1);
				}
			}

			//7단계
			if(step2.length()<3){
				char c=step2.charAt(step2.length()-1);
				while(step2.length()<3){
					step2+=c;
				}
			}

			return step2;
		}
	}
}
