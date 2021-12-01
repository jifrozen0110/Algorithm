package 자료구조;
import java.util.*;
import java.io.*;


public class 이중_우선순위_큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();

		while(T-->0){
			int n=Integer.parseInt(br.readLine());
			TreeMap<Integer,Integer> tm=new TreeMap();
			while(n-->0){
				st=new StringTokenizer(br.readLine());
				String s=st.nextToken();
				int num=Integer.parseInt(st.nextToken());;
				switch(s){
					case "I":
						tm.put(num,tm.getOrDefault(num,0)+1);
						break;
					case "D":
						if(tm.isEmpty()) break;
						if(num==-1){
							int min=tm.firstKey();
							if(tm.get(min)==1){
								tm.remove(min);
							}else{
								tm.put(min,tm.get(min)-1);
							}
						}else{
							int max=tm.lastKey();
							if(tm.get(max)==1){
								tm.remove(max);
							}else{
								tm.put(max,tm.get(max)-1);
							}
						}
						break;
					}
			}
			if(tm.isEmpty()){
				sb.append("EMPTY\n");
			}else{
				sb.append(tm.lastKey()+ " "+ tm.firstKey()+"\n");
			}

		}

		System.out.println(sb.toString());

	}
}
