package 구현;
import java.util.*;

public class 키패드_누르기 {
	class Solution {
		public int lengthCheck(int index,int now){
			index=(index==0)? 11: index;
			now=(now==0)?11:now;
			int x=(index-1)%3;
			int y=(index-1)/3;
			int nowx=1;
			int nowy=(now-1)/3;
			return Math.abs(x-nowx)+Math.abs(y-nowy);
		}
		public String solution(int[] numbers, String hand) {
			String answer = "";
			StringBuilder sb=new StringBuilder();
			int leftIndex=10;
			int rightIndex=12;

			for(int i:numbers){
				if(i==1||i==4||i==7){
					sb.append("L");
					leftIndex=i;
				}else if(i==3||i==6||i==9){
					sb.append("R");
					rightIndex=i;
				}else{
					int left=lengthCheck(leftIndex,i);
					int right=lengthCheck(rightIndex,i);

					if(left<right){
						sb.append("L");
						leftIndex=i;
					}
					else if(left>right){
						sb.append("R");
						rightIndex=i;
					}
					else{
						if(hand.equals("right")){
							sb.append("R");
							rightIndex=i;
						}else{
							sb.append("L");
							leftIndex=i;
						}
					}
				}
			}
			answer=sb.toString();
			return answer;
		}
	}
}
