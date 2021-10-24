package Stack_Queue;
import java.util.*;
import java.io.*;

public class 괄호문자제거 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
		String str=br.readLine();
		int cnt=0;
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==')'){
				while(stack.pop()!='(');
			}
			else stack.push(str.charAt(i));
		}

		for(int i=0;i<stack.size();i++){
			System.out.print(stack.get(i));
		}




	}
}
