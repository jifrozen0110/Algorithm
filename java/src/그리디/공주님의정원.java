package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Flow;

public class 공주님의정원 {
	static class Flower{
		int startX;
		int startY;
		int endX;
		int endY;
		Flower(int startX,int startY,int endX,int endY){
			this.startX=startX;
			this.startY=startY;
			this.endX=endX;
			this.endY=endY;
		}

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();

		List<Flower> all=new ArrayList<>();

		for(int i=0;i<N;i++){
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			int ex=sc.nextInt();
			int ey=sc.nextInt();
			all.add(new Flower(sx,sy,ex,ey));
		}

		Collections.sort(all, new Comparator<Flower>() {
			@Override
			public int compare(Flower o1, Flower o2) {
				if(o1.startX==o2.startX){
					return Integer.compare(o1.startY,o2.startY);
				}
				return Integer.compare(o1.startX,o2.startX);
			}
		});
		int index=0;
		int e1 = 3;
		int e2 = 1;
		int result=0;
		while(e1<12) {
			int maxEndx=-1;
			int maxEndy=-1;
			boolean isCehck=false;
			while(index<N&&(all.get(index).startX < e1 || (all.get(index).startX == e1 && all.get(index).startY <= e2))){
				if(all.get(index).endX>maxEndx||(all.get(index).endX==maxEndx&&all.get(index).endY>maxEndy)){
					maxEndx=all.get(index).endX;
					maxEndy=all.get(index).endY;
				}
				index++;
				isCehck=true;
			}
			if(!isCehck){
				System.out.println(0);
				return;
			}
			result+=1;
			e1=maxEndx;
			e2=maxEndy;
		}
		System.out.println(result);

	}
}
