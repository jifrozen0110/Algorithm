package 정렬;

public class 퀵정렬 {

   private static void sort(int[] arr,int left,int right){
       if(left>=right) return;

       int pivot=partition(arr,left,right);
       sort(arr,left,pivot-1);
       sort(arr,pivot+1,right);
   }

   private static int partition(int[] arr,int left,int right){
       int l=left;
       int r=right;
       int pivot=arr[left];

       while(l<r){
           while(arr[r]>pivot&&l<r){
               r--;
           }
           while(arr[l]<=pivot&&l<r){
               l++;
           }
           swap(arr,l,r);
       }
       swap(arr,left,l);//가장 왼쪽에 있는 원소를 기준으로 나눴기 때문에 현재 l값에 left값 집어넣음
       return l;
   }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int n = 10;
        int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

        sort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
