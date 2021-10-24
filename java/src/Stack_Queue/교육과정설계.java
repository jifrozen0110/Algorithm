package Stack_Queue;
import java.util.*;

public class 교육과정설계 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		String essential=sc.nextLine();
		String cla=sc.nextLine();

		Queue<Character> q=new LinkedList<>();

		for(int i=0;i<essential.length();i++){
			q.offer(essential.charAt(i));
		}
		boolean check=true;
		for(char c:cla.toCharArray()){
			if(q.contains(c)){
				if(q.poll()!=c){
					check=false;
					break;
				}
			}
		}

		if(!q.isEmpty()) check=false;
		if(check) System.out.print("YES");
		else System.out.print("NO");



	}
}
