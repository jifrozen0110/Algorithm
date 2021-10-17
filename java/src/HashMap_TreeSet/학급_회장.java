package HashMap_TreeSet;

import java.util.*;
import java.io.*;

public class 학급_회장 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String votes=br.readLine();
		HashMap<Character,Integer> leaders=new HashMap<Character,Integer>();
		for(char vote:votes.toCharArray()){
			leaders.put(vote,leaders.getOrDefault(vote,0)+1);
		}
		int max=0;
		char answer = 0;
		for(char key:leaders.keySet()){
			if(leaders.get(key)>max){
				answer=key;
				max=leaders.get(key);
			}
		}

		System.out.print(answer);



	}
}
