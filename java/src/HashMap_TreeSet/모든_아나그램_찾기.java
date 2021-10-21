package HashMap_TreeSet;
import java.util.*;
import java.io.*;

public class 모든_아나그램_찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String s=br.readLine();
		String t=br.readLine();
		int len=t.length()-1;

		HashMap<Character,Integer> am=new HashMap<>();
		HashMap<Character,Integer> bm=new HashMap<>();
		for(int i=0;i<len+1;i++){
			am.put(t.charAt(i),am.getOrDefault(t.charAt(i),0)+1);
		}

		for(int i=0;i<len;i++){
			bm.put(s.charAt(i),bm.getOrDefault(s.charAt(i),0)+1);
		}
		int lt=0;
		int answer=0;
		for(int rt=len;rt<s.length();rt++){
			bm.put(s.charAt(rt),bm.getOrDefault(s.charAt(rt),0)+1);
			if(am.equals(bm)) answer++;
			bm.put(s.charAt(lt),bm.get(s.charAt(lt))-1);
			if(bm.get(s.charAt(lt))==0){
				bm.remove(s.charAt(lt));
			}
			lt++;
		}

		System.out.print(answer);


	}
}
