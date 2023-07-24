import java.util.Scanner;

public class 좋은수열 {
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();

		DFS("");


	}

	public static void DFS(String str){
		if(str.length()==N){
			System.out.println(str);
			System.exit(0);
		}
		for(int i=1;i<=3;i++){
			if(isCheck(str+i)) DFS(str+i);
		}
	}

	public static boolean isCheck(String str){
		for(int i=1;i<=str.length()/2;i++){
			String front=str.substring(str.length()-i*2,str.length()-i);
			String back=str.substring(str.length()-i,str.length());
			if(front.equals(back)){
				return false;
			}
		}
		return true;
	}
}
