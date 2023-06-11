package 자료구조;

public class KMP알고리즘 {
	private static int[] makeTable(String pattern){
		int n=pattern.length();
		int[] table =new int[n];

		int index=0;

		for(int i=1;i<n;i++){
			while(index>0&&pattern.charAt(i)!=pattern.charAt(index)){
				index=table[index-1];
			}
			if (pattern.charAt(i) == pattern.charAt(index)) {
				index++;
				table[i]=index;
			}
		}
		return table;
	}
	public static void KMP(String parent,String pattern){
		int[] table=makeTable(pattern);

		int n1=parent.length();
		int n2=pattern.length();

		int index=0;
		for(int i=0;i<n1;i++){
			while(index>0&&parent.charAt(i)!=pattern.charAt(index)){
				index=table[index-1];
			}
			if(parent.charAt(i)==pattern.charAt(index)){
				if(index==n2-1){
					System.out.println(i-index+1+"번째 발견");
					index=table[index];
				}
				else{
					index++;
				}
			}
		}
	}
	public static void main(String[] args){
		String pattern="abacaaba";
		String parent="ababacabacaabacaaba";
		KMP(parent,pattern);
	}
}
