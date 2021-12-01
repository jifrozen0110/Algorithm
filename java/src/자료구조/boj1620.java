package 자료구조;
import java.util.*;

public class boj1620 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		HashMap<String,String> hm=new HashMap<>();

		int n=sc.nextInt();
		int m=sc.nextInt();

		for(int i=1;i<=n;i++){
			String str=sc.next();
			hm.put(str,String.valueOf(i));
			hm.put(String.valueOf(i),str);
		}

		for(int i=0;i<m;i++){
			String s=sc.next();
			sb.append(hm.get(s)+"\n");
		}

		System.out.println(sb.toString());
	}

}
