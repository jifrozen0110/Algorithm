package Stack_Queue;
import java.util.*;
import java.io.*;

public class 올바른괄호 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
		String str=br.readLine();
		int cnt=0;
		boolean checkRight=true;
		for(char c:str.toCharArray()){
			if(c=='('){
				cnt+=1;
			}else{
				if(cnt==0) {checkRight=false; break;}
				cnt-=1;
			}
		}
		if(cnt==0&&checkRight==true){
			System.out.print("YES");
		}else{
			System.out.print("NO");
		}
	}
}
