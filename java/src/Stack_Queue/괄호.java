package Stack_Queue;

import java.io.*;

public class 괄호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		while(n-->0){
			String str=br.readLine();
			int count=0;
			boolean checkRight=true;
			for(char c:str.toCharArray()){
				if(c=='(') count++;
				else {
					if(count==0) {
						checkRight=false;
						break;
					}
					count--;
				}
			}
			if(count==0&&checkRight==true) {
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}


	}
}
