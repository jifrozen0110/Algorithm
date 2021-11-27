import java.util.*;

public class 리모컨 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		boolean[] broken=new boolean[10];

		int n=sc.nextInt();
		int m=sc.nextInt();
		for(int i=0;i<m;i++){
			int c=sc.nextInt();
			broken[c]=true;
		}
		int target=Math.abs(n-100);
		for(int i=0;i<=999999;i++){
			String str=String.valueOf(i);
			int len=str.length();
			boolean isBroken=false;
			for(int j=0;j<len;j++){
				if(broken[str.charAt(j)-'0']){
					isBroken=true;
					break;
				}
			}
			if(!isBroken){
				int min=Math.abs(n-i)+len;
				target=Math.min(target,min);
			}

		}

		System.out.println(target);
	}

}
