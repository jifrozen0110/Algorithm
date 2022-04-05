package 숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 제곱근 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BigInteger n=new BigInteger(br.readLine());

		BigInteger left=new BigInteger("1");
		BigInteger two=new BigInteger("2");
		BigInteger right=n;
		BigInteger mid=null;

		while(left.compareTo(n)<0){
			mid=left.add(right).divide(two);
			BigInteger temp=mid.pow(2);

			if(n.compareTo(temp)==0){
				break;
			}

			if(n.compareTo(temp)<0){
				right=mid;
			}else{
				left=mid.add(new BigInteger("1"));
			}
		}
		System.out.println(mid);
	}
}
