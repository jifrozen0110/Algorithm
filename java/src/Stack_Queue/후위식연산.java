package Stack_Queue;
import java.util.*;
import java.io.*;

public class 후위식연산 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();

		Stack<Integer> stack=new Stack<>();

		for(char c: str.toCharArray()){
			if(c=='+'){
				int ch= (stack.pop()+stack.pop());
				stack.push(ch);
			}
			else if(c=='-'){
				int ch= (-stack.pop()+stack.pop());
				stack.push(ch);
			}
			else if(c=='*'){
				int ch= (stack.pop()*stack.pop());
				stack.push(ch);
			}
			else if(c=='/'){
				int ch= (stack.pop()/stack.pop());
				stack.push(ch);
			}
			else{
				stack.push(c-'0');
			}
		}
		System.out.print(stack.pop());



	}
}
