package 정렬;
import java.util.*;

public class 힙정렬{
	private static int getParent(int child){
		return (child-1)/2;
	}
	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private static void heapify(int[] arr,int parentIndex,int lastIndex){
		int leftChildIndex;
		int rightChildIndex;
		int max;

		while(2*parentIndex+1<=lastIndex) {//왼쪽 자식 노드와 last비교 왜 왼쪽 자식노드 부터? 오른쪽 자식부터 비교했다가
			//오른쪽 자식 없음 왼쪽 검사 못함
			leftChildIndex=2*parentIndex+1;
			rightChildIndex=2*parentIndex+2;
			max=parentIndex;//최대값이 부모값이라 가정
			if (arr[max] < arr[leftChildIndex]) {//왼쪽이 더 크면 바꿈
				max = leftChildIndex;
			}

			if (rightChildIndex <= lastIndex && arr[max] < arr[rightChildIndex]) {//오른쪽이 더 크면 바꿈
				max = rightChildIndex;
			}

			if (parentIndex != max) {//max값이 부모값이 아니라는건 자식노드값이 더 크다는거
				swap(arr, max, parentIndex);//바꿔줌
				parentIndex=max;//부모값에 max넣어줌
			}else return;
		}
	}
	public static void heapSort(int[] arr){
		int size=arr.length;

		if(size<2){
			return;
		}

		int parentIndex=getParent(size-1);//가장 마지막 노드 부모 인덱스 찾기

		for(int i=parentIndex;i>=0;i--){//가장 마지막 노드 부모 인덱스부터 뒤에있는 부모 인덱스 가져오기
			heapify(arr,i,size-1);
		}

		for(int i=size-1;i>0;i--){
			swap(arr,0,i);//정렬하기 위해 최대값 빼오고 마지막 노드 값을 루느 노드로 바꿔줌
			heapify(arr,0,i-1);//최대힙으로 구성
		}
	}
	public static void main(String[] args){
		int n = 10;
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

		for(int i=0;i<n;i++){
			pq.add(arr[i]);
		}

		for(int i=0;i<n;i++){
			System.out.print(pq.poll()+" ");
		}
		System.out.println();

		int[] arr2 = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		heapSort(arr2);

		for(int i=0;i<n;i++){
			System.out.print(arr2[i]+" ");
		}
	}
}
