package 정렬;

public class 합병정렬 {
	public static void main(String[] args){
		int[] arr={6,4,2,5,3,7,8,1};
		sort(arr,0,arr.length);
		printArray(arr);
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void sort(int[] arr,int left,int right){
		if(right-left<2){
			return;
		}
		int mid=(left+right)/2;
		sort(arr,0,mid);//쪼개는 과정
		sort(arr,mid,right);
		merge(arr,left,mid,right);
	}
	public static void merge(int[] arr,int left,int mid,int right){
		int[] temp=new int[right-left];//임시 배열 선언
		int index=0, l=left,r=mid;//index와 각 부분 리스트에 첫번째 원소

		while(l<mid&&r<right){
			if(arr[l]<arr[r]){
				temp[index]=arr[l];
				index++;
				l++;
			}else{
				temp[index]=arr[r];
				index++;
				r++;
			}
		}
		//순차적으로 비교하면 나머지 부분 리스트가 남는다. 이걸 집어넣기 위한 코드
		while(l<mid){
			temp[index]=arr[l];
			index++;
			l++;
		}

		while(r<right){
			temp[index]=arr[r];
			index++;
			r++;
		}

		for(int i=left;i<right;i++){
			arr[i]=temp[i-left];
		}
	}
}