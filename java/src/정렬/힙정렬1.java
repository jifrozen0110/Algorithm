package 정렬;

public class 힙정렬1 {
	public static void main(String[] args) {

	}
	private static void heap(int[] arr,int parentIndex,int lastIndex){
		int leftIndex=parentIndex*2+1;
		int rightIndex=parentIndex*2+2;
		int max=arr[parentIndex];
		if(arr[leftIndex]>max){
			max=arr[leftIndex];
		}

		if(arr[rightIndex]>max){
			max=arr[rightIndex];
		}

		if(max!=arr[parentIndex]){
			int temp=arr[parentIndex];
			arr[parentIndex]=max;
			max=temp;
		}

	}
	private static int getParentIndex(int index){
		return (index-1)/2;
	}
	public static void heapSort(int[] arr){
		int size=arr.length;

		if(size<2){
			return;
		}

		int parent=getParentIndex(size-1);
		heap(arr,parent,size-1);
		for(int i=parent;i>=0;i--){//가장 마지막 노드 부모 인덱스부터 뒤에있는 부모 인덱스 가져오기
			heap(arr,i,size-1);
		}

		for(int i=size-1;i>0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heap(arr,0,i-1);//최대힙으로 구성
		}


	}
}
