package DFS_BFS;

import java.util.Scanner;

public class 로또 {
	static int n;
	static int[] arr;
	static boolean[] result;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		while(true){
			n=sc.nextInt();

			if(n==0){
				break;
			}
			arr=new int[n];
			result=new boolean[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
			}
			DFS(0,0);
			System.out.println();

		}
	}
	static void DFS(int start, int depth){
		if(depth==6){
			for(int i=0;i<n;i++){
				if(result[i]){
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		for(int i=start;i<n;i++){
			result[i]=true;
			DFS(i+1,depth+1);
			result[i]=false;
		}
	}
}
