package 이진탐색;

public class 이진탐색 {
	public static void main(String[] args){
		int[] arr={1,2,3,4,5,6,7,8,9};
		int target=8;

		int answer1=binarySearch1(arr,target,arr[0],arr[arr.length-1]);
		int answer2=binarySearch2(arr,target,arr[0],arr[arr.length-1]);

		System.out.println(answer1+"//"+answer2);
	}
	private static int binarySearch1(int[] arr,int target,int start,int end){
		if(start>end) return -1;
		int mid=(start+end)/2;
		if(arr[mid]==target) return mid;
		if(arr[mid]>target) return binarySearch1(arr,target,start,mid-1);
		else return binarySearch1(arr,target,mid+1,end);
	}

	private static int binarySearch2(int[] arr,int target,int start,int end){
		while(start<=end){
			int mid=(start+end)/2;
			if(target==arr[mid]) return mid;
			else if(target<arr[mid]) end=mid-1;
			else if(target>arr[mid]) start=mid+1;
		}
		return -1;
	}
}
